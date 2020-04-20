import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TreeTraversal {
    private Node root; // root of the binary search tree

    // Representation of a binary search tree
    private class Node {
        private String item;      // node item
        private Node left, right; // left and right subtrees

        // Construct a Node given its item.
        Node(String item) {
            this.item = item;
        }

        // Return a string representation of the node.
        public String toString() {
            return item;
        }
    }

    // Put the item into the tree.
    public void put(String item) {
        root = put(root, item);
    }

    // Helper for put(String item).
    private Node put(Node x, String item) {
        if (x == null) return new Node(item);
        int cmp = item.compareTo(x.item);
        if (cmp < 0) x.left = put(x.left, item);
        else if (cmp > 0) x.right = put(x.right, item);
        return x;
    }

    // Return the nodes of the tree traversed pre-order.
    public Iterable<Node> preOrder() {
        Queue<Node> q = new Queue<Node>();  // create new queue
        preOrder(root, q);                  // do pre-order traversal
        return q;                           // return the queue
    }

    // Helper for preOrder().
    private void preOrder(Node x, Queue<Node> q) {
        if (x != null)              // if node is not null
        {
            q.enqueue(x);           // add current node to queue
            preOrder(x.left, q);    // traverse left subtree
            preOrder(x.right, q);   // traverse right subtree
        }
    }

    // Return the nodes of the tree traversed in-order.
    public Iterable<Node> inOrder() {
        Queue<Node> q = new Queue<Node>();  // create new queue
        inOrder(root, q);                   // do in-order traversal
        return q;                           // return the queue
    }

    // Helper for inOrder().
    private void inOrder(Node x, Queue<Node> q) {
        if (x != null)              // if node is not null
        {
            inOrder(x.left, q);     // traverse left subtree
            q.enqueue(x);           // add current node to queue
            inOrder(x.right, q);    // traverse right subtree
        }
    }

    // Return the nodes of the tree traversed post-order.
    public Iterable<Node> postOrder() {
        Queue<Node> q = new Queue<Node>();  // create new queue
        postOrder(root, q);                 // do post-order traversal
        return q;                           // return the queue
    }

    // Helper for postOrder().
    private void postOrder(Node x, Queue<Node> q) {
        if (x != null)              // if node is not null
        {
            postOrder(x.left, q);   // traverse left subtree
            postOrder(x.right, q);  // traverse right subtree
            q.enqueue(x);           // add current node to queue
        }
    }

    // Return the nodes of the tree traversed level-order.
    public Iterable<Node> levelOrder() {
        Queue<Node> level = new Queue<Node>();  // queue to iterate through each level
        Queue<Node> q = new Queue<Node>();      // queue to store nodes in each level

        if (root != null)           // if root is not null
        {
            level.enqueue(root);    // add root to level
        }
        // level-order traversal
        while (!level.isEmpty())            // while level is not empty
        {
            Node node = level.peek();       // get first node in level
            level.dequeue();                // remove first node in level
            if (node.left != null)          // if left subtree is not null
            {
                level.enqueue(node.left);   // add left subtree to level
            }
            if (node.right != null)         // if right subtree is not null
            {
                level.enqueue(node.right);  // add right subtree to level
            }
            q.enqueue(node);                // add current node to queue
        }
        return q;                           // return the queue
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        String[] items = StdIn.readAllStrings();
        TreeTraversal tree = new TreeTraversal();
        for (String item : items) {
            tree.put(item);
        }
        StdOut.println("Pre-order:   " + tree.preOrder());
        StdOut.println("In-order:    " + tree.inOrder());
        StdOut.println("Post-order:  " + tree.postOrder());
        StdOut.println("Level-order: " + tree.levelOrder());
    }
}

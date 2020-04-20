import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PostOrder {
    static int preIndex = 0;    // current index of pre-order

    // utility function to find x in arr from a starting index to an ending index
    int search(int[] arr, int start, int end, int x) {
        int i = 0;
        for (i = start; i < end; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return i;
    }

    // prints the post order from given in-order and pre-order traversals
    void PostOrder(int[] in, int[] pre, int inStart, int inEnd) {
        if (inStart > inEnd)    // base case
        {
            return;
        }

        // root is always the first item in pre-order traversal
        // and it must be the last item in post-order traversal
        // find index of next item in pre-order in in-order
        // preIndex is incremented to find next item in next call
        int root = search(in, inStart, inEnd, pre[preIndex++]);

        // recursively traverse left subtree
        // all elements before root in in[] are elements of left subtree
        PostOrder(in, pre, inStart, root - 1);

        // recursively traverse right subtree
        // all elements after root in in[] are elements of right subtree
        PostOrder(in, pre, root + 1, inEnd);

        // print root node at the end of post-order traversal
        StdOut.print(in[root] + ",");
    }

    // driver code
    public static void main(String[] args) {
        String inOrder = StdIn.readLine();      // read first line as in-order string input
        String[] inO = inOrder.split(",");      // split in-order into array w/ comma as delimiter
        int[] in = new int[inO.length];         // create int array for in-order
        for (int i = 0; i < in.length; i++) {
            in[i] = Integer.parseInt(inO[i]);   // transfer elements from string array to int array
        }
        String preOrder = StdIn.readLine();     // read second line as pre-order string input
        String[] preO = preOrder.split(",");    // split pre-order into array w/ comma as delimiter
        int[] pre = new int[preO.length];       // create int array for pre-order
        for (int i = 0; i < pre.length; i++) {
            pre[i] = Integer.parseInt(preO[i]); // transfer elements from string array to int array
        }
        int length = in.length;                 // variable for length of in
        PostOrder post = new PostOrder();       // create new post-order
        post.PostOrder(in, pre, 0, length - 1); // call to print post-order
    }
}

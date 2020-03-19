import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF {
    private int[] parent;  // parent[i] = parent of i
    private int count;     // number of components

    /**
     * Initializes an empty union-find data structure with
     * {@code n} elements {@code 0} through {@code n-1}.
     * Initially, each elements is in its own set.
     *
     * @param n the number of elements
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public QuickUnionUF(int n) {
        parent = new int[n]; // create new structure
        count = n;           // number of components
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // set parent of each object to itself (Lec 2, Slide 24)
        }
    }

    /**
     * Returns the number of sets.
     */
    public int count() {
        return count;       // return count
    }

    /**
     * Returns the canonical element of the set containing element {@code p}.
     *
     * @param p an element
     * @return the canonical element of the set containing {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    public int find(int p) {
        while (p != parent[p])  // chase parent pointers until reach root (Lec 2, Slide 24)
        {
            p = parent[p];
        }
        return p;               // return root
    }

    /**
     * Returns true if the two elements are in the same set.
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);  // are p and q the same component (Lec 2, Slide 9)
    }

    /**
     * Merges the set containing element p with the
     * the set containing element  q.
     **/
    public void union(int p, int q) {
        int rootOfP = find(p);
        int rootOfQ = find(q);
        if (rootOfP == rootOfQ)         // if they are already the same, return
        {
            return;
        }
        parent[rootOfP] = rootOfQ;      // change root of p to point to root of q (Lec 2, Slide 24)
        count--;                        // decrement number of components by 1 since we made a union
    }

    /**
     * Reads in a an integer and a sequence of pairs of integers
     * from standard input, where each integer
     * in the pair represents some element;
     * if the elements are in different sets, merge the two sets
     * and print the pair to standard output.
     * [DO NOT CHANGE CODE IN MAIN]
     */
    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }


}

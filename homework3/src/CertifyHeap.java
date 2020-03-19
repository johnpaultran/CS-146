import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class CertifyHeap {
    // Return true of v is less than w and false otherwise.
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // Return true if a[] represents a maximum-ordered heap and false
    // otherwise. Remember to index from 1.
    private static boolean maxOrderedHeap(Comparable[] a) {
        int N = a.length;   // N is length of array
        // iterate through array starting from index 1
        for (int i = 1; i < N; i++) {
            // if left child (2k) exists and it is > parent
            if (2 * i < N && less(a[i], a[2 * i])) {
                return false;   // cannot be true for max order
            }
            // if right child (2k + 1) exits and it is > parent
            if ((2 * i + 1) <= N && less(a[i], a[2 * i + 1])) {
                return false;   // cannot be true for max order
            }
        }
        // if above conditions are met then it is = max order
        return true;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        StdOut.println(maxOrderedHeap(a));
    }
}

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class MergeQueues {
    // Return true if v is less than w and false otherwise.
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // Merge and return the two sorted queues as a single sorted queue.
    private static Queue<Comparable> merge(Queue<Comparable> q1,
                                           Queue<Comparable> q2) {
        // create new q for the two queues to be merged in sorted order
        Queue<Comparable> merged = new Queue<Comparable>();
        // create iterators for q1 and q2
        Iterator<Comparable> i1 = q1.iterator();
        Iterator<Comparable> i2 = q2.iterator();
        // create two comparable items for each q
        Comparable item1 = null;
        Comparable item2 = null;

        if (i1.hasNext())       // if iterator has more items from q1
        {
            item1 = i1.next();  // item1 is the next item in q1
        }
        if (i2.hasNext())       // if iterator has more items from q2
        {
            item2 = i2.next();  // item2 is the next item in q2
        }

        // enqueue items to merged in order
        // while item1 & item2 still have items from q1 & q2
        while (item1 != null && item2 != null) {
            // enqueue the lesser value to merged at each iteration
            if (less(item1, item2))       // if item1 < item2
            {
                merged.enqueue(item1);   // add item1 to merged
                // update iteration for while loop
                if (i1.hasNext()) {
                    item1 = i1.next();
                } else {
                    item1 = null;
                }
            } else // if item2 < item1
            {
                merged.enqueue(item2); // add item2 to merged
                // update iteration for while loop
                if (i2.hasNext()) {
                    item2 = i2.next();
                } else {
                    item2 = null;
                }
            }
        }

        // once one q is empty, add all the remaining items of the other q in merged
        while (i1.hasNext())        // remaining items in q1
        {
            item1 = i1.next();
            merged.enqueue(item1);  // add to merged
        }
        while (i2.hasNext())        // remaining items in q2
        {
            item2 = i2.next();
            merged.enqueue(item2);  // add to merged
        }
        return merged;  // return the sorted queue
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        String[] a = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Queue<Comparable> q1 = new Queue<Comparable>();
        Queue<Comparable> q2 = new Queue<Comparable>();
        for (String s : a) {
            if (StdRandom.bernoulli(0.5)) {
                q1.enqueue(s);
            } else {
                q2.enqueue(s);
            }
        }
        int s1 = q1.size(), s2 = q2.size();
        StdOut.println(merge(q1, q2));
        assert q1.size() == s1 && q2.size() == s2;
    }
}

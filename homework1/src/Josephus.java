// Josephus.java: Takes N and M from the command line and prints out the order
// in which people are eliminated (and thus would show Josephus where to sit in
// the circle).

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Josephus {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // give n for number of people
        int m = Integer.parseInt(args[1]); // give m for the mth position eliminated

        // initialize the queue
        Queue<Integer> q = new Queue<Integer>();
        for (int i = 0; i < n; i++) {
            q.enqueue(i);       // add number to queue to represent position from 0 to (n-1)
        }

        while (!q.isEmpty()) // eliminating positions from the q
        {
            for (int i = 0; i < m - 1; i++) // push safe position to the back of q
            {
                q.enqueue(q.dequeue());
            }
            // eliminate every mth position
            int eliminatedPos = q.dequeue();
            StdOut.print(eliminatedPos + " ");  // print out eliminated positions
        }
    }
}

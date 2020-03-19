// KthString.java: Takes a command-line argument k and prints
// the kth string from the end found on standard input,
// assuming that standard input has k or more strings.

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class KthString {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);  // give k for kth string from end
        String[] input = StdIn.readAllStrings(); // read standard input (assuming it has k or more strings)

        // initialize the queue
        Queue<String> q = new Queue<String>();
        for (int i = 0; i < input.length; i++) {
            q.enqueue(input[i]); // add each string from input into q
        }

        int p = q.size() - k;   // get the position of kth string

        for (int i = 0; i < p; i++) // loop through first few strings of input
        {
            String x = q.dequeue(); // start taking strings out from q
            if (i == p - 1) // hit target kth string from end
            {
                StdOut.println(x);  // print the string
            }
        }
    }
}

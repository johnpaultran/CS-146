import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Takes a command-line integer k; reads in a sequence of strings from
// standard input; and prints out exactly k of them, uniformly at random.
// Note that each item from the sequence is printed out at most once.
public class Subset {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);  // k = argument from command line
        // queue is random queue for sequence of strings from command line
        // queue will randomize the output of the sequence of strings
        ResizingArrayRandomQueue<String> queue = new ResizingArrayRandomQueue<String>();
        while (!StdIn.isEmpty()) // while there are strings still in command line
        {
            queue.enqueue(StdIn.readString());  // add each string to queue
        }
        for (int i = 0; i < k; i++)     // for each string in command line
        {
            StdOut.println(queue.dequeue());    // print out strings at random on new lines
        }
    }
}

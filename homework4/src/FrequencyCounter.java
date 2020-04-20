// FrequencyCounter.java: Reads in a command-line integer and sequence of words
// from standard input and prints out all the words (whose length exceeds the
// threshold) that occur most frequently to standard output. It also prints out
// the number of words whose length exceeds the threshold and the number of
// distinct such words.

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {
    public static void main(String[] args) {
        int words = 0;                              // total number of words
        int distinct = 0;                           // total number of distinct words
        int minLength = Integer.parseInt(args[0]);  // threshold from program argument
        // create a new symbol table
        ArrayST<String, Integer> frequency = new ArrayST<String, Integer>();

        while (!StdIn.isEmpty())                    // while standard input is not empty
        {
            String key = StdIn.readString();        // read key from standard input
            if (key.length() < minLength)           // if length of key < threshold
            {
                continue;                           // continue to next iteration of loop
            }
            words++;                                // increment number of words
            if (frequency.contains(key))            // if symbol table has current key
            {
                frequency.put(key, frequency.get(key) + 1); // increment value of key by 1
            } else {
                frequency.put(key, 1);              // insert current key
                distinct++;                         // increment number of distinct words
            }
        }

        String highest = "";                        // create string to hold most frequent word
        frequency.put(highest, 0);                  // insert key into symbol table
        for (String word : frequency.keys())        // for each key in symbol table
        {
            if (frequency.get(word) > frequency.get(highest))   // if value of current key > highest
            {
                highest = word;                     // set highest to current key
            }
        }

        // print the results
        StdOut.println(highest + " " + frequency.get(highest));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
    }
}

// AvgGPA.java: Reads from standard input a list of letter grades and computes
// and prints the average GPA (the average of the numbers corresponding to
// the grades).

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class AvgGPA {
    public static void main(String[] args) {
        // create a new symbol table
        ArrayST<String, Double> grades = new ArrayST<String, Double>();
        // insert each grade and their GPA value into symbol table
        grades.put("A+", 4.33);
        grades.put("A", 4.0);
        grades.put("A-", 3.67);
        grades.put("B+", 3.33);
        grades.put("B", 3.0);
        grades.put("B-", 2.67);
        grades.put("C+", 2.33);
        grades.put("C", 2.0);
        grades.put("C-", 1.67);
        grades.put("D", 1.0);
        grades.put("F", 0.0);

        int N = 0;                              // counter for number of grades inputted
        double total = 0.0;                     // sum of each grade value from input
        for (N = 0; !StdIn.isEmpty(); N++)      // for each grade in standard input
        {
            String grade = StdIn.readString();  // read grade from standard input
            double value = grades.get(grade);   // read GPA value from grade in symbol table
            total += value;                     // add current GPA value to total
        }
        double GPA = total / N;                 // calculate GPA
        StdOut.println("GPA = " + GPA);         // print result
    }
}

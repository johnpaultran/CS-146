import edu.princeton.cs.algs4.StdOut;

// A data type representing a six-sided die.
public class Die implements Comparable<Die> {

    private int value; // face value

    // constructor
    public Die() {
        value = 0;  // initialize value as 0
    }

    // Roll the die.
    public void roll() {
        value = (int) (Math.random() * 6) + 1; // assign value to a random number between 1 to 6
    }

    // Face value of the die.
    public int value() {
        return value;   // return value after die is rolled
    }

    // Does the die have the same face value as that?
    public boolean equals(Die that) {
        return this.value == that.value;    // returns true if two dice are the same
    }

    // A negative integer, zero, or positive integer depending on whether this
    // die's value is less than, equal to, or greater than the that die's value.
    public int compareTo(Die that) {
        return this.value - that.value; // returns difference of two dice (<, = , or >)
    }

    // A string representation of the die giving the current face value.
    public String toString() {
        String stringRep = "";  // create string
        if (value == 1) // checks if current value is 1
        {
            stringRep += "     \n  *  \n     "; // adds the string representation into stringRep
        }
        if (value == 2) // checks if current value is 2
        {
            stringRep += "*    \n     \n    *"; // adds the string representation into stringRep
        }
        if (value == 3) // checks if current value is 3
        {
            stringRep += "*    \n  *  \n    *"; // adds the string representation into stringRep
        }
        if (value == 4) // checks if current value is 4
        {
            stringRep += "*   *\n     \n*   *"; // adds the string representation into stringRep
        }
        if (value == 5) // checks if current value is 5
        {
            stringRep += "*   *\n  *  \n*   *"; // adds the string representation into stringRep
        }
        if (value == 6) // checks if current value is 6
        {
            stringRep += "*   *\n*   *\n*   *"; // adds the string representation into stringRep
        }
        return stringRep; // returns the string representation of current face value
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        Die a = new Die();
        a.roll();
        while (a.value() != x) {
            a.roll();
        }
        Die b = new Die();
        b.roll();
        while (b.value() != y) {
            b.roll();
        }
        Die c = new Die();
        c.roll();
        while (c.value() != z) {
            c.roll();
        }
        StdOut.println(a);
        StdOut.println(a.equals(b));
        StdOut.println(b.equals(c));
        StdOut.println(a.compareTo(b));
        StdOut.println(b.compareTo(c));
    }
}

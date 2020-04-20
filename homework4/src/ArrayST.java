import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ArrayST<Key, Value> {
    private static final int INIT_CAPACITY = 2; // size declaration
    private Key[] keys;                         // keys in symbol table
    private Value[] values;                     // values in symbol table
    private int N;                              // number of elements in table

    // Create a symbol table with INIT_CAPACITY.
    public ArrayST() {
        keys = (Key[]) new Object[INIT_CAPACITY];
        values = (Value[]) new Object[INIT_CAPACITY];
    }

    // Create a symbol table with given capacity.
    public ArrayST(int capacity) {
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
    }

    // Return the number of key-value pairs in the table.
    public int size() {
        return N;
    }

    // Return true if the table is empty and false otherwise.
    public boolean isEmpty() {
        return size() == 0;             // true if size is zero
    }

    // Return true if the table contains key and false otherwise.
    public boolean contains(Key key) {
        for (int i = 0; i < N; i++)     // for each key in symbol table
        {
            if (keys[i].equals(key))    // if key in table matches search key
            {
                return true;            // search hit
            }
        }
        return false;                   // search misses
    }

    // Return the value associated with key, or null.
    public Value get(Key key) {
        for (int i = 0; i < N; i++)     // for each key in symbol table
        {
            if (keys[i].equals(key))    // if key in table matches search key
            {
                return values[i];       // return the value of key
            }
        }
        return null;                    // return null if search misses
    }

    // Put the kev-value pair into the table; remove key from table
    // if value is null.
    public void put(Key key, Value value) {
        delete(key);                // delete key to avoid duplicates
        if (N >= values.length)     // if number of elements >= number of values
        {
            resize(2 * N);          // double size of arrays
        }
        keys[N] = key;              // add new key to end of array
        values[N] = value;          // add new value to end of array
        N++;                        // increment number of elements
    }

    // Remove key (and its value) from table.
    public void delete(Key key) {
        for (int i = 0; i < N; i++)         // for each key in symbol table
        {
            if (keys[i].equals(key))        // if key in table matches search key
            {
                // set current key and its value to last index of symbol table
                keys[i] = keys[N - 1];
                values[i] = values[N - 1];
                // delete by setting to null
                keys[N - 1] = null;
                values[N - 1] = null;
                N--;                            // decrement number of elements
                if (N > 0 && N == keys.length / 4) {
                    resize(keys.length / 2);    // resize array if necessary
                }
                return;
            }
        }
    }

    // Return all the keys in the table.
    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();    // create queue
        for (int i = 0; i < N; i++)         // for each key in symbol table
        {
            q.enqueue(keys[i]);             // add current to queue
        }
        return q;                           // return queue of keys
    }

    // Resize the internal arrays to capacity.
    private void resize(int capacity) {
        Key[] tempk = (Key[]) new Object[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        ArrayST<String, Integer> st = new ArrayST<String, Integer>();
        int count = 0;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            st.put(s, ++count);
        }
        for (String s : args) {
            st.delete(s);
        }
        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}

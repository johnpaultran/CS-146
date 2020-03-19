import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Random queue implementation using a resizing array.
public class ResizingArrayRandomQueue<Item> implements Iterable<Item> {
    private Item[] q;   // array to store items of queue
    private int N;      // the size of the queue

    // Construct an empty queue.
    public ResizingArrayRandomQueue() {
        // initialize instance variables
        q = (Item[]) new Object[2]; // initial capacity of 2
        N = 0;                      // initial size of queue
    }

    // Is the queue empty?
    public boolean isEmpty() {
        return N == 0;          // if N is 0 (empty), return true
    }

    // The number of items on the queue.
    public int size() {
        return N;               // return size of queue
    }

    // Add item to the queue.
    public void enqueue(Item item) {
        if (item == null)         // if client attempts to add a null item, throw exception
            throw new NullPointerException();
        if (N == q.length)        // if q is at full capacity
            resize(2 * q.length); // double size of array if necessary
        q[N++] = item;            // increment N by 1
    }

    // Remove and return a random item from the queue.
    public Item dequeue() {
        if (N == 0) //if the client attempts to dequeue an item from an empty randomized queue, throw exception
            throw new NoSuchElementException();
        int r = StdRandom.uniform(N);   // r = random integer from [0, N)
        Item item = q[r];               // item = random item from q
        q[r] = q[--N];                  // set q[r] to N - 1
        q[N] = null;                    // make q[N] null
        // shrink size of items if necessary
        if (N > 0 && N == q.length / 4) // if q is at quarter capacity
            resize(q.length / 2);       // resize to half capacity
        return item;                    // return random item
    }

    // Return a random item from the queue, but do not remove it.
    public Item sample() {
        if (N == 0) // if the client attempts to sample an item from an empty randomized queue, throw exception
            throw new NoSuchElementException();
        int r = StdRandom.uniform(N);   // r = random integer from [0, N)
        return q[r];                    // return random item from q
    }

    // An independent iterator over items in the queue in random order.
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();   // return object of type RandomQueueIterator
    }

    // An iterator, doesn't implement remove() since it's optional.
    private class RandomQueueIterator implements Iterator<Item> {
        private int current;        // index of current item in items
        private Item[] items;       // new array to store items of q

        RandomQueueIterator() {
            items = (Item[]) new Object[N];         // create items with same capacity as q
            System.arraycopy(q, 0, items, 0, N);    // copy items of q into items
            StdRandom.shuffle(items);               // shuffle items
            current = 0;                            // initialize current
        }

        public boolean hasNext() {
            return current < N;     // checks if iterator has more elements to iterate or not, return true if yes
        }

        public void remove() {
            throw new UnsupportedOperationException();  // given
        }

        public Item next() {
            if (!hasNext())     // if next() is called and there are no more items to return, throw exception
                throw new NoSuchElementException();
            Item now = items[current];  // now is the item at current index
            current++;                  // advance current by 1
            return now;                 // return item at current index

        }
    }

    // A string representation of the queue.
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString().substring(0, s.length() - 1);
    }

    // Helper method for resizing the underlying array.
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            if (q[i] != null) {
                temp[i] = q[i];
            }
        }
        q = temp;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        ResizingArrayRandomQueue<Integer> q =
                new ResizingArrayRandomQueue<Integer>();
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readInt());
        }
        int sum1 = 0;
        for (int x : q) {
            sum1 += x;
        }
        int sum2 = sum1;
        for (int x : q) {
            sum2 -= x;
        }
        int sum3 = 0;
        while (q.size() > 0) {
            sum3 += q.dequeue();
        }
        StdOut.println(sum1);
        StdOut.println(sum2);
        StdOut.println(sum3);
        StdOut.println(q.isEmpty());
    }
}

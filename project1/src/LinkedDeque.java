import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Deque implementation using a linked list.
public class LinkedDeque<Item> implements Iterable<Item> {
    private Node head;  //head of the deque
    private Node tail;  //tail of the deque
    private int size;   //size of the deque

    // Helper doubly-linked list class.
    private class Node {
        private Item item;
        private Node next;
        private Node prev;

        // Gets item from Node
        public Item getItem() {
            return item;
        }

        // Sets item in Node
        public void setItem(Item item) {
            this.item = item;
        }

        // Gets next Node
        public Node getNext() {
            return next;
        }

        // Gets previous Node
        public Node getPrev() {
            return prev;
        }

        // Sets next Node
        public void setNext(Node next) {
            this.next = next;
        }

        // Sets previous Node
        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    // Construct an empty deque.
    public LinkedDeque() {
        size = 0;
        head = null;
        tail = null;
    }

    // Is the deque empty?
    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    // The number of items on the deque.
    public int size() {
        return size;
    }

    // Add item to the front of the deque.
    public void addFirst(Item item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException("Cannot add null item to beginning of deque");
        }
        Node n = new Node();    //n = temporary Node
        n.setItem(item);
        if (isEmpty()) {      //if item is added to empty deque, set n as head and tail (deque now has 1 node)
            head = n;
            tail = n;
        } else {
            head.setPrev(n);    //else, item is added to non-empty deque
            n.setNext(head);
            head = n;
        }
        size++;                 //increment deque size
    }

    // Add item to the end of the deque.
    public void addLast(Item item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException("Cannot add null item to end of deque");
        }
        Node n = new Node();    //n = temporary Node
        n.setItem(item);
        if (isEmpty()) {         //if item is added to empty deque, set n as head and tail (deque now has 1 node)
            head = n;
            tail = n;
        } else {                 //else item is added to non-empty deque
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }
        size++;                 //increment deque size
    }

    // Remove and return item from the front of the deque.
    public Item removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove first item from empty deque");
        }
        if (size == 1) {    //remove last item in deque of size 1
            Item item = head.getItem(); //item = item to be removed
            head = null;
            tail = null;
            return item;
        }
        Node n = head;  //n = temporary Node
        head = head.getNext();  //assign 2nd node as new head, "removing" previous head from deque
        size--;
        return n.getItem();
    }

    // Remove and return item from the end of the deque.
    public Item removeLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove last item from empty deque");
        }
        if (size == 1) {    //remove 1 item in deque of size 1
            Item item = tail.getItem(); //item = item to be removed
            head = null;
            tail = null;
            return item;
        }
        Node n = tail;  //n = temporary Node
        tail = tail.getPrev();  //assign 2nd-to-last node as new tail, "removing" previous tail from deque
        size--;
        return n.getItem();
    }

    // An iterator over items in the queue in order from front to end.
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // An iterator, doesn't implement remove() since it's optional.
    public class DequeIterator implements Iterator<Item> {
        private Node current;   //current = current Node

        // Constructor
        DequeIterator() {
            current = head;    //head = head of deque
        }

        // Returns whether Node has succeeding Node
        public boolean hasNext() {
            return current != null;
        }

        // Removes current Node
        public void remove() {
            throw new UnsupportedOperationException();
        }

        // Returns current Item then iterate to next Node
        public Item next() throws NoSuchElementException {
            if (isEmpty()) {
                throw new NoSuchElementException("Cannot retrieve item from empty deque");
            }
            Item item = current.getItem();  //item = current item to be returned
            current = current.getNext();
            return item;
        }
    }

    // A string representation of the deque.
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString().substring(0, s.length() - 1);
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        LinkedDeque<Character> deque = new LinkedDeque<Character>();
        String quote = "There is grandeur in this view of life, with its "
                + "several powers, having been originally breathed into a few "
                + "forms or into one; and that, whilst this planet has gone "
                + "cycling on according to the fixed law of gravity, from so "
                + "simple a beginning endless forms most beautiful and most "
                + "wonderful have been, and are being, evolved. ~ "
                + "Charles Darwin, The Origin of Species";
        int r = StdRandom.uniform(0, quote.length());
        for (int i = quote.substring(0, r).length() - 1; i >= 0; i--) {
            deque.addFirst(quote.charAt(i));
        }
        for (int i = 0; i < quote.substring(r).length(); i++) {
            deque.addLast(quote.charAt(r + i));
        }
        StdOut.println(deque.isEmpty());
        StdOut.printf("(%d characters) ", deque.size());
        for (char c : deque) {
            StdOut.print(c);
        }
        StdOut.println();
        double s = StdRandom.uniform();
        for (int i = 0; i < quote.length(); i++) {
            if (StdRandom.bernoulli(s)) {
                deque.removeFirst();
            } else {
                deque.removeLast();
            }
        }
        StdOut.println(deque.isEmpty());

    }
}

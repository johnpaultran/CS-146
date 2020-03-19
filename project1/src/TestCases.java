import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCases {
    @Test
    public void test1() {
        LinkedDeque<Integer> q = new LinkedDeque<Integer>();
        q.addFirst(2);
        q.addLast(5);
        assertEquals(2, q.size());
    }

    @Test
    public void test2() {
        LinkedDeque<Integer> empty = new LinkedDeque<Integer>();
        assertTrue(empty.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void test3() {
        LinkedDeque<Integer> nullInsert = new LinkedDeque<Integer>();
        nullInsert.addFirst(null);
    }

    @Test
    public void test4() {
        LinkedDeque<Integer> q = new LinkedDeque<Integer>();
        q.addFirst(2);
        q.addFirst(1);
        q.addLast(3);
        q.addLast(4);

        for (int i = 1; i < 5; i++) {
            assertEquals(i, q.removeFirst().intValue());
        }
    }

    @Test
    public void test5() {
        ResizingArrayRandomQueue<Integer> empty = new ResizingArrayRandomQueue<Integer>();
        assertTrue(empty.isEmpty());
    }

    @Test
    public void test6() {
        ResizingArrayRandomQueue<Integer> q = new ResizingArrayRandomQueue<Integer>();
        q.enqueue(3);
        q.enqueue(2);
        q.dequeue();
        assertEquals(1, q.size());
    }

    @Test
    public void test7() {
        ResizingArrayRandomQueue<Integer> q = new ResizingArrayRandomQueue<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.dequeue();
        q.enqueue(5);
        q.dequeue();
        q.dequeue();
        assertEquals(2, q.size());
    }

    @Test
    public void test8() {
        LinkedDeque<Integer> q = new LinkedDeque<Integer>();
        q.addFirst(5);
        q.addFirst(4);
        q.addLast(6);
        q.addLast(7);
        q.addFirst(3);
        q.addLast(8);
        q.addFirst(2);
        q.addFirst(1);

        for (int i = 1; i < 9; i++) {
            assertEquals(i, q.removeFirst().intValue());
        }
    }

    @Test
    public void test9() {
        LinkedDeque<Integer> q = new LinkedDeque<Integer>();
        q.addFirst(5);
        q.addFirst(4);
        q.addLast(6);
        q.addLast(7);
        q.addFirst(3);
        q.addLast(8);
        q.addFirst(2);
        q.addFirst(1);
        q.addLast(10);
        q.addFirst(11);

        assertEquals(10, q.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void test10() {
        ResizingArrayRandomQueue<Integer> empty = new ResizingArrayRandomQueue<Integer>();
        empty.sample();
    }
}

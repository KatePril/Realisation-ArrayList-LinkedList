import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLinkedList {
    @Test
    public void testAdd() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);

        assertEquals(1, list.get(0));
    }

    @Test
    public void testAddIndex() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(0, 2);

        assertEquals(2, list.get(0));
    }

    @Test
    public void testAddFirst() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(10);

        assertEquals(10, list.get(0));
    }

    @Test
    public void testAddLast() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(20);

        assertEquals(20, list.get(0));
    }

    @Test
    public void testGetFirst() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.getFirst());
    }

    @Test
    public void testGetLast() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.getLast());
    }

    @Test
    public void testGet() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(2, list.get(1));
    }

    @Test
    public void testSet() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(2, list.set(1, 4));
    }

    @Test
    public void testRemoveFirst() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.removeFirst());
    }

    @Test
    public void testRemoveLast() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.removeLast());
    }

    @Test
    public void testRemove() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.remove());
    }

    @Test
    public void testRemoveIndex() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(2, list.remove(1));
    }

    @Test
    public void testRemoveObject() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.remove(new Integer(2)));
    }

    @Test
    public void testToString() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    public void testSize() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
    }
}

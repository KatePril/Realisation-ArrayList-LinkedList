import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestArrayList {
    @Test
    public void testAdd() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);

        assertEquals(1, list.get(0));
    }

    @Test
    public void testAddIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(0, 1);

        assertEquals(1, list.get(0));
    }

    @Test
    public void testGetIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);

        assertEquals(1, list.get(0));
    }

    @Test
    public void testGetObject() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);

        assertEquals(0, list.get(new Integer(1)));
    }

    @Test
    public void testSet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);

        assertEquals(1, list.set(0, 2));
    }

    @Test
    public void testRemoveIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);

        assertEquals(1, list.remove(0));
    }

    @Test
    public void testRemoveObject() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);

        assertTrue(list.remove(new Integer(1)));
    }

    @Test
    public void testToString() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);

        assertEquals("[1]", list.toString());
    }

    @Test
    public void testSize() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);

        assertEquals(1, list.size());
    }
}

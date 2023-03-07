public interface MyList<E> {
    void add(E element);

    void add(int index, E element);

    E get(int index);

    E set(int index, E element);

    E remove(int index);

    boolean remove(E object);

    String toString();

    int size();

    boolean isEmpty();
}

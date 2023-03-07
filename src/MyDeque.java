public interface MyDeque<E> {
    void addFirst(E element);

    void addLast(E element);

    E getFirst();

    E getLast();

    E removeFirst();

    E removeLast();

    E remove();
}

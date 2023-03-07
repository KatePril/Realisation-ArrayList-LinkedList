import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E>, MyDeque<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public MyLinkedList() {
    }

    public MyLinkedList(MyLinkedList<E> collection) {
        this.first = collection.first;
        this.last = collection.last;
        this.size = collection.size;
    }

    @Override
    public void add(E element) {
        if (size == 0) {
            first = new Node<E>(element);
            last = first;
            first.next = last;
            last.previous = first;
        } else {
            Node<E> newNode = new Node<>(element);
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index == 0) {
            first = new Node<E>(element);
            last = first;
            first.next = last;
            last.previous = first;
            size++;
        } else if (index == size) {
            Node<E> newNode = new Node<>(element);
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
            size++;
        } else if (index < size) {
            if (index < size/2) {
                Node<E> node = first;
                for (int i = 1; i < index; i++) {
                    node = node.next;
                }
                Node<E> newNode = new Node<>(element);
                newNode.next = node.next;
                newNode.previous = node;
                node.next = newNode;
                newNode.next.previous = newNode;
                size++;
            } else {
                Node<E> node = last;
                for (int i = size - 1; i > index; i--) {
                    node = node.previous;
                }
                Node<E> newNode = new Node<>(element);
                newNode.next = node;
                newNode.previous = node.previous;
                newNode.previous.next = newNode;
                node.previous = newNode;
                size++;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void addFirst(E element) {
        if (size == 0) {
            first = new Node<E>(element);
            last = first;
            first.next = last;
            last.previous = first;
        } else {
            Node<E> newNode = new Node<>(element);
            first.previous = newNode;
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    @Override
    public void addLast(E element) {
        if (size == 0) {
            first = new Node<E>(element);
            last = first;
            first.next = last;
            last.previous = first;
        } else {
            Node<E> newNode = new Node<>(element);
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
    }

    @Override
    public E getFirst() {
        return first.element;
    }

    @Override
    public E getLast() {
        return last.element;
    }

    @Override
    public E get(int index) {
        if (index < size) {
            if (index == 0) {
                return (E) first.element;
            } else if (index == size - 1) {
                return (E) last.element;
            } else {
                if (index < size/2) {
                    Node<E> node = first;
                    for (int i = 0; i < index; i++) {
                        node = node.next;
                    }
                    return node.element;
                } else {
                    Node<E> node = last;
                    for (int i = size - 1; i > index; i--) {
                        node = node.previous;
                    }
                    return node.element;
                }
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E set(int index, E element) {
        E tmp_element = null;
        if (index < size) {
            if (index == 0) {
                tmp_element = first.element;
                first.element = element;
                return tmp_element;
            } else if (index == size - 1) {
                tmp_element = last.element;
                last.element = element;
                return tmp_element;
            } else {
                if (index < size/2) {
                    Node<E> node = first;
                    for (int i = 0; i < index; i++) {
                        node = node.next;
                    }
                    tmp_element = node.element;
                    node.element = element;
                    return tmp_element;
                } else {
                    Node<E> node = last;
                    for (int i = size - 1; i > index; i--) {
                        node = node.previous;
                    }
                    tmp_element = node.element;
                    node.element = element;
                    return tmp_element;
                }
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E removeFirst() {
        E tmp_element = first.element;
        first = first.next;
        size--;
        return tmp_element;
    }

    @Override
    public E removeLast() {
        E tmp_element = last.element;
        last = last.previous;
        last.next = null;
        size--;
        return tmp_element;
    }

    @Override
    public E remove() {
        E tmp_element = last.element;
        last = last.previous;
        last.next = null;
        size--;
        return tmp_element;
    }

    @Override
    public E remove(int index) {
        if (index < size) {
            if (index == 0) {
                E tmp_element = first.element;
                first = first.next;
                size--;
                return tmp_element;
            } else if (index == size - 1) {
                E tmp_element = last.element;
                last = last.previous;
                last.next = null;
                size--;
                return tmp_element;
            } else {
                if (index < size/2) {
                    Node<E> node = first;
                    for (int i = 0; i <= index; i++) {
                        node = node.next;
                    }
                    E tmp_element = node.element;
                    node.previous.next = node.next;
                    node.previous.next.previous = node.previous;
                    size--;
                    return tmp_element;
                } else {
                    Node<E> node = last;
                    for (int i = size - 1; i > index; i--) {
                        node = node.previous;
                    }
                    E tmp_element = node.element;
                    node.previous.next = node.next;
                    node.previous.next.previous = node.previous;
                    size--;
                    return tmp_element;
                }
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean remove(E object) {
        int i = 0;
        Node<E> node = first;
        while (true) {
            if (i < size) {
                if (node.element.equals(object)) {
                    if (i == 0) {
                        first = first.next;
                    } else if (i == size - 1) {
                        last = last.previous;
                        last.next = null;
                    } else {
                        node.previous.next = node.next;
                        node.previous.next.previous = node.previous;
                    }
                    size--;
                    return true;
                } else {
                    node = node.next;
                    i++;
                }
            } else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("[");
        Node<E> node = first;
        while(true) {
            if (node.next != null) {
                tmp.append(node.element).append(", ");
                node = node.next;
            } else {
                tmp.append(node.element). append("]");
                break;
            }
        }
        return tmp.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node<E> {
        private Node previous;
        private Node next;
        private E element;

        public Node(E element) {
            this.element = element;
        }
    }
}

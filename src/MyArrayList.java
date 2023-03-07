import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {
    private E[] elements;
    private int size = 0;

    public MyArrayList() {
    }

    public MyArrayList(int initialCapacity) {
        this.elements = (E[]) new Object[initialCapacity];
        this.size = initialCapacity;
    }

    public MyArrayList(MyArrayList<E> collection) {
        this.elements = collection.toArray();
        this.size = collection.size();
    }

    private boolean checkIndexExistence(int index) {
        return index < size;
    }

    @Override
    public E get(int index) {
        if (checkIndexExistence(index)) {
            return elements[index];
        }

        return null;
    }

    public int get(E object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }

        return 0;
    }

    @Override
    public E set(int index, E element) {
        E tmp = null;

        if (checkIndexExistence(index)) {
            tmp = elements[index];
            elements[index] = element;
        }

        return tmp;
    }

    @Override
    public E remove(int index) {
        E tmp = null;

        if (index == 0) { // в такому разі немає сенсу перезаписувати всі елементи можна лише відрізати потрібну частину
            tmp = elements[index];
            elements = Arrays.copyOfRange(elements, 1, size);
        } else if (index == size - 1) { // аналогічно
            tmp = elements[index];
            elements = Arrays.copyOf(elements, size - 1);
        } else {
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    tmp = elements[index];
                } else if (i > index) {
                    elements[i - 1] = elements[i];
                }
            }
            elements = Arrays.copyOf(elements, size - 1);
        }
        size--;

        return tmp;
    }

    @Override
    public boolean remove(E object) {
        boolean isRemoved = false;

        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {

                if (i == 0) { // тут так само немає сенсу перезаписувати всі елементи можна лише відрізати потрібну частину
                    elements = Arrays.copyOfRange(elements, 1, size);
                } else if (i == size - 1) { // аналогічно
                    elements = Arrays.copyOf(elements, size - 1);
                } else {
                    for (int j = i + 1; j < size; j++) {
                        if (j > i) {
                            elements[j - 1] = elements[j];
                        }
                    }
                    elements = Arrays.copyOf(elements, size - 1);
                }

                size--;
                isRemoved = true;

                break;
            }
        }

        return isRemoved;
    }

    @Override
    public void add(E element) {
        E[] newArray = (E[]) new Object[size + 1];

        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
        }

        newArray[size] = element;
        size++;
        elements = newArray;
    }

    @Override
    public void add(int index, E element) {
        E[] newArray = (E[]) new Object[size + 1];

        for (int i = 0; i < newArray.length; i++) {
            if (i < index){
                newArray[i]=elements[i];
            }
            if (i == index){
                newArray[i]=element;
            }
            if (i > index){
                newArray[i] = elements[i - 1];
            }
        }

        elements = newArray;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i < size-1) {
                tmp.append(elements[i]).append(", ");
            } else {
                tmp.append(elements[i]).append("]");
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

    public E[] toArray() {
        return elements;
    }
}

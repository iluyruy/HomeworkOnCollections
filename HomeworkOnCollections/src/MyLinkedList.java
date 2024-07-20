import java.util.Collection;

public class MyLinkedList<T extends Comparable<T>> {
    // Внутренний класс для представления узлов связного списка
    class Node {
        T data; // Данные узла
        Node next; // Ссылка на следующий узел

        Node(T data) {
            this.data = data;
        }
    }

    Node head; // Голова списка
    private int size; // Размер списка

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Метод для добавления элемента в конец списка
    public void add(T element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(element);
        }
        size++;
    }

    // Метод для получения элемента по индексу
    public T get(int index) {
        checkIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Метод для удаления элемента по индексу
    public T remove(int index) {
        checkIndex(index);
        Node current = head;
        if (index == 0) {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            T data = current.next.data;
            current.next = current.next.next;
            size--;
            return data;
        }
    }

    // Метод для добавления всех элементов из коллекции
    public void addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }
    }


    // Метод для проверки валидности индекса
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Метод для получения размера списка
    public int size() {
        return size;
    }

    // Метод для проверки, пуст ли список
    public boolean isEmpty() {
        return size == 0;
    }
}
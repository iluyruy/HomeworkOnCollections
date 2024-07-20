public class BubbleSortLinkedList {
    // Метод для сортировки списка пузырьком
    public static <T extends Comparable<T>> void bubbleSort(MyLinkedList<T> list) {
        if (list.size() > 1) {
            boolean swapped; // Флаг, указывающий, были ли произведены обмены в текущем проходе

            do {
                MyLinkedList<T>.Node current = list.head;  // Текущий узел, начиная с головы списка
                MyLinkedList<T>.Node previous = null;
                MyLinkedList<T>.Node next = current.next;
                swapped = false;   // Сброс флага обмена перед каждым проходом


                for (int i = 0; i < list.size() - 1; i++) {   // Проход по списку
                    if (current.data.compareTo(next.data) > 0) {
                        swapped = true;
                        if (previous != null) { // Если предыдущий узел не null (не голова списка)
                            MyLinkedList<T>.Node temp = next.next;
                            previous.next = next;
                            next.next = current;
                            current.next = temp;
                        } else {   // Если текущий узел является головой списка
                            MyLinkedList<T>.Node temp = next.next;
                            list.head = next;
                            next.next = current;
                            current.next = temp;
                        }
                        previous = next;
                        next = current.next;
                    } else { // Если текущий элемент меньше или равен следующему
                        previous = current;
                        current = next;
                        next = next.next;
                    }
                }
            } while (swapped); // Повторяем проходы, пока выполняются обмены
        }
    }
}
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // Тестирование метода add
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(9);

        System.out.println("Список после добавления элементов:");
        printList(list);

        // Тестирование метода get
            System.out.println("\nЭлемент с индексом 2: " + list.get(2));

        // Тестирование метода remove
        System.out.println("Удаление элемента с индексом 3 (value: " + list.remove(3) + ")");
        printList(list);

        // Тестирование метода addAll
        list.addAll(Arrays.asList(2, 6, 5, 3, 5));
        System.out.println("Список после addAll:");
        printList(list);

        // Тестирование метода bubbleSort
        BubbleSortLinkedList.bubbleSort(list);
        System.out.println("Список после bubbleSort:");
        printList(list);

        // Тестирование метода size
        System.out.println("\nРазмер списка: " + list.size());

        // Тестирование метода isEmpty
        System.out.println("Пуст ли список? " + list.isEmpty());

        // Проверка удаления всех элементов для проверки метода isEmpty
        while (!list.isEmpty()) {
            list.remove(0);
        }
        System.out.println("Список после удаления всех элементов:");
        printList(list);
        System.out.println("Пустой ли список? " + list.isEmpty());
    }

    // Метод для печати элементов списка
    private static void printList(MyLinkedList<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
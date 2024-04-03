package task6_1_2;

public class Task6_1_2 {
    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                Модуль 6. Основные структуры данных. Задание №1:\s
                    2. Что такое итератор?\s

                Решение:\s""");

        System.out.println("""
                В Java итератор (или Iterator) представляет собой интерфейс, который предоставляет
                возможность последовательного перебора элементов коллекции. Он позволяет обходить
                коллекцию и получать каждый элемент по очереди без необходимости знать внутреннюю
                структуру коллекции.
                                
                Интерфейс Iterator определяет следующие методы:
                                
                boolean hasNext(): Возвращает true, если итератор содержит следующий элемент,
                и false, если достигнут конец коллекции.
                E next(): Возвращает следующий элемент из коллекции.
                void remove(): Удаляет текущий элемент из коллекции. Этот метод необязателен
                и может не поддерживаться некоторыми итераторами.
                Итераторы используются для обхода различных коллекций в Java, таких как списки
                (List), множества (Set), карты (Map) и других.\s""");
    }
}
package a_shablony;

import java.util.Scanner;

public class Exception_try_catch {
    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                Модуль 4. Наследование. Задание №7:\s
                    1. В чем разница между throw и throws в Java?\s

                Решение:\s""");

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите цифру:");
            char ch = scanner.next().charAt(0);
            if (!Character.isDigit(ch)) {
                throw new RuntimeException("this is not digit");
            }
        } catch (RuntimeException e) {
            System.out.println("there is some error!!!");
        }
        System.out.println("It's done");
    }
}
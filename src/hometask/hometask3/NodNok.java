package hometask.hometask3;

import java.util.Scanner;

public class NodNok {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int first = scanner.nextInt();
        while (first <= 0) {
            System.out.println("Вы ввели отрицательное число или 0");
            System.out.println("Введите положительное число: ");
            first = scanner.nextInt();
        }
        System.out.println("Введите второе число: ");
        int second = scanner.nextInt();
        while (second <= 0) {
            System.out.println("Вы ввели отрицательное число или 0");
            System.out.println("Введите положительное число: ");
            second = scanner.nextInt();
        }
        System.out.println("Наибольший общий делитель Ваших чисел:" + nod(first, second));
        System.out.println("Наименьшее общее кратное Ваших чисел: " + nok(first, second));
    }

    static int nod(int first, int second) {
        while (first != 0 && second != 0) {
            if (first > second) {
                first %= second;
            } else {
                second %= first;
            }
        }
        return first + second;
    }

    static int nok(int first, int second) {
        int nok = 0;
        int count = 1;
        while (nok == 0) {
            if (count % first == 0 && count % second == 0)
                nok = count;
            count++;
        }
        return nok;
    }
}

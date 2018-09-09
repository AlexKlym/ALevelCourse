package hometask.hometask2;

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число a");
        int a = scanner.nextInt();
        System.out.println("Введите число b");
        int b = scanner.nextInt();
        System.out.println("Введите число c");
        int c = scanner.nextInt();
        int max = a > b && a > c ? a : b > a && b > c ? b : c;
        System.out.println("Наибольшее введенное значение равно " + max);
    }
}

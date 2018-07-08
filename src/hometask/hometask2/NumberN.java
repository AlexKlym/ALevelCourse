package hometask.hometask2;

import java.util.Scanner;

public class NumberN {
    public static void main(String[] args) {
        System.out.println("Введите число n ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = (1 << n);
        System.out.println("Результат возведения 2 в степень Вашего числа: " + x);
    }
}

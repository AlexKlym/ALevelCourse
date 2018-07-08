package hometask.hometask3;

import java.util.Scanner;

public class Fibbonaci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите любое число: ");
        int n = scanner.nextInt();
        int a = 1;
        int b = 1;
        int c = 2;
        int i = 2;
        System.out.println("Фибоначчи числа " + n + ':');
        System.out.print(a + " " + b);
        while (i < n) {
            c = a + b;
            a = b;
            b = c;
            i++;
            System.out.print(" " + c);
        }
    }
}

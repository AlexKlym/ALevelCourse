package hometask.hometask3;

import java.util.Scanner;

public class Fibbonaci1 {
    private static int a(int b) {
        if (b <= 0) {
            return 0;
        } else if (b == 1) {
            return 1;
        } else if (b == 2) {
            return 1;
        } else {
            return a(b - 1) + a(b - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите любое число: ");
        int n = scanner.nextInt();
        int i;
        System.out.println("Фибоначчи числа " + n + ':');
        for (i = 1; i <= n; i++) {
            System.out.print(a(i) + " ");
        }
    }
}

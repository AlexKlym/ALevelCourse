package hometask.hometask3;

import java.util.Scanner;

public class Array {

    public static void main(String[] args) {
        System.out.println("Введите число от  3 до 9");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = n * i + j;
            }
        }
        System.out.println("Ваш начальный массив: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + a[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int z = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = z;
            }
        }
        System.out.println();
        System.out.println("Ваш новый массив: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + a[i][j]);
            }
            System.out.println();
        }

    }
}

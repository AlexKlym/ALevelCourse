package hometask.arithmeticprogression;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter initial number:");
            int initial = scanner.nextInt();
            System.out.println("Enter step:");
            int step = scanner.nextInt();
            System.out.println("Enter N:");
            int n = scanner.nextInt();
            try {
                System.out.print("The result is: ");
                System.out.println(new ArithmeticProgression(initial, step).calculate(n));
            } catch (ProgressionConfigurationException i) {
                System.err.println(i.getMessage());
            }
        }
    }

}

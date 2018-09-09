package hometask.hometask_threads;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputChecker inputChecker = new InputChecker();
        Thread t = new Thread(inputChecker);
        t.start();
        while (true) {
            System.out.println("Please input the text or type <quit>");
            String input = scanner.nextLine();
            inputChecker.addString(input);
            if (input.equals("quit")) {
                break;
            }
        }
    }
}

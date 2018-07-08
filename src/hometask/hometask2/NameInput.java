package hometask.hometask2;

import java.util.Scanner;

public class NameInput {
    public static void main(String[] args) {
        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int len = name.length();
        String a = "tl;dr";
        String b = "Hello, " + name + '!';
        String c = (len > 10) ? a : b;
        System.out.println(c);
    }
}

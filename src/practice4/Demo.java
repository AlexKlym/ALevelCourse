package practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter directory path: ");
        String directory = scan.nextLine();
        File folder = new File(directory);
        TreeCount count = new TreeCount();
        count.result(folder);

    }
}

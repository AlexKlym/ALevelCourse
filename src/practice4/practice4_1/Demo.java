package practice4.practice4_1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter directory path: ");
        String directory = scan.nextLine();
        File folder = new File(directory);
        Count count = new Count();
        count.result(folder, directory);

    }
}


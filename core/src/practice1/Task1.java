package practice1;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number ");
        int k = scanner.nextInt();
        int []arr = new int [30];
        int sum = 0;



        for (int i = 0; i <  arr.length; i++) {
            arr[i] = (int)(Math.random() * 30) + 1;
        }

        for (int i = 0; i <  arr.length; i++) {
            if (arr[i]%k == 0) {
                sum = sum + arr[i];
            }
        }
        System.out.println("Сумма элементов кратных К: " + sum );
    }
}

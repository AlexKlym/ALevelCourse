package practice1;

public class Task4 {
    public static void main(String[] args) {
        int[] a = {4, 6, 8, 9, 12, 13, 14, 21, 25};
        boolean z = true;
        for (int i = 1; i < a.length; i++) {
            if (a[i] <= a[i - 1]) {
                z = false;
                break;
            }
        }
        if (z) {
            System.out.println("Последовательность чисел является возрастающей");
        } else {
            System.out.println("Последовательность чисел не является возрастающей");
        }
    }
}
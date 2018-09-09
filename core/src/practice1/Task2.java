package practice1;

import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<Integer> a = getArray(3, 2, 0, 5, 0, 9, 0, 0, 11, 7, 0);

        for (int b : a) System.out.print(b + " ");
    }

    private static ArrayList<Integer> getArray(int... nums) {
        ArrayList<Integer> b = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 0) b.add(i);

        return b;
    }


}

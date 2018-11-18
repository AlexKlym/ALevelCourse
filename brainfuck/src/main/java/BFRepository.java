import java.util.Arrays;
import java.util.Scanner;

class BFRepository {

    private static Scanner ob = new Scanner(System.in);
    private static int ptr;
    private static int length = 65535;
    private static byte memory[] = new byte[length];

    String interpret(String s) {
        int c = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '>') {
                if (ptr == length - 1)
                    ptr = 0;
                else
                    ptr++;
            } else if (s.charAt(i) == '<') {
                if (ptr == 0)
                    ptr = length - 1;
                else
                    ptr--;
            } else if (s.charAt(i) == '+')
                memory[ptr]++;

            else if (s.charAt(i) == '-')
                memory[ptr]--;

            else if (s.charAt(i) == '.')
                System.out.print((char) (memory[ptr]));

            else if (s.charAt(i) == ',')
                memory[ptr] = (byte) (ob.next().charAt(0));

            else if (s.charAt(i) == '[') {
                if (memory[ptr] == 0) {
                    i++;
                    while (c > 0 || s.charAt(i) != ']') {
                        if (s.charAt(i) == '[')
                            c++;
                        else if (s.charAt(i) == ']')
                            c--;
                        i++;
                    }
                }
            } else if (s.charAt(i) == ']') {
                if (memory[ptr] != 0) {
                    i--;
                    while (c > 0 || s.charAt(i) != '[') {
                        if (s.charAt(i) == ']')
                            c++;
                        else if (s.charAt(i) == '[')
                            c--;
                        i--;
                    }
                    i--;
                }
            }
        }
        return Arrays.toString(memory);
    }


}
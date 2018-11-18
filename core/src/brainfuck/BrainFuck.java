package brainfuck;


import java.util.Scanner;

public class BrainFuck {

    private static Scanner ob = new Scanner(System.in);
    private static int ptr;
    private static int length = 65535;
    private static byte memory [] = new byte[length];

    private static void interpret(String s) {
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
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the your brainfuck:");
        String code = sc.nextLine();

        // Hello World! in bf ++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.
        System.out.println("Output:");
        interpret(code);
    }
}
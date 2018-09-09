package hometask.hometask_io;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter input file name: ");
        String input = scan.nextLine();
        System.out.println("Enter output file name: ");
        String output = scan.nextLine();
        System.out.println("Enter number of lines to copy: ");
        int lines = scan.nextInt();
        System.out.println(" 1 - using IO; 2 - using NIO");
        int type = scan.nextInt();

        switch (type) {
            case 1: {
                InputOutput inpOut = new InputOutput(input, output, lines);
                inpOut.makeCopy();
                break;
            }
            case 2: {
                NewInputOutput nIO = new NewInputOutput(input, output, lines);
                nIO.makeCopy();
                break;
            }
            default:
                System.out.println("Wrong choice!");

            }
        }
    }

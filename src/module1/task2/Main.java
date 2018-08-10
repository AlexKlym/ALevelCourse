package module1.task2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentList studen = new StudentList();
        Scanner scan = new Scanner(System.in);

        System.out.println("Эта программа позволит вам создать список студентов и посчитать их стипендию по результатам сессии.");
        System.out.println("У студента может быть от 3 до 5 оценок по пятибальной системе.");


        while (true) {
            System.out.println("Введите ФИО студента или end для завершения: ");
            String name = scan.nextLine();
            ArrayList<Integer> marks = new ArrayList<>();
            System.out.println("Введите оценки студента: ");
            for (int i = 0; i < 5; i++) {
                int mark = scan.nextInt();
                if (mark > 5 || mark < 2) {
                    throw new IllegalArgumentException("Нужно ввести оценки по пятибальной системе от 2 до 5");
                }
                marks.add(mark);
            }
            studen.addStudent(name, marks);
            if (name.equals("end"))
                break;
        }
        studen.count();
        System.out.println(studen.toString());

    }
}

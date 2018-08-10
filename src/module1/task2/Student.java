package module1.task2;

import java.util.ArrayList;

public class Student {
    private String fio;
    private ArrayList<Integer> marks;
    private double scholarship;

    public Student(String fio) {
        this.fio = fio;
    }

    public Student(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    public Student(String fio, ArrayList<Integer> marks) {
        this.fio = fio;
        this.marks = marks;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    public double getScholarship() {
        return scholarship;
    }

    public void setScholarship(double scholarship) {
        this.scholarship = scholarship;
    }

    public String toString() {
        return "Студент: " + fio + '\n' +
                "Оценки: " + marks + "; " + "Стипендия: " + getScholarship();

    }


}

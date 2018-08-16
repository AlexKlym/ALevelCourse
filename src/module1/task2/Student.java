package module1.task2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String fio;
    private List<Integer> marks;
    private double scholarship;

    public Student(String fio) {
        this.fio = fio;
    }

    public Student(List<Integer> marks) {
        this.marks = marks;
    }

    public Student(String fio, List<Integer> marks) {
        this.fio = fio;
        this.marks = marks;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public List<Integer> getMarks() {
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

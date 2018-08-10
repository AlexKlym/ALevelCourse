package module1.task2;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private List<Student> students;

    public StudentList(ArrayList<Student> students) {
        this.students = students;
    }

    public StudentList() {
        this.students = new ArrayList<Student>();
}

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Student st : students) {
            sb.append(st.toString());
        }
        return sb.toString();
    }

    public void addStudent(String fio, List<Integer> newmarks) {
        for (Student s : students) {
            if (fio.equals(s.getFio())) {
                throw new IllegalArgumentException("Такой студент уже есть!");
            }
            if (newmarks.size() < 3 || newmarks.size() > 5) {
                throw new IllegalArgumentException("Количество оценок должно быть от 3 до 5");
            }
            Student stud = new Student(fio);
            for (Integer i : newmarks) {
                stud.getMarks().add(i);
            }
            students.add(stud);
        }
    }

    public void count() {
        for (Student stud : students) {
            int count2 = 0;
            int count3 = 0;
            int count4 = 0;
            int count5 = 0;
            for (Integer marks : stud.getMarks()) {
                if (marks == 5) {
                    count5++;
                } else if (marks == 4) {
                    count4++;
                } else if (marks == 3) {
                    count3++;
                } else if (marks == 2) {
                    count2++;
                }
            }
            if ((count5 == 5 || count5 == 4 || count5 == 3) && count3 == 0 && count4 == 0 && count2 == 0) {
                stud.setScholarship(4000);
            } else if ((count4 == 5 || count4 == 4 || count4 == 3) && count5 > 0 && count3 == 0 && count2 == 0) {
                stud.setScholarship(3000);
            } else if ((count4 == 5 || count4 == 4 || count4 == 3) && count3 == 0 && count5 == 0 && count2 == 0) {
                stud.setScholarship(2500);
            } else if (count3 > 2 || count2 > 0) {
                stud.setScholarship(0);
            } else stud.setScholarship(2000);

        }

    }
}

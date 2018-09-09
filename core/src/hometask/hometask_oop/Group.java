package hometask.hometask_oop;

public class Group {
    public static void main(String[] args) {

        Student[] students = new Student[10];
        students[0] = new Student("Alex", 17);
        students[1] = new ContractStudent("Vasya", 18, 17850);
        students[2] = new Student("Sergey", 17);
        students[4] = new Student("Alina", 18);
        students[3] = new ContractStudent("Yana", 17, 17850);
        students[5] = new ContractStudent("Kolya", 18, 17850);
        students[6] = new Student("Andrey", 17);
        students[7] = new ContractStudent("Igor", 17, 17850);
        students[8] = new ContractStudent("Masha", 18, 17850);
        students[9] = new ContractStudent("Vadym", 18, 17850);

        System.out.println("Whole group:\n ");

        for (int j = 0; j < students.length; j++) {

            System.out.println("Name: " + students[j].name + "   " + "Age: " + students[j].age);

        }

        System.out.println("Contract students of the group:\n");


        for (int i = 0; i < students.length; i++) {
            if (students[i] instanceof ContractStudent) {
                students[i].print();
                System.out.println("\n");
            }

        }
    }

}

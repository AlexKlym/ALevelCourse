package hometask.house_for_animals;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose one of the following animals to create house for them: ");
        System.out.println("Cat, Dog, Hamster, Desman");
        String choise = null;

        do {
            try {
                choise = scan.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.err.println("You should choose one of the given animals");
                scan.next();
                continue;
            }
        } while (choise == null);
        switch (choise) {
            case "cat":
                House<Cat> catHouse = new House<Cat>();
                fillCat(catHouse.getDwellers());
                catHouse.getDwellers().print();
                break;
            case "dog":
                House<Dog> dogHouse = new House<Dog>();
                fillDog(dogHouse.getDwellers());
                dogHouse.getDwellers().print();
                break;
            case "hamster":
                House<Hamster> hamsterHouse = new House<Hamster>();
                fillHamster(hamsterHouse.getDwellers());
                hamsterHouse.getDwellers().print();
                break;
            case "desman":
                House<Desman> desmanHouse = new House<Desman>();
                fillDesman(desmanHouse.getDwellers());
                desmanHouse.getDwellers().print();
                break;

        }
    }

    public static void fillCat(PetList<Cat> cats) {
        cats.add(new Cat("Barsik", 12, 6.5));
        cats.add(new Cat("Vasya", 7, 3.3));
        cats.add(new Cat("Joker", 6, 15.3));
    }

    public static void fillDog(PetList<Dog> dogs) {
        dogs.add(new Dog("Jack", 7, 30.1));
        dogs.add(new Dog("Lucky", 12, 22.5));
        dogs.add(new Dog("Ray", 2, 12.3));
        dogs.add(new Dog("Sim", 4, 16.4));
    }

    public static void fillHamster(PetList<Hamster> hamsters) {
        hamsters.add(new Hamster("Simba", 3, 0.7));
        hamsters.add(new Hamster("Simon", 1, 0.5));
    }

    public static void fillDesman(PetList<Desman> desmans) {
        desmans.add(new Desman("Fill", 5, 15));
        desmans.add(new Desman("Sam", 4, 12.3));
    }
}

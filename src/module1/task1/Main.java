package module1.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> trainScheme = new ArrayList<>();
        trainScheme.add(new Locomotive().display());
        Scanner sc = new Scanner(System.in);
        System.out.println("It's time to make a train");
        System.out.println("Choose the city from where this train is going(Kharkov, Kiev, Lvov): ");
        Cities start = null;
        String z = sc.nextLine().trim().toUpperCase();
        start = Cities.valueOf(z);

        System.out.println("Choose the city where the train goes to(Kharkov, Kiev, Lvov): ");
        Cities end = null;
        String j = sc.nextLine().trim().toUpperCase();
        end = Cities.valueOf(j);


        String k = null;
        while (true) {
            System.out.println("Input type of your new wagon(cargo, 1class, 2class) or end to finish it");
            k = sc.nextLine().trim().toLowerCase();
            switch (k) {
                case "cargo":
                    trainScheme.add(new Cargo().display());
                    continue;
                case "1class":
                    trainScheme.add(new Passengers1().display());
                    continue;
                case "2class":
                    trainScheme.add(new Passengers2().display());
                    continue;
                case "end":
                    break;
            }
            if (k.equals("end"))
                break;
        }

        System.out.println("The train goes from " + start + " to " + end + ".");
        System.out.println("Train scheme is ");
        System.out.print(trainScheme.get(0) + "=");
        for (int i = 1; i < trainScheme.size(); i++) {
            System.out.print(trainScheme.get(i) + "=");
        }

    }
}

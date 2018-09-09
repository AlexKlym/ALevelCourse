package hometask.hometask_oop_2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Sub substance = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose one of the following substances(water, iron, oxygen): ");
        String s = scanner.nextLine().toLowerCase();
        switch (s){
            case "water":
                substance = new Water();
                break;

            case "iron":
                substance = new Iron();
                break;

            case "oxygen":
                substance = new Oxygen();
                break;
        }
        String input;
        double t;

            do{
                System.out.println("Enter new temperature: ");
                input = scanner.next();
                t = Double.parseDouble(input);
                State z = substance.heatUp(t);
                System.out.println("The current temperature of " + s + " is " + substance.getTemperature() + "  State is " + z);

            }while(t != 0);


    }
}

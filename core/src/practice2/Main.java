package practice2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your package name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your package mass: ");
        String in = scanner.next();
        double mass = Double.parseDouble(in);
        System.out.println("Enter your package volume: ");
        String inp = scanner.next();
        double volume = Double.parseDouble(inp);
        Package pack = new Package(name, mass, volume);
        System.out.println("Choose the city from where the package is (A, B, C or D): ");
        City start = null;
        String j = scanner.next().trim().toUpperCase();
        start = City.valueOf(j);

        System.out.println("Choose the city for delivery (A, B, C or D): ");
        City end = null;
        String z = scanner.next().trim().toUpperCase();
        end = City.valueOf(z);

        Transport delivery = null;
        while (delivery == null) {
            System.out.println("Choose the transport (train, car or plane): ");
            String s = scanner.next().trim().toLowerCase();
            switch (s) {
                case "train":
                    delivery = new Train();
                    break;
                case "car":
                    delivery = new Car();
                    break;
                case "plane":
                    delivery = new Plane();
                    break;
            }
        }

        Deliver del = new Deliver();
        del.setTransport(delivery);
        del.deliver(pack, start, end);



    }
}

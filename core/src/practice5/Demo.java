package practice5;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Horse first = new Horse();
        Horse second = new Horse();
        Horse third = new Horse();
        Horse fourth = new Horse();
        Scanner scan = new Scanner(System.in);

        first.setName("first horse");
        second.setName("second horse");
        third.setName("third horse");
        fourth.setName("fourth horse");

        List<Horse> horses = new LinkedList<>(Arrays.asList(first, second, third, fourth));
        System.out.println("Please, select the horse from 1 to 4");
        String chosenHorse = horses.get(scan.nextInt() - 1).getName();
        System.out.println("You have choose the " + chosenHorse);
        System.out.println("Race starts");

        for (Horse horse:horses) {
            horse.start();
        }

        int pos = 1;
        String winnersName = null;
        while (horses.size() > 0){
            Iterator<Horse> iterator = horses.iterator();
            while (iterator.hasNext()) {
                Horse horse = iterator.next();
                if(horse.getFinished()){
                    iterator.remove();
                    if(winnersName == null){
                        winnersName = horse.getName();
                    }
                    System.out.println(horse.getName() + " has finished at " + pos++ + " position!" );
                }
            }
        }

        System.out.println("Race finished");

        if(chosenHorse.equals(winnersName)){
            System.out.println("You won!");
        }else{
            System.out.println("You lost! Try your luck another time");
        }
    }
}

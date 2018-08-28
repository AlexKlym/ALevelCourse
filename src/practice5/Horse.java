package practice5;

import java.util.Random;

public class Horse extends Thread {
    private Random rand = new Random();
    private boolean isFinished = false;

    boolean getFinished() {
        return isFinished;
    }

    @Override
    public void run() {
        int totalRun = 0;
        System.out.println(Thread.currentThread().getName() + " has started!");
        while (totalRun <= 1000) {
            try {
                totalRun += rand.nextInt(100) + 200;
                Thread.sleep(rand.nextInt(100) + 400);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isFinished = true;

    }


}

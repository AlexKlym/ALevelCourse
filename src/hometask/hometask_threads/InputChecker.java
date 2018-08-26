package hometask.hometask_threads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputChecker implements Runnable {
    private String previousInput = "";
    private String currentInput = "";
    private String newString = "";
    private boolean running = true;
    private StringBuilder sb = new StringBuilder();

    private void terminate() {
        running = false;
    }

    public void addString(String s) {
        sb.append(s).append(System.lineSeparator());
        newString = s;
    }

    @Override
    public void run() {
        while (running) {
            currentInput = sb.toString();
            try {
                if (!currentInput.equals(previousInput)) {
                    write2file();
                }
                if (newString.equals("quit")) {
                    terminate();
                } else {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void write2file() {
        try {
            Files.write(Paths.get("output.txt"), currentInput.getBytes());
            previousInput = currentInput;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package practice4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TreeCount {
    private int fileCount = 0;
    private int folderCount = 0;
    private Path path = Paths.get("src/files/result.txt");

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public int getFolderCount() {
        return folderCount;
    }

    public void setFolderCount(int folderCount) {
        this.folderCount = folderCount;
    }

    private void countFiles(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileCount++;
                } else {
                    folderCount++;
                    countFiles(file);
                }
            }
        }
    }

    private void printTree(File folder, StringBuilder in) throws IOException {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    Files.write(path, (in + file.getName() + "\n").getBytes(), StandardOpenOption.APPEND);
                    printTree(file, getNewIn(in));
                } else {
                    Files.write(path, (in + file.getName() + "\n").getBytes(), StandardOpenOption.APPEND);
                }
            }
        } else {
            Files.write(path, "You have entered wrong path".getBytes(), StandardOpenOption.APPEND);
        }
    }

    private StringBuilder getNewIn(StringBuilder in) {
        StringBuilder newIn = new StringBuilder(in);
        newIn.insert(0, "   ");
        return newIn;
    }

    public void result(File folder) throws IOException {
        Files.write(path, "".getBytes());
        countFiles(folder);
        Files.write(path, ("You've got " + getFolderCount() + " folders").getBytes(), StandardOpenOption.APPEND);
        Files.write(path, (" and " + getFileCount() + " files \n").getBytes(), StandardOpenOption.APPEND);

        StringBuilder out = new StringBuilder("|+++");
        printTree(folder, out);
        System.out.println("Check result.txt to see results");

    }


}
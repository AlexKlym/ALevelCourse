package practice4.practice4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Count {
    private int fileCount = 0;
    private int folderCount = 0;
    private final StringBuilder sb = new StringBuilder();

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

    private void traverse(File folder, int level) throws FileNotFoundException {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    folderCount++;
                    sb.append("\n").append(offset(level)).append("|+++").append(file.getName());
                    traverse(file, level + 1);
                } else {
                    fileCount++;
                    sb.append("\n").append(offset(level)).append("|+++").append(file.getName());
                }
            }
        } else {
            throw new FileNotFoundException("Wrong path!");
        }
    }

    private String offset(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }


    public void result(File folder, String s) throws IOException {
        sb.delete(0, sb.length());

        traverse(folder, 0);
        System.out.print("You've got " + getFolderCount() + " folders");
        System.out.print(" and " + getFileCount() + " files \n");
        System.out.print(s);
        System.out.println(sb.toString());

    }


}
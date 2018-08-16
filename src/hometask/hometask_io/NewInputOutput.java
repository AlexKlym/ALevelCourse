package hometask.hometask_io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class NewInputOutput {
    private String input;
    private String output;
    private int lines;

    public NewInputOutput(String input, String output, int lines) {
        this.input = input;
        this.output = output;
        this.lines = lines;
    }

    public void makeCopy() {

        try {
            int i = 0;
            final List<String> strings = Files.readAllLines(Paths.get(input));

            RandomAccessFile stream = new RandomAccessFile(output, "rw");
            FileChannel channel = stream.getChannel();


            for (String s : strings) {
                if (i < lines) {
                    byte[] strBytes = (s + "\n").getBytes();
                    ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
                    buffer.put(strBytes);
                    buffer.flip();
                    channel.write(buffer);
                    System.out.println(s);
                } else {
                    System.out.println("Number of lines in your file is less than you want to be copied.");
                    break;
                }

            }

            stream.close();
            channel.close();

        }catch (FileNotFoundException e){
            System.err.println("File not found");
        }
        catch (IOException e) {
            System.out.println("sorry, you've got an error: ");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}



package hometask.hometask_io;

import java.io.*;

public class InputOutput {
    private String input;
    private String output;
    private int lines;


    public InputOutput(String input, String output, int lines) {
        this.input = input;
        this.output = output;
        this.lines = lines;
    }

    public void makeCopy() {

        try (InputStream inStream = new FileInputStream(input);
             OutputStream outStream = new FileOutputStream(output)) {

            BufferedReader bd = new BufferedReader(new InputStreamReader(inStream));

            String line;
            int i = 0;



            while (i < lines) {
                if ((line = bd.readLine()) != null) {
                    System.out.println(line);
                    byte[] toBytes = (line + "\n").getBytes();
                    outStream.write(toBytes);
                    i++;
                } else {
                    System.out.println("Number of lines you want to be transferred is more than file has.");
                    break;
                }
            }
            outStream.close();
            bd.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}

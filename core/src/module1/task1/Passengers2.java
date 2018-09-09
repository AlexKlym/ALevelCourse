package module1.task1;

public class Passengers2 implements Wagon {
    int pass2 = 0;
    String passen2 = "passngr";
    String cl2 = "2cl";

    public int passNumer2(int pass2) {
        this.pass2 = pass2;
        pass2 = pass2 + (int) (Math.random() * 200);
        return pass2;
    }

    @Override
    public String display() {
        return "[:" + passen2 + ":" + cl2 + ":" + passNumer2(0) + ":]";
    }

    public int getPass2() {
        return pass2;
    }

    public void setPass2(int pass2) {
        this.pass2 = pass2;
    }

    public String getPassen2() {
        return passen2;
    }

    public void setPassen2(String passen2) {
        this.passen2 = passen2;
    }

    public String getCl2() {
        return cl2;
    }

    public void setCl2(String cl2) {
        this.cl2 = cl2;
    }
}

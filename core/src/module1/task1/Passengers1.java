package module1.task1;

public class Passengers1 implements Wagon {
    int pass1 = 0;
    String passen1 = "passngr";
    String cl1 = "1cl";

    public int passNumer1(int pass1) {
        this.pass1 = pass1;
        pass1 = pass1 + (int) (Math.random() * 100);
        return pass1;
    }

    @Override
    public String display() {
        return "[:" + passen1 + ":" + cl1 + ":" + passNumer1(0) + ":]";
    }

    public int getPass1() {
        return pass1;
    }

    public void setPass1(int pass1) {
        this.pass1 = pass1;
    }

    public String getPassen1() {
        return passen1;
    }

    public void setPassen1(String passen1) {
        this.passen1 = passen1;
    }

    public String getCl1() {
        return cl1;
    }

    public void setCl1(String cl1) {
        this.cl1 = cl1;
    }
}

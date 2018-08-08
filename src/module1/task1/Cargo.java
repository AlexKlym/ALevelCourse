package module1.task1;

public class Cargo implements Wagon {
    int load = 0;
    String cargo = "cargo";

    public int cargoLoad(int load) {
        this.load = load;
        load = load + (int) (Math.random() * 100);
        return load;
    }

    @Override
    public String display() {
        return "[:" + cargo + ":" + cargoLoad(0) + "%:]";
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


}

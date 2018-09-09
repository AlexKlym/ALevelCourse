package hometask.hometask_oop;

public class ContractStudent extends Student {
    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ContractStudent(String name, int age, double price) {
        super(name, age);
        this.price = price;
    }

    public void print() {
        super.print();
        System.out.print("   " + "Price: " + price);

    }
}

package hometask.house_for_animals;

public class House<T extends Animal> {
    private PetList<T> dwellers;
    private int amount;

    public House() {
        this.dwellers = new PetList<T>();
        this.amount = this.dwellers.size();
    }

    public PetList<T> getDwellers() {
        return dwellers;
    }

    public void setDwellers(PetList<T> dwellers) {
        this.dwellers = dwellers;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

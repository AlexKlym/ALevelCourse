package hometask.house_for_animals;

import java.util.Arrays;

public class PetList<T> {
    private T[] data;
    private int position;

    PetList() {
        this(10);
    }

    PetList(int quantity) {
        this.data = (T[]) new Object[quantity];
        this.position = 0;
    }

    public int size() {
        return this.data.length;
    }

    public void add(T element) {
        if (position == size()) {
            T[] temp = (T[]) new Object[size() + (size() / 2) + 1];
            temp = Arrays.copyOf(this.data, size());
            this.data = temp;
        }
        this.data[position] = element;
        position++;

    }

    public void print() {
        for (T element : this.data) {
            if (element == null) {
                break;
            }
            System.out.println(element.toString());
        }
    }
}

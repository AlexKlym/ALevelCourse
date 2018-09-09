package practice2;

public class Package {
    private String name;
    private double mass;
    private double volume;

    public Package(String name, double mass, double volume) {
        this.name = name;
        this.mass = mass;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getVolume() {
        return volume;
    }

}

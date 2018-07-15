package practice2;

public class Car implements Transport {
    @Override
    public double deliver(Package pack) {
        return pack.getVolume() * pack.getMass() * 2;
    }

    @Override
    public String getName() {
        return "car";
    }
}

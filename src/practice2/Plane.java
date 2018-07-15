package practice2;

public class Plane implements Transport {
    @Override
    public double deliver(Package pack) {
        return pack.getMass() * pack.getVolume() * 5;
    }

    @Override
    public String getName() {
        return "plane";
    }
}

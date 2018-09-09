package practice2;

public class Train implements Transport {
    @Override
    public double deliver(Package pack) {
        return pack.getMass() * pack.getVolume() * 1;
    }

    @Override
    public String getName() {
        return "train";
    }
}

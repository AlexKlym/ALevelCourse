package hometask.arithmeticprogression;

public class ArithmeticProgression {
    private final int initial;
    private final int step;

     ArithmeticProgression(int initial, int step) throws ProgressionConfigurationException {
        if(step == 0) throw new ProgressionConfigurationException("The step is zero! Enter new number!");
        this.initial = initial;
        this.step = step;
    }

     int calculate(int n) throws ProgressionConfigurationException {
        if(n <= 0) throw new ProgressionConfigurationException("N must be bigger than zero!");
        return initial + step * (n - 1);

    }
}

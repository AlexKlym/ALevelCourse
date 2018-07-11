package hometask.hometask_oop_2;

public abstract class Sub implements Substance {
    double temperature = 20;
    abstract double boiling();
    abstract double melting();

    public State heatUp(double temperature){
        this.temperature += temperature;
        if(this.temperature >= boiling()){
            return State.GAS;
        }else if(this.temperature <= melting()){
            return State.SOLID;
        }else{
            return State.LIQUID;
        }
    }
    @Override
    public double getTemperature(){
        return temperature;
    }
}

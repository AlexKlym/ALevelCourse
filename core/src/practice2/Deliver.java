package practice2;

public class Deliver {

    public Transport transport;

    public void deliver(Package pack, City start, City end){
        double cost = transport.deliver(pack);
        System.out.println("Package " + pack.getName() + " was delivered by " + transport.getName() + " from " + start + " to " + end + ". The price is " + cost );
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }


}

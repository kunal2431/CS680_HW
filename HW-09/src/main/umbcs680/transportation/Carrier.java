package umbcs680.transportation;

public class Carrier extends TPElement{

    public Carrier(Mode type, String name, String fuelType, String model){
        super(type, name, fuelType, model);
    }

    public boolean isMode() {
        return false;
    }

    public boolean isLink() {
        return false;
    }

    public void accept(TPVisitor v) {
        v.visit(this);
    }

}
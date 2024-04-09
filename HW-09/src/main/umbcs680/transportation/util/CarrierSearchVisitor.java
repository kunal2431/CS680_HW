package umbcs680.transportation.util;
import umbcs680.transportation.ts.*;

import java.util.LinkedList;

public class CarrierSearchVisitor implements TPVisitor{

    private String CarrierName;

    protected LinkedList<Carrier> foundCarrier = new LinkedList<Carrier>();

    public CarrierSearchVisitor(String CarrierName){
        this.CarrierName = CarrierName;
    }

    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Mode mode) {
        return;
    }

    @Override
    public void visit(Carrier carrier) {
        if(carrier.getName().equals(CarrierName)){
            foundCarrier.add(carrier); }
    }

    public LinkedList<Carrier> getFoundCarrier(){
        return foundCarrier;
    }
}
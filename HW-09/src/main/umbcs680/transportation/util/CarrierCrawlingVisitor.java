package umbcs680.transportation.util;
import umbcs680.transportation.ts.*;

import java.util.LinkedList;

public class CarrierCrawlingVisitor implements TPVisitor{

    protected LinkedList<Carrier> Carrier_visitor = new LinkedList<Carrier>();

    public CarrierCrawlingVisitor(){}

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
        Carrier_visitor.add(carrier);
    }

    public LinkedList<Carrier> getCarrierVisitor(){
        return Carrier_visitor;
    }
}

package umbcs680.transportation;

import java.util.LinkedList;

interface TPVisitor{
    void visit(Link link);
    void visit(Mode mode);
    void visit(Carrier carrier);
}

class CountingVisitor implements TPVisitor{

    private int modNum = 0;
    private int carrNum = 0;
    private int linkNum = 0;

    public CountingVisitor(){}

    @Override
    public void visit(Link link) {
        linkNum++;
    }

    @Override
    public void visit(Mode dir) {
        modNum++;
    }

    @Override
    public void visit(Carrier file) {
        carrNum++;
    }

    public int getModNum(){
        return modNum;
    }

    public int getCarrNum(){
        return carrNum;
    }

    public int getLinkNum(){
        return linkNum;
    }
}

class CarrierCrawlingVisitor implements TPVisitor{

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

class CarrierSearchVisitor implements TPVisitor{

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
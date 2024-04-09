package umbcs680.transportation.ts;

import java.util.LinkedList;

public class Mode extends TPElement{

    protected LinkedList<TPElement> children = new LinkedList<TPElement>();
    protected LinkedList<Mode> modes = new LinkedList<Mode>();
    protected LinkedList<Carrier> carrier = new LinkedList<Carrier>();

    protected LinkedList<Link> links = new LinkedList<Link>();

    public Mode(Mode type, String name, String fuelType, String model){
        super(type, name, null, null);
    }

    public LinkedList<TPElement> getChildren(){return this.children;}

    public void appendChild(TPElement child){
        this.children.add(child);
        child.setType(this);
    }

    public int countChildren(){
        return this.children.size();
    }

    public LinkedList<Mode> getModes(){
        modes.clear();
        for(TPElement child: children ){
            if(child.isMode() == true){
                this.modes.add((Mode) child);
                this.modes.addAll(((Mode) child).getModes());
            }
        }
        return this.modes;
    }

    public LinkedList<Carrier> getCarrier(){
        carrier.clear();
        for(TPElement child: children ){
            if(child.isMode() == false && child.isLink() == false){
                this.carrier.add((Carrier) child);
            }
        }
        return this.carrier;
    }

    public boolean isMode() {
        return true;
    }

    public boolean isLink() {
        return false;
    }

    public LinkedList<Link> getLink(){
        links.clear();
        for(TPElement child: children){
            if(child.isLink() == true){
                this.links.add((Link) child);
            }
        }
        return this.links;
    }

    public void accept(TPVisitor v) {
        v.visit(this);
        for (TPElement e: children){
            e.accept(v);
        }
    }

}
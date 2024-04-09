package umbcs680.transportation.ts;

public class Link extends TPElement{

    private TPElement target;

    public Link(Mode type, String name, String fuelType, String model, TPElement target){
        super(type, name, null, null);
        this.target = target;
    }

    public boolean isMode() {
        return false;
    }

    public boolean isLink() {
        return true;
    }

    public void accept(TPVisitor v) {
        v.visit(this);
    }

    public TPElement getLinkTarget(){
        return this.target;
    }

}
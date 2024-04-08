package umbcs680.transportation;

abstract class TPElement{

    protected String name;
    protected String fuelType;
    protected String model;

    protected Mode type;

    public TPElement(Mode type, String name, String fuelType, String model){
        this.type = type;
        this.name = name;
        this.fuelType = fuelType;
        this.model = model;
    }

    public Mode getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public String getFuelType(){return this.fuelType;}

    public String getModel(){return this.model;}

    public void setType(Mode type) {
        this.type=type;
    }

    public abstract boolean isMode();

    public abstract boolean isLink();

    public abstract void accept(TPVisitor v);

}
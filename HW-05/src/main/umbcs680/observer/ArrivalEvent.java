package umbcs680.observer;

public class ArrivalEvent{
	private String[] event = null;

    public ArrivalEvent(String[] event){
        this.event=event;
    }

    public String[] getArrivalEvent() {
        return event;
    }
}
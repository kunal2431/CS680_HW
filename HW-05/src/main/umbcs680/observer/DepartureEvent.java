package umbcs680.observer;

public class DepartureEvent{
    private String[] event = null;

    public DepartureEvent(String[] event){
        this.event=event;
    }

    public String[] getDepartureEvent() {
        return event;
    }
}


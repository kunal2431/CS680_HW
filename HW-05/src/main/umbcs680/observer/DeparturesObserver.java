package umbcs680.observer;


public interface DeparturesObserver<DepartureEvent>{

    public void updateDeparture(DeparturesObervable<DepartureEvent> sender, DepartureEvent event);
}
package umbcs680.leobserver;


public interface DeparturesObserver<DepartureEvent>{

    public void updateDeparture(DeparturesObervable<DepartureEvent> sender, DepartureEvent event);
}
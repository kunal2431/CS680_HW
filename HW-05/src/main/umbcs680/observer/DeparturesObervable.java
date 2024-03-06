package umbcs680.observer;

import java.util.LinkedList;
import java.util.List;

public class DeparturesObervable<DepartureEvent>{
    private LinkedList<DeparturesObserver<DepartureEvent>> Depobservers = new LinkedList<>();


    public void addObserver(DeparturesObserver<DepartureEvent> o) {
        Depobservers.add(o);
    }


    public void clearObservers() {
        Depobservers.clear();

    }

    public List<DeparturesObserver<DepartureEvent>> getObservers(){
        return Depobservers;
    }


    public int countObservers() {
        return Depobservers.size();

    }
    public void removeObserver(DeparturesObserver<DepartureEvent> o) {
        Depobservers.remove(o);
    }


    public void notifyObservers(DepartureEvent event) {
        for(DeparturesObserver<DepartureEvent> ob: Depobservers) {
            ob.updateDeparture(this, event);
        }
    }

}


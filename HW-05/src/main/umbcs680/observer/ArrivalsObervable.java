package umbcs680.observer;

import java.util.LinkedList;
import java.util.List;

public class ArrivalsObervable<ArrivalEvent>{

    private LinkedList<ArrivalsObserver<ArrivalEvent>> arrobservers = new LinkedList<>();


    public void addObserver(ArrivalsObserver<ArrivalEvent> o) {
        arrobservers.add(o);
    }


    public void clearObservers() {
        arrobservers.clear();

    }

    public List<ArrivalsObserver<ArrivalEvent>> getObservers() {
        return arrobservers;
    }

    public int countObservers() {
        return arrobservers.size();

    }

    public void removeObserver(ArrivalsObserver<ArrivalEvent> o) {
        arrobservers.remove(o);
    }


    public void notifyObservers(ArrivalEvent event) {
        for(ArrivalsObserver<ArrivalEvent> ob: arrobservers) {
            ob.updateArrivals(this, event);
        }
    }

}

package umbcs680.observer;


public interface ArrivalsObserver<ArrivalEvent>{

    public void updateArrivals(ArrivalsObervable<ArrivalEvent> sender, ArrivalEvent event);

}
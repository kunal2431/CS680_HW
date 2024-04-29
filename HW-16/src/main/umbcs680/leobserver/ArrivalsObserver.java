package umbcs680.leobserver;


public interface ArrivalsObserver<ArrivalEvent>{

    public void updateArrivals(ArrivalsObervable<ArrivalEvent> sender, ArrivalEvent event);

}
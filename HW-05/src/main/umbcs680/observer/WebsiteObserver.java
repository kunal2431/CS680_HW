package umbcs680.observer;


public class WebsiteObserver implements DeparturesObserver<DepartureEvent>, ArrivalsObserver<ArrivalEvent> {

    private String[] actualArrEvent = null;
    private String[] actualDepEvent = null;
    @Override
    public void updateArrivals(ArrivalsObervable<ArrivalEvent> sender, ArrivalEvent event) {
//        System.out.println("Website");
//        System.out.println("Arrival Event: ");
//        System.out.println("Flight Number, Route, Status, Gate");
//        for (String ele : event.getEvent()) {
//            System.out.print(ele + ", ");
//        }
//        System.out.println();
//        System.out.println("--------------");
        actualArrEvent = event.getArrivalEvent();
    }


    @Override
    public void updateDeparture(DeparturesObervable<DepartureEvent> sender, DepartureEvent event) {
//        System.out.println("Website");
//        System.out.println("Departure Event: ");
//        System.out.println("Flight Number, Route, Status, Gate");
//        for (String ele : event.getEvent()) {
//            System.out.print(ele + ", ");
//        }
//        System.out.println();
//        System.out.println("--------------");
        actualDepEvent = event.getDepartureEvent();
    }

    public String[] getactualArrEvent(){
        return actualArrEvent;
    }

    public String[] getactualDepEvent(){
        return actualDepEvent;
    }
}

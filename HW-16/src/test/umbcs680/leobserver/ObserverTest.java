package umbcs680.leobserver;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest{
    @Test
    //Test Case 1: Functional Test: Verify Board and Website observers receives Departure and Arrival events
    public void verifyObservers(){
        String[] depEvent = {"NK1220", "Bos to ATL", "Security", "27"};
        LinkedList<String[]> depE = new LinkedList<>();
        depE.add(depEvent);
        DepartureEvent cut = new DepartureEvent(depEvent);
        DeparturesObervable<DepartureEvent> dep = new DeparturesObervable<>();
        LinkedList<String[]> actual = new LinkedList<>();
        DeparturesObserver<DepartureEvent> board = (sender, event) ->{
            actual.add(event.getDepartureEvent());
        };
        DeparturesObserver<DepartureEvent> website = (sender, event) ->{
            actual.add(event.getDepartureEvent());
        };
        dep.addObserver(board);
        dep.addObserver(website);
        dep.notifyObservers(cut);
        assertEquals(depE.getFirst(), actual.getFirst());
        assertEquals(depE.getFirst(), actual.get(1));

        String[] arrEvent = {"NK1484", "SFO to BOS", "OnTime", "16"};
        LinkedList<String[]> arrE = new LinkedList<>();
        arrE.add(arrEvent);
        ArrivalEvent cut1 = new ArrivalEvent(arrEvent);
        ArrivalsObervable<ArrivalEvent> arr = new ArrivalsObervable<>();
        LinkedList<String[]> actual1 = new LinkedList<>();
        ArrivalsObserver<ArrivalEvent> board1 = (sender, event) ->{
            actual1.add(event.getArrivalEvent());
        };
        ArrivalsObserver<ArrivalEvent> website1 = (sender, event) ->{
            actual1.add(event.getArrivalEvent());
        };
        arr.addObserver(board1);
        arr.addObserver(website1);
        arr.notifyObservers(cut1);
        assertEquals(arrE.getFirst(), actual1.getFirst());
        assertEquals(arrE.getFirst(), actual1.get(1));
    }

    @Test
    //Test Case 2: Functional Test: Verify Departure and Arrival event are notified to multiple Board and Website observers;
    // Also verifies Arrival and Departure event is not notified to one of the website observer(website2) which is removed before notifying.
    public void verifyMultipleObservers(){
        String[] depEvent = {"NK1214", "Bos to LAX", "Boarding Closed", "32"};
        LinkedList<String[]> depE = new LinkedList<>();
        depE.add(depEvent);
        DepartureEvent cut = new DepartureEvent(depEvent);
        DeparturesObervable<DepartureEvent> dep = new DeparturesObervable<>();
        LinkedList<String[]> actual = new LinkedList<>();
        DeparturesObserver<DepartureEvent> board = (sender, event) ->{
            actual.add(event.getDepartureEvent());
        };
        DeparturesObserver<DepartureEvent> website = (sender, event) ->{
            actual.add(event.getDepartureEvent());
        };
        DeparturesObserver<DepartureEvent> board2 = (sender, event) ->{
            actual.add(event.getDepartureEvent());
        };
        DeparturesObserver<DepartureEvent> website2 = (sender, event) ->{
            actual.add(event.getDepartureEvent());
        };
        dep.addObserver(board);
        dep.addObserver(board2);
        dep.addObserver(website);
        dep.addObserver(website2);
        dep.removeObserver(website2);
        dep.notifyObservers(cut);
        assertEquals(depE.getFirst(), actual.getFirst());
        assertEquals(depE.getFirst(), actual.get(1));
        assertEquals(depE.getFirst(), actual.get(2));
        assertEquals(3, actual.size()); // Size of List is 3 because Departure event is not received/added in list for observer Website2

        String[] arrEvent = {"NK1214", "Bos to LAX", "Boarding Closed", "32"};
        LinkedList<String[]> arrE = new LinkedList<>();
        arrE.add(arrEvent);
        ArrivalEvent cut1 = new ArrivalEvent(arrEvent);
        ArrivalsObervable<ArrivalEvent> arr = new ArrivalsObervable<>();
        LinkedList<String[]> actual1 = new LinkedList<>();
        ArrivalsObserver<ArrivalEvent> board_A = (sender, event) ->{
            actual1.add(event.getArrivalEvent());
        };
        ArrivalsObserver<ArrivalEvent> website_A = (sender, event) ->{
            actual1.add(event.getArrivalEvent());
        };
        ArrivalsObserver<ArrivalEvent> board2_A = (sender, event) ->{
            actual1.add(event.getArrivalEvent());
        };
        ArrivalsObserver<ArrivalEvent> website2_A = (sender, event) ->{
            actual1.add(event.getArrivalEvent());
        };
        arr.addObserver(board_A);
        arr.addObserver(website_A);
        arr.addObserver(website_A);
        arr.addObserver(website2_A);
        arr.removeObserver(website2_A);
        arr.notifyObservers(cut1);
        assertEquals(arrE.getFirst(), actual1.getFirst());
        assertEquals(arrE.getFirst(), actual1.get(1));
        assertEquals(arrE.getFirst(), actual1.get(2));
        assertEquals(3, actual.size()); // Size of List is 3 because Arrival event is not received/added in list for observer Website2
    }

    @Test
    //Test Case 3: Structural Test: verifies various methods of Observable class - Positive Test.
    public void verifyObservableMethods(){
        String[] depEvent = {"NK1560", "Bos to NY", "Delayed", "08"};
        DepartureEvent cut = new DepartureEvent(depEvent);
        DeparturesObervable<DepartureEvent> dep = new DeparturesObervable<>();
        LinkedList<String[]> actual = new LinkedList<>();
        DeparturesObserver<DepartureEvent> board = (sender, event) ->{
            actual.add(event.getDepartureEvent());
        };
        DeparturesObserver<DepartureEvent> website = (sender, event) ->{
            actual.add(event.getDepartureEvent());
        };
        DeparturesObserver<DepartureEvent> board2 = (sender, event) ->{
            actual.add(event.getDepartureEvent());
        };
        DeparturesObserver<DepartureEvent> website2 = (sender, event) ->{
            actual.add(event.getDepartureEvent());
        };
        dep.addObserver(board);
        dep.addObserver(board2);
        dep.addObserver(website);
        dep.addObserver(website2);
        assertEquals(4, dep.countObservers());
        dep.removeObserver(board2);
        assertEquals(3, dep.countObservers());
        assertEquals(3, dep.getObservers().size());
        dep.clearObservers();
        assertEquals(0, dep.countObservers());
    }

    @Test
    //Test Case 4: Functional Test: Verify observers receive latest event updates - Positive Test.
    public void verifyMultpleUpdate(){
        String[] depEvent = {"NK1241", "Bos to DAL", "Delayed", "12"};
        LinkedList<String[]> depE = new LinkedList<>();
        depE.add(depEvent);
        DepartureEvent cut = new DepartureEvent(depEvent);
        DeparturesObervable<DepartureEvent> dep = new DeparturesObervable<>();
        LinkedList<String[]> actual = new LinkedList<>();
        DeparturesObserver<DepartureEvent> board = (sender, event) ->{
            actual.add(event.getDepartureEvent());
        };
        dep.addObserver(board);
        dep.notifyObservers(cut);
        assertEquals(depE.getFirst(), actual.getFirst());
        String[] depEvent2 = {"NK1241", "Bos to DAL", "Cancelled", "NA"};
        depE.add(depEvent2);
        DepartureEvent cut2 = new DepartureEvent(depEvent2);
        dep.notifyObservers(cut2);
        assertEquals(depE.get(1), actual.get(1));
    }

}
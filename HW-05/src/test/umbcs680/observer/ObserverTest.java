package umbcs680.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest{
    @Test
    //Test Case 1: Functional Test: Verify Board and Website observers receives Departure and Arrival events when notified - Positive Test
    public void verifyObservers(){
        String[] depEvent = {"NK1220", "Bos to ATL", "Security", "27"};
        DepartureEvent cut = new DepartureEvent(depEvent);
        assertTrue(cut instanceof DepartureEvent);
        DeparturesObervable<DepartureEvent> dep = new DeparturesObervable<>();
        assertTrue(dep instanceof DeparturesObervable);
        BoardObserver board = new BoardObserver();
        assertTrue(board instanceof BoardObserver);
        WebsiteObserver web = new WebsiteObserver();
        assertTrue(web instanceof WebsiteObserver);
        dep.addObserver(board);
        dep.addObserver(web);
        dep.notifyObservers(cut);
        assertEquals(depEvent, board.getactualDepEvent());
        assertEquals(depEvent, web.getactualDepEvent());


        String[] arrEvent = {"NK1444", "ATL to BOS", "Delayed", "NA"};
        ArrivalEvent cut1 = new ArrivalEvent(arrEvent);
        assertTrue(cut1 instanceof ArrivalEvent);
        ArrivalsObervable<ArrivalEvent> arr = new ArrivalsObervable<>();
        assertTrue(arr instanceof ArrivalsObervable);
        arr.addObserver(board);
        arr.addObserver(web);
        arr.notifyObservers(cut1);
        assertEquals(arrEvent, board.getactualArrEvent());
        assertEquals(arrEvent, web.getactualArrEvent());
    }

    @Test
    //Test Case 2: Functional Test: Verify Departure and Arrival event are notified to multiple Board and Website observers;
    // Also verifies Arrival event is not notified to one of the board observer(board3) which is removed before notifying. - Positive Test
    public void verifyMultipleObservers(){
        String[] depEvent = {"NK1214", "Bos to LAX", "Boarding Closed", "32"};
        DepartureEvent cut = new DepartureEvent(depEvent);
        DeparturesObervable<DepartureEvent> dep = new DeparturesObervable<>();
        BoardObserver board1 = new BoardObserver();
        BoardObserver board2 = new BoardObserver();
        WebsiteObserver web1 = new WebsiteObserver();
        WebsiteObserver web2 = new WebsiteObserver();
        dep.addObserver(board1);
        dep.addObserver(board2);
        dep.addObserver(web1);
        dep.addObserver(web2);
        dep.notifyObservers(cut);
        assertEquals(depEvent, board1.getactualDepEvent());
        assertEquals(depEvent, board2.getactualDepEvent());
        assertEquals(depEvent, web1.getactualDepEvent());
        assertEquals(depEvent, board2.getactualDepEvent());

        String[] arrEvent = {"NK1484", "SFO to BOS", "OnTime", "16"};
        ArrivalEvent cut1 = new ArrivalEvent(arrEvent);
        ArrivalsObervable<ArrivalEvent> arr = new ArrivalsObervable<>();
        arr.addObserver(board1);
        arr.addObserver(board2);
        BoardObserver board3 = new BoardObserver();
        arr.addObserver(board3);
        arr.removeObserver(board3);
        arr.addObserver(web1);
        arr.addObserver(web2);
        arr.notifyObservers(cut1);
        assertEquals(arrEvent, board1.getactualArrEvent());
        assertEquals(arrEvent, board2.getactualArrEvent());
        assertEquals(arrEvent, web1.getactualArrEvent());
        assertEquals(arrEvent, board2.getactualArrEvent());
        assertNull(board3.getactualArrEvent());
    }

    @Test
    //Test Case 3: Structural Test: verifies various methods of Observable class - Positive Test.
    public void verifyObservableMethods(){
        String[] depEvent = {"NK1560", "Bos to NY", "Delayed", "08"};
        DepartureEvent cut = new DepartureEvent(depEvent);
        DeparturesObervable<DepartureEvent> dep = new DeparturesObervable<>();
        BoardObserver board1 = new BoardObserver();
        BoardObserver board2 = new BoardObserver();
        WebsiteObserver web1 = new WebsiteObserver();
        WebsiteObserver web2 = new WebsiteObserver();
        dep.addObserver(board1);
        dep.addObserver(board2);
        dep.addObserver(web1);
        dep.addObserver(web2);
        assertEquals(4, dep.countObservers());
        dep.removeObserver(web1);
        assertEquals(3, dep.countObservers());
        assertEquals(3, dep.getObservers().size());
        dep.clearObservers();
        assertEquals(0, dep.countObservers());
    }

    @Test
    //Test Case 4: Functional Test: Verify observers receive latest event updates - Positive Test.
    public void verifyMultpleUpdate(){
        String[] depEvent1 = {"NK1241", "Bos to DAL", "Delayed", "12"};
        DepartureEvent cut1 = new DepartureEvent(depEvent1);
        DeparturesObervable<DepartureEvent> dep = new DeparturesObervable<>();
        BoardObserver board1 = new BoardObserver();
        dep.addObserver(board1);
        dep.notifyObservers(cut1);
        assertEquals(depEvent1, board1.getactualDepEvent());
        String[] depEvent2 = {"NK1241", "Bos to DAL", "Cancelled", "NA"};
        DepartureEvent cut2 = new DepartureEvent(depEvent2);
        dep.notifyObservers(cut2);
        assertEquals(depEvent2, board1.getactualDepEvent());
    }
}
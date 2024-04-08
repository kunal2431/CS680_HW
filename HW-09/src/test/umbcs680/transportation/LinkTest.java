package umbcs680.transportation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class LinkTest{

    private static TrasportationSystem fs;
    private static Mode Land;
    private static Mode Water;
    private static Mode Air;
    private static Mode Car;
    private static Mode Railway;
    private static Mode RoadTransport;
    private static Mode Truck;
    private static Carrier Amtrak;
    private static Mode CruiseShip;
    private static Mode CargoShip;
    private static Mode ComercialPlane;
    private static Mode CargoPlane;
    private  static Carrier Tesla;
    private  static Carrier Audi;
    private  static Carrier Scania;
    private  static Carrier Harmony;
    private  static Carrier Triumph;
    private  static Carrier Airbus;
    private  static Carrier Boeing;
    private static Link Audi_Link;
    private static Link Scania_Link;

    @BeforeAll
    public static void setUpTP(){
        fs = TestFixtureInitializer.createTS();
        Land = fs.getRootMode().getFirst();
        Air = fs.getRootMode().get(1);
        Water = fs.getRootMode().get(2);
        Railway = Land.getModes().getFirst();
        RoadTransport = Land.getModes().get(1);
        Car = RoadTransport.getModes().getFirst();
        Truck = RoadTransport.getModes().get(1);
        Tesla = Car.getCarrier().getFirst();
        Amtrak = Railway.getCarrier().getFirst();
        Audi = Car.carrier.get(1);
        Scania = Truck.getCarrier().getFirst();
        CruiseShip = Water.getModes().getFirst();
        CargoShip = Water.getModes().get(1);
        Harmony = CruiseShip.getCarrier().getFirst();
        Triumph = CargoShip.getCarrier().getFirst();
        ComercialPlane = Air.getModes().getFirst();
        CargoPlane = Air.getModes().get(1);
        Airbus = ComercialPlane.getCarrier().getFirst();
        Boeing = CargoPlane.getCarrier().getFirst();
        Scania_Link = CargoPlane.getLink().getFirst();
        Audi_Link = CruiseShip.getLink().getFirst();
    }

    private String[] linkToStringArray(Link l){
        String[] modeInfo = { l.getName(), l.getFuelType(), l.getModel()};
        return modeInfo;
    }

    @Test
    //Test Case 1: Functional Test: Verify Equality Check in Link
    public void verifyEqualityCheckLink(){
        String[] expected = {"Scania_Link", null, null};
        assertTrue(Scania_Link instanceof Link);
        assertArrayEquals(expected, linkToStringArray(Scania_Link));
        assertFalse(Scania_Link.isMode());
        assertTrue(Scania_Link.isLink());
    }

    @Test
    //Test Case 2: Functional Test: verify Links in a Carrier
    public void verifyLinkInCarrier(){
        LinkedList<Link> actual = CruiseShip.getLink();
        assertTrue(actual.getFirst() instanceof Link);
        assertEquals(1, actual.size());
        assertTrue(actual.contains(Audi_Link));
        assertFalse(actual.contains(Scania_Link));
    }

    @Test
    //Test Case 3: Structural Test: Verify public methods getLinkTarget()
    public void verifyLink_getLinkTarget(){
        TPElement actual = Audi_Link.getLinkTarget();
        assertSame(Audi, actual);
    }

}
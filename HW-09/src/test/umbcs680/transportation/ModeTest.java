package umbcs680.transportation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

public class ModeTest{

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

    private String[] modeToStringArray(Mode m){
        String[] modeInfo = { m.getName(), m.getFuelType(), m.getModel()};
        return modeInfo;
    }

    @Test
    //Test Case 1: Functional Test: Verify Mode Equality Check for directory "CargoShip"
    public void verifyModeEqualityCheck_CargoShip(){
        String[] expected = {"CargoShip", null, null};
        assertTrue(CargoShip instanceof Mode);
        assertArrayEquals(expected, modeToStringArray(CargoShip));
        assertTrue(CargoShip.isMode());
    }

    @Test
    //Test Case 2: Functional Test: Verify Mode Equality Check for directory "Land"
    public void verifyModeEqualityCheck_Land(){
        String[] expected = {"Land", null, null};
        assertArrayEquals(expected, modeToStringArray(Land));
    }


    @Test
    //Test Case 3: Structural Test: Verify countChildren() and getChildren() methods
    public void verifyMode_countChildren_getChildren(){
        LinkedList<TPElement> actual = Car.getChildren();
        assertEquals(2, Car.countChildren());
        assertTrue(actual.contains(Tesla));
        assertTrue(actual.contains(Audi));
        assertFalse(actual.contains(Airbus));
        assertFalse(actual.contains(CargoShip));
        assertFalse(actual.contains(Triumph));
    }

    @Test
    //Test Case 4: Structural Test: Verify getModes() method
    public void verifyModes_getModes(){
        LinkedList<Mode> actual = Air.getModes();
        assertEquals(2, actual.size());
        assertTrue(actual.contains(ComercialPlane));
        assertTrue(actual.contains(CargoPlane));
        assertFalse(actual.contains(CruiseShip));
        assertFalse(actual.contains(Railway));
    }

    @Test
    //Test Case 5: Structural Test: Verify getCarrier()
    public void verifyModes_getCarrier(){
        LinkedList<Carrier> actual = Car.getCarrier();
        assertEquals(2, actual.size());
        assertTrue(actual.contains(Tesla));
        assertTrue(actual.contains(Audi));
        assertFalse(actual.contains(Amtrak));
        assertFalse(actual.contains(Boeing));
    }
}
package umbcs680.transportation.ts;
import  umbcs680.transportation.TestFixtureInitializer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class CarrierTest{

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
        Audi = Car.getCarrier().get(1);
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

    private String[] carrierToStringArray(Carrier c){
        String[] carrierInfo = { c.getName(), c.getFuelType(), c.getModel()};
        return carrierInfo;
    }

    @Test
    //Test Case 1: Structural Test: Verify public methods getCarrier()
    public void verifyCarrier_getCarrier(){
        LinkedList<Carrier> actual = ComercialPlane.getCarrier();
        assertEquals(1, actual.size());
        assertTrue(actual.contains(Airbus));
        assertFalse(Airbus.isMode());
    }

    @Test
    //Test Case 2: Functional Test: Verify Carrier Equality Check for file "Audi"
    public void verifyCarrierEqualityCheck_Audi(){
        String[] expected = {"Audi", "Gas", "Q8"};
        assertTrue(Audi instanceof Carrier);
        assertArrayEquals(expected, carrierToStringArray(Audi));
        assertFalse(Audi.isMode());
    }

    @Test
    //Test Case 3: Functional Test: Verify Carrier Equality Check for file "Airbus"
    public void verifyCarrierEqualityCheck_Airbus(){
        String[] expected = {"Airbus", "Avgas", "A350-900"};
        assertTrue(Airbus instanceof Carrier);
        assertArrayEquals(expected, carrierToStringArray(Airbus));
    }

}
package umbcs680.transportation.ts;
import  umbcs680.transportation.TestFixtureInitializer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class TransportationSystemTest{
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

    @Test
    //Test Case 1: Structural Test: Verify getRootMode() method
    public void verifyFileSystem_getRootMode(){
        LinkedList<Mode> rootMod = fs.getRootMode();
        assertTrue(rootMod.contains(Water));
        assertTrue(rootMod.contains(Air));
        assertTrue(rootMod.contains(Land));
        assertFalse(rootMod.contains(RoadTransport));
    }

    @Test
    //Test Case 2: Functional Test: Verify Singleton
    public void verifyTransportationSystem_Singleton(){
        TrasportationSystem cut1 = TrasportationSystem.getTransportationSystem();
        assertSame(fs, cut1);
    }

    @Test
    //Test Case 3: Structural Test: Verify getParent() method
    public void verifyCarrierElement_getType(){
        Mode actual = Car.getType();
        assertSame(RoadTransport, actual);
    }

}
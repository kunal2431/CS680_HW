package umbcs680.transportation;

public class TestFixtureInitializer{

    public static TrasportationSystem createTS(){

        TrasportationSystem cut = TrasportationSystem.getTransportationSystem();
        Mode Land = new Mode(null, "Land", null, null);
        cut.appendRootMode(Land);
        Mode Air = new Mode(null, "Air", null, null);
        cut.appendRootMode(Air);
        Mode Water = new Mode(null, "Water", null, null);
        cut.appendRootMode(Water);
        Mode Railway = new Mode(Land, "Railway", null, null);
        Land.appendChild(Railway);
        Mode RoadTransport = new Mode(Land, "Road Transport", null, null);
        Land.appendChild(RoadTransport);
        Mode Car = new Mode(RoadTransport, "Car", null, null);
        RoadTransport.appendChild(Car);
        Mode Truck = new Mode(RoadTransport, "Truck", null, null);
        RoadTransport.appendChild(Truck);
        Carrier Tesla = new Carrier(Car, "Tesla", "Electric", "Y");
        Car.appendChild(Tesla);
        Carrier Audi = new Carrier(Car, "Audi", "Gas", "Q8");
        Car.appendChild(Audi);
        Carrier Scania = new Carrier(Truck, "Scania", "Diesel", "R 730 V8");
        Truck.appendChild(Scania);
        Carrier Amtrak = new Carrier(Railway, "Amtrak", "Diesel", "GE Genesis P40DC");
        Railway.appendChild(Amtrak);
        Mode CruiseShip = new Mode(Water, "CruiseShip", null, null);
        Water.appendChild(CruiseShip);
        Mode CargoShip = new Mode(Water, "CargoShip", null, null);
        Water.appendChild(CargoShip);
        Carrier Harmony = new Carrier(CruiseShip, "CruiseShip", "liquefied natural gas", "Harmony of the Seas");
        CruiseShip.appendChild(Harmony);
        Carrier Triumph = new Carrier(CargoShip, "CargoShip", "bunker fuel", "MOL Triumph");
        CargoShip.appendChild(Triumph);
        Mode CommercialPlane = new Mode(Air, "CommercialPlane", null, null);
        Air.appendChild(CommercialPlane);
        Mode CargoPlane = new Mode(Air, "CargoPlane", null, null);
        Air.appendChild(CargoPlane);
        Carrier Airbus = new Carrier(CommercialPlane, "Airbus", "Avgas", "A350-900");
        CommercialPlane.appendChild(Airbus);
        Carrier Boeing = new Carrier(CargoPlane, "Boeing", "Avgas", "B747");
        CargoPlane.appendChild(Boeing);
        Link Scania_Link = new Link(CargoPlane, "Scania_Link", null, null, Scania);
        CargoPlane.appendChild(Scania_Link);
        Link Audi_Link = new Link(CruiseShip, "Audi_Link", null, null, Audi);
        CruiseShip.appendChild(Audi_Link);

        return cut;
    }

}
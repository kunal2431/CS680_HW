package umbcs680.Car;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest{
    private String[] carToStringArray( Car cut ){
        String[] carInfo = {cut.getMake(),
                cut.getModel(),
                Integer.toString(cut.getYear())};
        return carInfo;
    }
    @Test
    //Test Case 1: Create two Car instances and check their equality with array-to-array comparison
    //Functional Test: Check their return value is same for two instance passed with same Make, Mode, Year. - Positive Test
    public void verifyCarEqualityWithMakeModelYear(){
        //If using static factory method:
        //Car cut = Car.createCar("Toyota", "RAV4", 2018);
        //Car cut1 = Car.createCar("Toyota", "RAV4", 2018);
        Car cut = new Car("Toyota", "RAV4", 2018);
        Car cut1 = new Car("Toyota", "RAV4", 2018);
        assertArrayEquals(carToStringArray(cut), carToStringArray(cut1));
    }

    @Test
    //Test Case 2: Create two Car instances with different properties and check their equality with array-to-array comparison
    //Functional Test: Check their return value is different for two instance passed with different properties and catch AssertionError. - Negative Test
    public void verifyCarEqualityWithMakeModelYearNegTest(){
        //If using static factory method:
        //Car cut = Car.createCar("Dodge", "Charger", 2015);
        //Car cut1 = Car.createCar("Dodge", "Challenger", 2017);
        Car cut = new Car("Dodge", "Charger", 2015);
        Car cut1 = new Car("Dodge", "Challenger", 2017);
        try{
            assertArrayEquals(carToStringArray(cut), carToStringArray(cut1));
            fail("Car properties are different for two instances");
        }
        catch (AssertionError as){
            System.out.println(as.getMessage());
        }
    }

    @Test
    //Test Case 3: Create a Car instances and check their equality with array-to-array comparison
    //Functional Test: Equality check of return value of an instance with an expected String array - Positive Test
    public void verifyCarEqualityWithMakeModelYearSingleInstance(){
        String[] expected = {"BMW", "X5", "2019"};
        //If using static factory method:
        //Car cut = Car.createCar("BMW", "X5", 2019);
        Car cut = new Car("BMW", "X5", 2019);
        assertArrayEquals(expected, carToStringArray(cut));
    }

    @Test
    //Test Case 4: Check getter methods
    //Structural Test: Verify getter methods are returning expected values for different instances - Positive Test
    public void verifyCarEqualityWithMakeModelYearGetter(){
        //If using static factory method:
        //Car cut = Car.createCar("Audi", "R8", 2023);
        Car cut = new Car("Audi", "R8", 2023);
        assertEquals("Audi", cut.getMake());
        assertEquals("R8", cut.getModel());
        assertEquals(2023, cut.getYear());
        //If using static factory method:
        //Car cut = Car.createCar("Nissan", "GTR", 2022);
        Car cut1 = new Car("Nissan", "GTR", 2022);
        assertEquals("Nissan", cut1.getMake());
        assertEquals("GTR", cut1.getModel());
        assertEquals(2022, cut1.getYear());
    }
}
package umbcs680.comparator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class ComparatorTest{

    private static ArrayList<Car> cars = new ArrayList<Car>();

    @BeforeAll
    public static void setUpCar(){
        cars.add(new Car("Supra","Toyota", 24, 2019, 65000));
        cars.add(new Car("GTR", "Nissan", 15, 2017, 45500));
        cars.add(new Car( "Q8", "Audi",10, 2023, 45000));
        cars.add(new Car( "CX5", "Mazda", 24, 2020, 47000));
        cars.add(new Car( "Y", "Tesla", 24, 2019, 48000));
    }

    @Test
    //Test Case 1: Functional Test: Verify PriceComparator
    public void verifyPriceComparator(){
        Collections.sort(cars, new PriceComparator());
        assertEquals("Audi", cars.get(0).getMake());
        assertEquals("Nissan", cars.get(1).getMake());
        assertEquals("Mazda", cars.get(2).getMake());
        assertEquals("Tesla", cars.get(3).getMake());
        assertEquals("Toyota", cars.get(4).getMake());
    }

    @Test
    //Test Case 1: Functional Test: Verify YearComparator
    public void verifyYearComparator(){
        Collections.sort(cars, new YearComparator());
        assertEquals("Audi", cars.get(0).getMake());
        assertEquals("Mazda", cars.get(1).getMake());
        assertEquals("Tesla", cars.get(2).getMake());
        assertEquals("Toyota", cars.get(3).getMake());
        assertEquals("Nissan", cars.get(4).getMake());
    }

    @Test
    //Test Case 1: Functional Test: Verify MileageComparator
    public void verifyMileageComparator(){
        Collections.sort(cars, new MileageComparator());
        assertEquals("Audi", cars.get(0).getMake());
        assertEquals("Nissan", cars.get(1).getMake());
        assertEquals("Mazda", cars.get(2).getMake());
        assertEquals("Tesla", cars.get(3).getMake());
        assertEquals("Toyota", cars.get(4).getMake());
    }


    @Test
    //Test Case 1: Functional Test: Verify ParetoComparator
    public void verifyParetoComparator(){
        for(Car c: cars){
            c.setDominationCount(cars); }
        Collections.sort(cars, new ParetoComparator());
        assertEquals("Nissan", cars.get(0).getMake());
        assertEquals("Toyota", cars.get(1).getMake());
        assertEquals("Tesla", cars.get(2).getMake());
        assertEquals("Mazda", cars.get(3).getMake());
        assertEquals("Audi", cars.get(4).getMake());
        assertEquals(0, cars.get(0).getDominationCount());
        assertEquals(0, cars.get(1).getDominationCount());
        assertEquals(1, cars.get(2).getDominationCount());
        assertEquals(2, cars.get(3).getDominationCount());
        assertEquals(4, cars.get(4).getDominationCount());
    }
}
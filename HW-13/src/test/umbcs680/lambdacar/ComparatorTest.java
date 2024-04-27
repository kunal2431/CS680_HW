package umbcs680.lambdacar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        Collections.sort(cars, (Car car1, Car car2)->{return (int)(car1.getPrice() - car2.getPrice());});
        assertEquals("Audi", cars.get(0).getMake());
        assertEquals("Nissan", cars.get(1).getMake());
        assertEquals("Mazda", cars.get(2).getMake());
        assertEquals("Tesla", cars.get(3).getMake());
        assertEquals("Toyota", cars.get(4).getMake());
    }

    @Test
    //Test Case 2: Functional Test: Verify YearComparator
    public void verifyYearComparator(){
        Collections.sort(cars, (Car car1, Car car2)->{return car1.getYear() - car2.getYear();});
        assertEquals("Nissan", cars.get(0).getMake());
        assertEquals("Tesla", cars.get(1).getMake());
        assertEquals("Toyota", cars.get(2).getMake());
        assertEquals("Mazda", cars.get(3).getMake());
        assertEquals("Audi", cars.get(4).getMake());
    }

    @Test
    //Test Case 3: Functional Test: Verify MileageComparator
    public void verifyMileageComparator(){
        Collections.sort(cars, (Car car1, Car car2)->{return car1.getMileage() - car2.getMileage();});
        assertEquals("Audi", cars.get(0).getMake());
        assertEquals("Nissan", cars.get(1).getMake());
        assertEquals("Tesla", cars.get(2).getMake());
        assertEquals("Toyota", cars.get(3).getMake());
        assertEquals("Mazda", cars.get(4).getMake());
    }


    @Test
    //Test Case 4: Functional Test: Verify ParetoComparator
    public void verifyParetoComparator(){
        for(Car c: cars){
            c.setDominationCount(cars); }
        Collections.sort(cars, (Car car1, Car car2)->{return car1.getDominationCount() - car2.getDominationCount();});
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

        Collections.sort(cars, Comparator.comparing(Car::getDominationCount));
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

        Collections.sort(cars, Comparator.comparing(Car::getDominationCount, Comparator.reverseOrder()));
        assertEquals("Toyota", cars.get(4).getMake());
        assertEquals("Nissan", cars.get(3).getMake());
        assertEquals("Tesla", cars.get(2).getMake());
        assertEquals("Mazda", cars.get(1).getMake());
        assertEquals("Audi", cars.get(0).getMake());
        assertEquals(0, cars.get(4).getDominationCount());
        assertEquals(0, cars.get(3).getDominationCount());
        assertEquals(1, cars.get(2).getDominationCount());
        assertEquals(2, cars.get(1).getDominationCount());
        assertEquals(4, cars.get(0).getDominationCount());
    }

    @Test
    //Test Case 5: Functional Test: Verify PriceComparator using Comparator.comparing and reverseOrder()
    public void verifyPriceComparator_comparing(){
        Collections.sort(cars, Comparator.comparing( Car::getPrice));
        assertEquals("Audi", cars.get(0).getMake());
        assertEquals("Nissan", cars.get(1).getMake());
        assertEquals("Mazda", cars.get(2).getMake());
        assertEquals("Tesla", cars.get(3).getMake());
        assertEquals("Toyota", cars.get(4).getMake());

        Collections.sort(cars, Comparator.comparing(Car::getPrice, Comparator.reverseOrder()));
        assertEquals("Audi", cars.get(4).getMake());
        assertEquals("Nissan", cars.get(3).getMake());
        assertEquals("Mazda", cars.get(2).getMake());
        assertEquals("Tesla", cars.get(1).getMake());
        assertEquals("Toyota", cars.get(0).getMake());
    }

    @Test
    //Test Case 6: Functional Test: Verify YearComparator using Comparator.comparing and reverseOrder()
    public void verifyYearComparator_comparing(){
        Collections.sort(cars, Comparator.comparing(Car::getYear));
        assertEquals("Nissan", cars.get(0).getMake());
        assertEquals("Tesla", cars.get(1).getMake());
        assertEquals("Toyota", cars.get(2).getMake());
        assertEquals("Mazda", cars.get(3).getMake());
        assertEquals("Audi", cars.get(4).getMake());

        Collections.sort(cars, Comparator.comparing(Car::getYear, Comparator.reverseOrder()));
        assertEquals("Nissan", cars.get(4).getMake());
        assertEquals("Toyota", cars.get(3).getMake());
        assertEquals("Tesla", cars.get(2).getMake());
        assertEquals("Mazda", cars.get(1).getMake());
        assertEquals("Audi", cars.get(0).getMake());
    }

    @Test
    //Test Case 7: Functional Test: Verify MileageComparator using Comparator.comparing and reverseOrder()
    public void verifyMileageComparator_comparing(){
        Collections.sort(cars, Comparator.comparing(Car::getMileage));
        assertEquals("Audi", cars.get(0).getMake());
        assertEquals("Nissan", cars.get(1).getMake());
        assertEquals("Mazda", cars.get(2).getMake());
        assertEquals("Tesla", cars.get(3).getMake());
        assertEquals("Toyota", cars.get(4).getMake());

        Collections.sort(cars, Comparator.comparing(Car::getMileage, Comparator.reverseOrder()));
        assertEquals("Audi", cars.get(4).getMake());
        assertEquals("Nissan", cars.get(3).getMake());
        assertEquals("Toyota", cars.get(2).getMake());
        assertEquals("Tesla", cars.get(1).getMake());
        assertEquals("Mazda", cars.get(0).getMake());
    }

}
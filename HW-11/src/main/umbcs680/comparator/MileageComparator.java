package umbcs680.comparator;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car>{
    public int compare(Car car1, Car car2){
        return car1.getMileage() - car2.getMileage();
    }
}
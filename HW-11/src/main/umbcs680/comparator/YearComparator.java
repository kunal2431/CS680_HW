package umbcs680.comparator;

import java.util.Comparator;

public class YearComparator implements Comparator<Car>{
    public int compare(Car car1, Car car2){
        return car2.getYear() - car1.getYear();
    }
}
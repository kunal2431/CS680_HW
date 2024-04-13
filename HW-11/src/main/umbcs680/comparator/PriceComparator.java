package umbcs680.comparator;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {
    public int compare(Car car1, Car car2){
        return (int)(car1.getPrice() - car2.getPrice());
    }
}
package comparator;

import entity.Car;

import java.util.Comparator;

public class CompareByID implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getId().compareToIgnoreCase(o2.getId());
    }
}


package api;

import entity.Car;
import entity.Equipment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;


public class CarStore implements Store<Car>{

    private static final Logger logger = LoggerFactory.getLogger(CarStore.class);

    List<Car> cars;

    public CarStore(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void add(Car good) {
        cars.add(good);
    }

    @Override
    public Car getById(String id) {
        Car o = cars.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst()
                .orElse(null);
        if(Objects.equals(o, null)){
            logger.info("there is no object with ID:{} in the list", id);
        }
        return o;
    }

    public void updateBrand(String id, String brand) {
        cars.stream()
                .filter(car -> car.getId().equals(id))
                .forEach(car -> car.setBrand(brand));
        logger.info("field 'brand' of object with ID:{} has been changed", id);
    }

    public void updateModel(String id, String model) {
        cars.stream()
                .filter(car -> car.getId().equals(id))
                .forEach(car -> car.setModel(model));
        logger.info("field 'model' of object with ID:{} has been changed", id);
    }

    public void updateColor(String id, String color) {
        cars.stream()
                .filter(car -> car.getId().equals(id))
                .forEach(car -> car.setColor(color));
        logger.info("field 'color' of object with ID:{} has been changed", id);
    }

    public void updateEquipment(String id, Equipment equipment) {
        cars.stream()
                .filter(car -> car.getId().equals(id))
                .forEach(car -> car.setEquipment(equipment));
        logger.info("field 'equipment' of object with ID:{} has been changed", id);
    }

    public void updatePrice(String id, double price) {
        cars.stream()
                .filter(car -> car.getId().equals(id))
                .forEach(car -> car.setPrice(price));
        logger.info("field 'price' of object with ID:{} has been changed", id);
    }

    public void updateAll(String id, String brand, String model, String color, Equipment equipment, double price) {
        cars.stream()
                .filter(car -> car.getId().equals(id))
                .forEach(car -> {
                    car.setBrand(brand);
                    car.setModel(model);
                    car.setColor(color);
                    car.setEquipment(equipment);
                    car.setPrice(price);
                });
        logger.info("all fields of object with ID:{} has been changed", id);
    }

    @Override
    public void delete(String id) {
        cars = cars.stream()
                .filter(car -> !car.getId().equals(id))
                .collect(Collectors.toList());
        logger.info("object with ID:{} has been removed from the list", id);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("===List of cars in the store===\n");
        for (int i = 0; i < cars.size(); i++) {
            str.append(i+1).append(": ").append(cars.get(i));
        }
        return str.toString();
    }

    @SafeVarargs
    public final void printByParameter(Function<Car, ?>... parameters) {
        for (Function<Car, ?> parameter : parameters) {
            String result = cars.stream()
                    .map(parameter)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(result);
        }
    }
}

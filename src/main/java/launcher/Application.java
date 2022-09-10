package launcher;

import api.CarStore;
import comparator.*;
import entity.Car;
import entity.Equipment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Equipment basicFront = new Equipment("manual",
                "2.0",
                "fabric",
                "front-wheel");

        Equipment basicRear = new Equipment("manual",
                "1.8",
                "fabric",
                "rear-wheel");

        Equipment lux = new Equipment("automatic",
                "3.2",
                "leather",
                "four-wheel");

        Car car1 = new Car("AD328",
                "AUDI",
                "RS5",
                "blue",
                lux,
                5000);

        Car car2 = new Car("BR953",
                "Volkswagen",
                "golf III",
                "white",
                basicFront,
                1500);

        Car car3 = new Car("AD031",
                "Volkswagen",
                "golf IV",
                "black",
                basicFront,
                2500);

        Car car4 = new Car("GX721",
                "VAZ",
                "2106",
                "green",
                basicRear,
                1200);

        List<Car> car = Arrays.asList(car1, car2, car3);
        List<Car> carList = new ArrayList<>(car);

        CarStore carStore = new CarStore(carList);

        carStore.add(car4);

        System.out.println(car1);

        System.out.println(carStore.getById("AD328"));

        System.out.println(carStore);
        carStore.delete("BR953");
        System.out.println(carStore);

        carStore.updateBrand("AD328", "VW");
        carStore.updateModel("AD328", "Passat");
        carStore.updateColor("AD328", "white");
        carStore.updateEquipment("AD328", basicFront);
        carStore.updatePrice("AD328", 4000);
        System.out.println(car1);

        carStore.updateAll("GX721", "Lada", "2109", "red", basicFront, 1500);
        System.out.println(car4);

        carStore.printByParameter(Car::getPrice);
        Collections.sort(carList);
        carStore.printByParameter(Car::getPrice);

        carStore.printByParameter(Car::getBrand);
        carList.sort(new CompareByBrand());
        carStore.printByParameter(Car::getBrand);

        carStore.printByParameter(Car::getColor);
        carList.sort(new CompareByColor());
        carStore.printByParameter(Car::getColor);

        carStore.printByParameter(Car::getId);
        carList.sort(new CompareByID().reversed());
        carStore.printByParameter(Car::getId);
    }
}

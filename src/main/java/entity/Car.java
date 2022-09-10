package entity;

public class Car implements Comparable<Car> {

    final String id;
    String brand;
    String model;
    String color;
    Equipment equipment;
    Double price;

    public Car(String id, String brand, String model, String color, Equipment equipment, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.equipment = equipment;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "brand - " + brand + '\n' +
                "model - " + model + '\n' +
                "equipment - " + equipment + '\n' +
                "color - " + color + '\n' +
                "price - " + price + "\n" +
                "id - " + id + '\n';
    }

    @Override
    public int compareTo(Car car) {
        return Double.compare(price, car.getPrice());
    }
}


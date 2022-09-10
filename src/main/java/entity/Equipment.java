package entity;

public class Equipment {
    String transmission;
    String engine;
    String upholstery;
    String driveType;

    public Equipment(String transmission, String engine, String upholstery, String driveType) {
        this.transmission = transmission;
        this.engine = engine;
        this.upholstery = upholstery;
        this.driveType = driveType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getUpholstery() {
        return upholstery;
    }

    public void setUpholstery(String upholstery) {
        this.upholstery = upholstery;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    @Override
    public String toString() {
        return "{" +
                "transmission = " + transmission +
                ", engine = " + engine +
                ", upholstery = " + upholstery +
                ", drive type = " + driveType +
                '}';
    }
}
package defining_classes.car_constructors;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    public Car(String brand, String model, int horsepower) {
        this.brand = brand;
        this.model = model;
        this.horsepower = horsepower;
    }

    public Car (String brand) {
        new Car(this.brand = brand, this.model = "unknown", this.horsepower = -1);
    }

    public Car (String brand, String model) {
        new Car(this.brand = brand, this.model = model, this.horsepower = -1);
    }

    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.brand, this.model, this.horsepower);
    }
}

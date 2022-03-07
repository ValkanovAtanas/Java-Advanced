package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in a car dealership ").append(this.name).append(":").append(System.lineSeparator());
        for (Car car : this.data) {
            sb.append(car).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    public int getCount() {
        return this.data.size();
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : this.data) {
            String currManufacturer = car.getManufacturer();
            String currModel = car.getModel();
            if (currManufacturer.equals(manufacturer) && currModel.equals(model)) {
                this.data.remove(car);
                this.capacity++;
                return true;
            }
        }
        return false;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : this.data) {
            String currManufacturer = car.getManufacturer();
            String currModel = car.getModel();
            if (currManufacturer.equals(manufacturer) && currModel.equals(model)) {
                return car;
            }
        }
        return null;
    }

    public Car getLatestCar() {
        Car car = null;
        int latestYear = Integer.MIN_VALUE;
        for (Car currCar : this.data) {
            if (currCar.getYear() > latestYear) {
                latestYear = currCar.getYear();
                car = currCar;
            }
        }
        return car;
    }

    public void add(Car car) {
        if (this.capacity > 0) {
            this.data.add(car);
            this.capacity--;
        }
    }
}

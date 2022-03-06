package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking (String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are parked in ").append(this.type).append(":").append(System.lineSeparator());
        for (Car currCar : this.data) {
            sb.append(currCar).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public int getCount() {
        return this.data.size();
    }

    public Car getCar (String manufacturer, String model) {
        Car car = null;
        for (Car currCar : this.data) {
            if (currCar.getManufacturer().equals(manufacturer) && currCar.getModel().equals(model)) {
                car = currCar;
            }
        }
        return car;
    }

    public Car getLatestCar() {
        int yearOfLatestCar = Integer.MIN_VALUE;
        Car car = null;
        for (Car currCar : this.data) {
            if (currCar.getYear() > yearOfLatestCar) {
                yearOfLatestCar = currCar.getYear();
                car = currCar;
            }
        }
        return car;
    }

    public boolean remove(String manufacturer, String model) {
        for (Car currCar : this.data) {
            if (currCar.getManufacturer().equals(manufacturer) && currCar.getModel().equals(model)) {
                this.data.remove(currCar);
                this.capacity++;
                return true;
            }
        }
        return false;
    }

    public void add(Car car) {
        if (this.capacity > 0) {
            this.data.add(car);
            this.capacity--;
        }
    }
}

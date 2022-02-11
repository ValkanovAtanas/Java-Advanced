package dealership;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> carList;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.carList = new ArrayList<>();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in a car dealership ").append(this.name).append(":").append(System.lineSeparator());
        for (Car car : this.carList) {
            sb.append(car);
        }
        return sb.toString();
    }

    public int getCount() {
        return this.carList.size();
    }

    public boolean buy (String manufacturer, String model) {
        for (Car car : this.carList) {
            String currManufacturer = car.getManufacturer();
            String currModel = car.getModel();
            if(currManufacturer.equals(manufacturer) && currModel.equals(model)) {
                this.carList.remove(car);
                this.capacity++;
                return true;
            }
        }
        return false;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : this.carList) {
            String currManufacturer = car.getManufacturer();
            String currModel = car.getModel();
            if (currManufacturer.equals(manufacturer) && currModel.equals(model)) {
                return car;
            }
        }
        return null;
    }

    public Car getLatestCar() {
        if (this.carList.isEmpty()) {
            return null;
        }
        int latestYear = Integer.MIN_VALUE;
        String latestManufacturer = "";
        String latestModel = "";
        for (Car car : this.carList) {
            String currManufacturer = car.getManufacturer();
            String currModel = car.getModel();
            int currYear = car.getYear();
            if (currYear > latestYear) {
                latestManufacturer = car.getManufacturer();
                latestModel = car.getModel();
                latestYear = car.getYear();
            }
        }
        return new Car(latestManufacturer, latestModel, latestYear);
    }

    public void add(Car car) {
        if (this.capacity > 0) {
            this.carList.add(car);
            this.capacity--;
        }
    }
}

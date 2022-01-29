package defining_classes.speed_racing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostForKilometer;
    private double distanceTraveled = 0;

    public Car(String model, double fuelAmount, double fuelCostForKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForKilometer = fuelCostForKilometer;
    }

    public String getModel() {
        return this.model;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public double getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public void drive(double kmToDrive) {
        double fuelNeeded = this.fuelCostForKilometer * kmToDrive;
        if (fuelNeeded > fuelAmount) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            this.fuelAmount -= fuelNeeded;
            this.distanceTraveled += kmToDrive;
        }
    }
}

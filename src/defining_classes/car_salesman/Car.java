package defining_classes.car_salesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car (String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public Car (String model, Engine engine) {
        this(model, engine, 0, "n/a");
    }

    public Car (String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car (String model, Engine engine, String color) {
        this(model, engine, 0, color);
    }
    public Engine getEngine() {
        return engine;
    }
}

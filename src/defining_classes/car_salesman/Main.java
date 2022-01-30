package defining_classes.car_salesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Engine> engineMap = new LinkedHashMap<>();

        int numOfEngines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfEngines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            String power = tokens[1];
            if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                Engine engine = new Engine(model, power, displacement, efficiency);
                engineMap.put(model, engine);
            } else if (tokens.length == 2) {
                Engine engine = new Engine(model, power);
                engineMap.put(model, engine);
            } else {
                String thirdToken = tokens[2];
                char firstSymbolOfThirdToken = thirdToken.charAt(0);
                if (Character.isDigit(firstSymbolOfThirdToken)) {
                    int displacement = Integer.parseInt(thirdToken);
                    Engine engine = new Engine(model, power, displacement);
                    engineMap.put(model, engine);
                } else {
                    String efficiency = thirdToken;
                    Engine engine = new Engine(model, power, efficiency);
                    engineMap.put(model, engine);
                }
            }
        }
        List<Car> carList = new ArrayList<>();

        int numOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfCars; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            Engine engine = engineMap.get(tokens[1]);
            if (tokens.length == 2) {
                Car car = new Car(model, engine);
                carList.add(car);
            } else if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                Car car = new Car(model, engine, weight, color);
                carList.add(car);
            } else {
                String thirdToken = tokens[2];
                char firstSymbolOfThirdToken = thirdToken.charAt(0);
                if (Character.isDigit(firstSymbolOfThirdToken) == true) {
                    int weight = Integer.parseInt(thirdToken);
                    Car car = new Car(model, engine, weight);
                    carList.add(car);
                } else {
                    String color = thirdToken;
                    Car car = new Car(model, engine, color);
                    carList.add(car);
                }
            }
        }
        carList.stream()
                .forEach(car -> {
                    String displacement;
                    String weight;
                    if (car.getEngine().getDisplacement() != 0) {
                        displacement = String.format("%d", car.getEngine().getDisplacement());
                    } else {
                        displacement = "n/a";
                    }

                    if (car.getWeight() != 0) {
                        weight = String.format("%d", car.getWeight());
                    } else {
                        weight = "n/a";
                    }
                    System.out.printf("%s:%n%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s%n", car.getModel(), car.getEngine().getModel(), car.getEngine().getPower(), displacement, car.getEngine().getEfficiency(), weight, car.getColor());
                });
    }
}

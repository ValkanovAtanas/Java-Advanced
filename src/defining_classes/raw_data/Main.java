package defining_classes.raw_data;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carList = new ArrayList<>();

        int numOfLines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfLines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire = new Tire(tire1Age, tire1Pressure, tire2Age, tire2Pressure, tire3Age, tire3Pressure, tire4Age, tire4Pressure);
            Car car = new Car(model, engine, cargo, tire);
            carList.add(car);
        }
        String cargo = scanner.nextLine();
        if ("fragile".equals(cargo)) {
            carList.stream().filter(car -> car.getCargo().getType().equals("fragile"))
                    .filter(car -> car.getTire().isPressureLowerThanOne() == true)
                    .forEach(car -> System.out.println(car.getModel()));
        } else {
            carList.stream()
                    .filter(car -> car.getCargo().getType().equals("flamable"))
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));
        }
    }
}

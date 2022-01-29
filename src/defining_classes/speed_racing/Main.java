package defining_classes.speed_racing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfLines = Integer.parseInt(scanner.nextLine());
        Map<String, Car> map = new LinkedHashMap<>();

        for (int i = 0; i < numOfLines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            map.put(tokens[0], new Car(tokens[0], Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String modelToDrive = input.split("\\s+")[1];
            double kmToDrive = Double.parseDouble(input.split("\\s+")[2]);
            Car car = map.get(modelToDrive);
            car.drive(kmToDrive);
            map.put(modelToDrive, car);

            input = scanner.nextLine();
        }
        map.entrySet().stream().forEach(entry -> System.out.printf("%s %.2f %.0f%n", entry.getKey(), entry.getValue().getFuelAmount(), entry.getValue().getDistanceTraveled()));
    }
}

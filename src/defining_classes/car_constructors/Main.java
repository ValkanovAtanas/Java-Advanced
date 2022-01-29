package defining_classes.car_constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfLines; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input.length == 1) {
                Car car = new Car(input[0]);
                System.out.println(car);
            } else {
                String model = input[1];
                int horsePower = Integer.parseInt(input[2]);
                Car car = new Car(input[0], model, horsePower);
                System.out.println(car);
            }
        }

    }
}

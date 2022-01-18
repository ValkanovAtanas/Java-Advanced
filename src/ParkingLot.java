import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            action(input, set);

            input = scanner.nextLine();
        }
        if (set.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }
        for (String s : set) {
            System.out.println(s);
        }
    }

    private static Set<String> action(String input, Set<String> set) {
        String[] commandString = input.split(",\\s++");
        String command = commandString[0];
        String plateNum = commandString[1];
        switch (command) {
            case "IN":
                set.add(plateNum);
                break;
            case "OUT":
                set.remove(plateNum);
                break;
        }
        return set;
    }
}

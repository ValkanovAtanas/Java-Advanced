package defining_classes.opinion_poll;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfLines = Integer.parseInt(scanner.nextLine());
        Map<String, Person> myMap = new TreeMap<>();

        for (int i = 0; i < numOfLines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            myMap.put(name, person);
        }
        myMap.entrySet().stream().filter(p -> p.getValue().getAge() > 30)
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue().getAge()));
    }
}

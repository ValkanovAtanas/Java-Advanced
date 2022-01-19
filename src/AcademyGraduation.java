import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfStudents; i++) {
            String studentName = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
            System.out.println();
        }
    }
}

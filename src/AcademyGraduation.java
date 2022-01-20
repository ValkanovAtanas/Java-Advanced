import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, Double> gradesMap = new TreeMap<>();

        for (int i = 0; i < numOfStudents; i++) {
            String studentName = scanner.nextLine();
            double gradesSum = 0;
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
            for (Double grade : grades) {
                gradesSum += grade;
            }
            gradesSum = gradesSum / grades.size();
            gradesMap.put(studentName, gradesSum);
        }
        for (Map.Entry<String, Double> entry : gradesMap.entrySet()) {
            String studentName = entry.getKey();
            double studentGrade = entry.getValue();
            System.out.println(studentName + " is graduated with " + studentGrade);
        }
    }
}

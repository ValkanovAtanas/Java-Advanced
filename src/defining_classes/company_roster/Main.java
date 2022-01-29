package defining_classes.company_roster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Employee> employeeSet = new HashSet<>();

        int numOfLines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfLines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                Employee employee = new Employee(name, salary, position, department, email, age);
                employeeSet.add(employee);

            } else if (tokens.length == 4) {
                Employee employee = new Employee(name, salary, position, department);
                employeeSet.add(employee);
            } else {
                if (tokens[4].contains("@")) {
                    String email = tokens[4];
                    Employee employee = new Employee(name, salary, position, department, email);
                    employeeSet.add(employee);
                } else {
                    int age = Integer.parseInt(tokens[4]);
                    Employee employee = new Employee(name, salary, position, department, age);
                    employeeSet.add(employee);
                }
            }
        }
        Department department = new Department(employeeSet);
        System.out.printf("Highest Average Salary: %s%n", department.highestAverageSalaryDepartment());
        employeeSet.stream()
                .filter(employee -> employee.getDepartment().equals(department.highestAverageSalaryDepartment()))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(e -> System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
    }
}

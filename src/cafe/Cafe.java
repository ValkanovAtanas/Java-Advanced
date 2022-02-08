package cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe (String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Cafe ").append(this.name).append(":").append(System.lineSeparator());
        for (Employee employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public int getCount () {
        return this.employees.size();
    }

    public Employee getEmployee(String name) {
        Employee employee = new Employee("", 0, "");
        for (Employee employee1 : employees) {
            if (employee1.getName().equals(name)) {
                employee = employee1;
            }
        }
        return employee;
    }

    public Employee getOldestEmployee() {
        Employee oldestEmployee = new Employee("", 0, "");
        int age = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getAge() > age) {
                age = employee.getAge();
                oldestEmployee = employee;
            }
        }
        return oldestEmployee;
    }

    public void addEmployee(Employee employee) {
        if (this.capacity > 0) {
            this.employees.add(employee);
            this.capacity--;
        }
    }

    public boolean removeEmployee (String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }
}

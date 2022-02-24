package exams.sixteenthofdecember.openning;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery ").append(this.name).append(":").append(System.lineSeparator());
        for (Employee employee : this.employees) {
            sb.append(employee).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public int getCount() {
        return this.employees.size();
    }

    public Employee getEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public Employee getOldestEmployee() {
        Employee oldestEmployee = null;
        int oldestEmployeeAge = Integer.MIN_VALUE;
        for (Employee employee : this.employees) {
            if (employee.getAge() > oldestEmployeeAge) {
                oldestEmployeeAge = employee.getAge();
                oldestEmployee = employee;
            }
        }
                return oldestEmployee;
    }

    public boolean remove(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                this.employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public void add(Employee employee) {
        if (capacity > 0) {
            this.employees.add(employee);
            this.capacity--;
        }
    }
}

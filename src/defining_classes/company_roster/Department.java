package defining_classes.company_roster;

import java.util.*;

public class Department {
    private Set<Employee> employeeSet;

    public Department(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }


    public String highestAverageSalaryDepartment() {
        Map<String, List<Double>> departmentSalariesMap = new HashMap<>();

        for (Employee employee : employeeSet) {
            List<Double> salariesList = new ArrayList<>();
            String currDepartment = employee.getDepartment();
            if (!departmentSalariesMap.containsKey(currDepartment)) {
                salariesList.add(employee.getSalary());
                departmentSalariesMap.put(currDepartment, salariesList);
            } else {
                salariesList = departmentSalariesMap.get(currDepartment);
                salariesList.add(employee.getSalary());
                departmentSalariesMap.put(currDepartment, salariesList);
            }
        }
        String highestSalaryDepartment = "";
        double highestSalary = Double.MIN_VALUE;
        for (Map.Entry<String, List<Double>> stringListEntry : departmentSalariesMap.entrySet()) {
            List<Double> currSalariesList = stringListEntry.getValue();
            double salariesSum = 0;
            for (Double aDouble : currSalariesList) {
                salariesSum += aDouble;
            }
            double averageSalary = salariesSum / currSalariesList.size();
            if (averageSalary >= highestSalary) {
                highestSalary = averageSalary;
                highestSalaryDepartment = stringListEntry.getKey();
            }
        }
        Map<String, Double> myMap = new HashMap<>();
        myMap.put(highestSalaryDepartment, highestSalary);
        return highestSalaryDepartment;
    }

}

package exams.sixteenthofdecember.openning;

public class Main {
    public static void main(String[] args) {
        Bakery bakery = new Bakery("Barny", 10);
        Employee employee = new Employee("Stephen", 40, "Bulgaria");
        System.out.println(employee);
        bakery.add(employee);
        System.out.println(bakery.remove("Employee name"));

        int test = 1;
        System.out.println();
    }
}

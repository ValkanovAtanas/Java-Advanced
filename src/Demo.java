import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String liquidsToPrint = "1, 2, 3, 4, 5, ";

        liquidsToPrint = liquidsToPrint.substring(0, liquidsToPrint.length() - 2);
        System.out.println(liquidsToPrint);
    }
}
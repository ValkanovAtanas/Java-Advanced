import java.util.Scanner;

public class SrybskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] inputSplitByAtSign = input.split(" @");
            String singer = inputSplitByAtSign[0];

            input = scanner.nextLine();
        }
    }
}

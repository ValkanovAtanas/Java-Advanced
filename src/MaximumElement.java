import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCommands = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numOfCommands; i++) {
            String input[] = scanner.nextLine().split("\\s++");

            switch (input[0]) {
                case "1":
                    int number = Integer.parseInt(input[1]);
                    stack.push(number);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    int maxNum = Integer.MIN_VALUE;
                    for (Integer integer : stack) {
                        if (integer > maxNum) {
                            maxNum = integer;
                        }
                    }
                    System.out.println(maxNum);
                    break;
            }
        }
    }
}

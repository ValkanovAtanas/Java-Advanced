package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfLines = Integer.parseInt(scanner.nextLine());
        String myText;
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < numOfLines; i++) {
            String[] inputArray = scanner.nextLine().split("\\s++");
            if (!stack.isEmpty()) {
                myText = stack.peek();
            } else {
                myText = "";
            }
            String command = inputArray[0];
            switch (command) {
                case "1":
                    myText += inputArray[1];
                    stack.push(myText);
                    break;
                case "2":
                    myText = myText.substring(0, myText.length() - Integer.parseInt(inputArray[1]));
                    stack.push(myText);
                    break;
                case "3":
                    int index = Integer.parseInt(inputArray[1]) - 1;
                    System.out.println(myText.charAt(index));
                    break;
                case "4":
                    stack.pop();
                    break;

            }

        }
    }
}

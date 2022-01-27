package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
        char[] charArray = sequence.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int charArrayLength = charArray.length;

        for (int i = 0; i < charArrayLength; i++) {
            char currentChar = charArray[i];
            char lastElement = '?';
            if (!stack.isEmpty()) {
                lastElement = stack.peek();
            }
            stack.push(currentChar);
            if (lastElement == '{' && currentChar == '}') {
                stack.pop();
                stack.pop();
            } else if (lastElement == '[' && currentChar == ']') {
                stack.pop();
                stack.pop();
            } else if (lastElement == '(' && currentChar == ')') {
                stack.pop();
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


        System.out.println();
    }
}

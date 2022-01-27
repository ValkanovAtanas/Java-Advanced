package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s++");

        Deque<Integer> numbersToBeReversed = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            numbersToBeReversed.push(Integer.parseInt(input[i]));
        }
        for (Integer currNum : numbersToBeReversed) {
            System.out.print(currNum + " ");
        }
    }
}
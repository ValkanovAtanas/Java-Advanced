package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> firstBoxQueue = new ArrayDeque<>();
        Deque<Integer> secondBoxStack = new ArrayDeque<>();
        int[] firstLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        int[] firstLine = new int[] {10, 11, 8, 13, 5, 6};
//        int[] secondLine = new int[] {0, 4, 7, 3, 6, 23, 3};

        Arrays.stream(firstLine).forEach(element -> firstBoxQueue.offer(element));
        Arrays.stream(secondLine).forEach(element -> secondBoxStack.push(element));

        int sumOfClaimedItems = 0;

        while (true) {
            if (firstBoxQueue.isEmpty()) {
                System.out.println("First magic box is empty.");
                break;
            }
            if (secondBoxStack.isEmpty()) {
                System.out.println("Second magic box is empty.");
                break;
            }

            if ((firstBoxQueue.peek() + secondBoxStack.peek()) % 2 == 0) {
                int sumOfTwoBoxes = firstBoxQueue.poll() + secondBoxStack.pop();
                sumOfClaimedItems += sumOfTwoBoxes;
            } else {
                firstBoxQueue.offer(secondBoxStack.pop());
            }

        }
        if (sumOfClaimedItems > 89) {
            System.out.println("Wow, your prey was epic! Value: " + sumOfClaimedItems);
        } else {
            System.out.println("Poor prey... Value: " + sumOfClaimedItems);
        }

        System.out.println();
    }
}
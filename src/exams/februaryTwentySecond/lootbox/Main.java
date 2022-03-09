package exams.februaryTwentySecond.lootbox;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        int[] firstLine = new int[] {10, 11, 8, 13, 5, 6};
//        int[] secondLine = new int[] {0, 4, 7, 3, 6, 23, 3};
        Deque<Integer> lootQueue = new ArrayDeque<>();
        Deque<Integer> lootStack = new ArrayDeque<>();
        Arrays.stream(firstLine).forEach(element -> lootQueue.offer(element));
        Arrays.stream(secondLine).forEach(element -> lootStack.push(element));
        int claimedItems = 0;

        while (areBothLootsFull(lootQueue, lootStack)) {
            int sum = lootQueue.peek() + lootStack.peek();
            if (sum % 2 == 0) {
                lootQueue.poll();
                lootStack.pop();
                claimedItems += sum;
            } else {
                lootQueue.offer(lootStack.pop());
            }
        }

        if (lootQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (lootStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (claimedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d", claimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d", claimedItems);
        }


        System.out.println();
    }

    private static boolean areBothLootsFull(Deque<Integer> lootQueue, Deque<Integer> lootStack) {
        if (lootQueue.isEmpty()) {
            return false;
        }
        if (lootStack.isEmpty()){
            return false;
        }
        return true;
    }
}

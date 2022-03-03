package exams.nineteenthofaugust;

import java.util.*;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scanner.nextLine().split(",\\s*")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split(",\\s*")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> rosesQueue = new ArrayDeque<>();
        Deque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(firstLine).forEach(element -> liliesStack.push(element));
        Arrays.stream(secondLine).forEach(element -> rosesQueue.offer(element));
        int wreathsCount = 0;
        int sumForStoring = 0;

        while (isThereElementsInBothDeques(liliesStack, rosesQueue)) {
            int sum = liliesStack.peek() + rosesQueue.peek();
            if (sum == 15) {
                liliesStack.pop();
                rosesQueue.poll();
                wreathsCount++;
            } else if (sum > 15) {
                int newLilieValue = liliesStack.pop() - 2;
                liliesStack.push(newLilieValue);
            } else {
                sumForStoring += liliesStack.pop() + rosesQueue.poll();
            }
        }
        wreathsCount += sumForStoring / 15;
        if (wreathsCount >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathsCount);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreathsCount);
        }
    }

    public static boolean isMakingWreath(Deque<Integer> liliesStack, Deque<Integer> rosesQueue) {
        if (liliesStack.peek() + rosesQueue.peek() == 15) {

        }
        return false;
    }
    public static boolean isThereElementsInBothDeques(Deque<Integer> liliesStack, Deque<Integer> rosesQueue) {
        if (liliesStack.isEmpty()) {
            return false;
        } else {
            if (rosesQueue.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}

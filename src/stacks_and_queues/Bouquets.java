package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> daffodilsQueue = new ArrayDeque<>();
        Deque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).forEach(element -> daffodilsQueue.offer(Integer.parseInt(element)));
        Arrays.stream(scanner.nextLine().split(", ")).forEach(element -> tulipsStack.push(Integer.parseInt(element)));

        int bouquetsCount = 0;
        int flowersLeft = 0;

        while (true) {
            if (daffodilsQueue.isEmpty()) {
                break;
            }
            if (tulipsStack.isEmpty()) {
                break;
            }
            if (daffodilsQueue.peek() + tulipsStack.peek() == 15) {
                daffodilsQueue.poll();
                tulipsStack.pop();
                bouquetsCount++;
                continue;
            } else if (daffodilsQueue.peek() + tulipsStack.peek() > 15) {
                int newTulipsValue = tulipsStack.pop() - 2;
                tulipsStack.push(newTulipsValue);
                continue;
            } else {
                flowersLeft += daffodilsQueue.poll() + tulipsStack.pop();
            }

        }

        bouquetsCount += flowersLeft / 15;
        if (bouquetsCount >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquetsCount);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquetsCount);
        }

    }
}

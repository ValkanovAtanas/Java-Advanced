package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class OsPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> tasksStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(tasksStack::push);

        Deque<Integer> threadsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(threadsQueue::offer);

        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (true) {
            if(threadsQueue.peek() >= tasksStack.peek()) {
                tasksStack.pop();
                threadsQueue.poll();
            } else {
                threadsQueue.poll();
            }

            if (tasksStack.peek() == taskToKill) {
                System.out.printf("Thread with value %d killed task %d%n", threadsQueue.peek(), tasksStack.peek());
                threadsQueue.stream().forEach(value -> {
                    System.out.print(value + " ");
                });
                break;
            }

        }
    }
}

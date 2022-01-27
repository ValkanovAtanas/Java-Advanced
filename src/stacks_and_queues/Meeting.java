package stacks_and_queues;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> malesList = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> femalesList = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Deque<Integer> femalesQueue = new ArrayDeque<>();
        femalesQueue.addAll(femalesList);
        Deque<Integer> malesStack = new ArrayDeque<>();
        for (int i = 0; i < malesList.size(); i++) {
            malesStack.push(malesList.get(i));
        }
        int matchesCount = 0;

        while (!femalesQueue.isEmpty() || !malesStack.isEmpty()) {
            if (femalesQueue.peek() == malesStack.peek()) {
                femalesQueue.poll();
                malesStack.pop();
                matchesCount++;
                continue;

            } if (femalesQueue.peek() != malesStack.peek()){
                femalesQueue.poll();
                int newValue = malesStack.pop() - 2;
                malesStack.push(newValue);
                continue;
            }

            if (!femalesQueue.isEmpty() && femalesQueue.peek() == 0) {
                femalesQueue.poll();
                continue;
            }

            if (!femalesQueue.isEmpty() && femalesQueue.peek() % 25 == 0) {
                femalesQueue.poll();
                continue;
            }
            if (malesStack.peek() % 25 == 0) {
                malesStack.pop();
                continue;
            }
        }
        System.out.printf("Matches: %d%n", matchesCount);
        System.out.print("Males left: ");
        if (malesStack.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(malesStack.size());
        }
        System.out.print("Females left: ");
        if (femalesQueue.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(femalesQueue.size());
        }
    }
}

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] malesArray = Arrays.stream((scanner.nextLine().split("\\s+"))).mapToInt(Integer::parseInt).toArray();
        int[] femalesArray = Arrays.stream((scanner.nextLine().split("\\s+"))).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> malesQueue = new ArrayDeque<>();
        Deque<Integer> femalesStack = new ArrayDeque<>();

        for (int i : malesArray) {
            malesQueue.offer(i);
        }
        for (int i : femalesArray) {
            femalesStack.push(i);
        }

        int matchesCount = 0;

        while (!malesQueue.isEmpty() && !femalesStack.isEmpty()) {
            if (malesQueue.peek() == femalesStack.peek()) {
                malesQueue.poll();
                femalesStack.pop();
                matchesCount++;
                continue;
            } else {
                femalesStack.pop();
                int newMalesElement = malesQueue.poll() - 2;
                if (!malesQueue.isEmpty() && malesQueue.peek() <= 0) {
                    malesQueue.poll();
                    continue;
                }
                malesQueue.push(newMalesElement);
            }

            if (!malesQueue.isEmpty() && malesQueue.peek() <= 0) {
                malesQueue.poll();
            }
            if (!femalesStack.isEmpty() && femalesStack.peek() <= 0) {
                femalesStack.pop();
            }
            if (!malesQueue.isEmpty() && malesQueue.peek() % 25 == 0) {
                malesQueue.poll();
                malesQueue.poll();
            }
            if (!femalesStack.isEmpty() && femalesStack.peek() % 25 == 0) {
                femalesStack.pop();
                femalesStack.pop();
            }
        }
        System.out.printf("Matches: %d%n", matchesCount);
        System.out.print("Males left: ");
        if (malesQueue.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(malesQueue.size());
        }
        System.out.print("Females left: ");
        if (femalesStack.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(femalesStack.size());
        }
    }
}

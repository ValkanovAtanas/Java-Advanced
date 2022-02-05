import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArray = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
        int[] secondArray = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> maleStack = new ArrayDeque<>();
        Deque<Integer> femaleQueue = new ArrayDeque<>();
//        int[] firstArray = new int[]{3, 6, 9, 12};
//        int[] secondArray = new int[]{12, 9, 6, 1, 25, 25};
        for (Integer integer : firstArray) {
            maleStack.push(integer);
        }
        for (Integer integer : secondArray) {
            femaleQueue.offer(integer);
        }

        int matchesCounter = 0;

        while (true) {
            if (maleStack.isEmpty()) {
                break;
            } else if (femaleQueue.isEmpty()) {
                break;
            }
            if (femaleQueue.peek() == 0 || maleStack.peek() == 0) {
                if (femaleQueue.peek() == 0) {
                    femaleQueue.poll();
                }

                if (maleStack.peek() == 0) {
                    maleStack.pop();
                }
                continue;
            }

            if (femaleQueue.peek() % 25 == 0 || maleStack.peek() % 25 == 0) {
                if (femaleQueue.peek() % 25 == 0) {
                    femaleQueue.poll();
                    if (!femaleQueue.isEmpty()) {
                        femaleQueue.poll();
                    }
                }

                if (maleStack.peek() % 25 == 0) {
                    maleStack.pop();
                    if (!maleStack.isEmpty()) {
                        maleStack.pop();
                    }
                }
                continue;
            }

            if (femaleQueue.peek() == maleStack.peek()) {
                femaleQueue.poll();
                maleStack.pop();
                matchesCounter++;
            } else {
                femaleQueue.poll();
                int newMaleValue = maleStack.pop() - 2;
                if (newMaleValue > 0) {
                    maleStack.push(newMaleValue);
                }
            }
        }
        System.out.printf("Matches: %d%n", matchesCounter);
        System.out.print("Males left: ");
        if (maleStack.isEmpty()) {
            System.out.println("none");
        } else {
            String malesToPrint = "";
            for (Integer integer : maleStack) {
                String currElement = String.format("%d, ", integer);
                malesToPrint += currElement;
            }
            malesToPrint = malesToPrint.substring(0, malesToPrint.length() - 2);
            System.out.println(malesToPrint);
        }
        System.out.print("Females left: ");
        if (femaleQueue.isEmpty()) {
            System.out.println("none");
        } else {
            String femalesToPrint = "";
            for (Integer integer : femaleQueue) {
                String currElement = String.format("%d, ", integer);
                femalesToPrint += currElement;
            }
            femalesToPrint = femalesToPrint.substring(0, femalesToPrint.length() - 2);
            System.out.println(femalesToPrint);
        }
        System.out.println();

    }
}

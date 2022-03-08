package exams.februaryTwentySecond.lootbox;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int[] firstLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] firstLine = new int[] {10, 11, 8, 13, 5, 6};
        int[] secondLine = new int[] {0, 4, 7, 3, 6, 23, 3};
        Deque<Integer> lootQueue = new ArrayDeque<>();
        Deque<Integer> lootStack = new ArrayDeque<>();
        Arrays.stream(firstLine).forEach(element -> lootQueue.offer(element));
        Arrays.stream(secondLine).forEach(element -> lootStack.push(element));



        System.out.println();
    }
}

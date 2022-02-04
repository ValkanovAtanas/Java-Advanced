package retake_exam_august.pastry_shop;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int[] firstLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int [] firstLine = new int[] {1, 25, 50, 50};
        int [] secondLine = new int[] {50, 25, 25, 24};
        Deque<Integer> liquidsQueue = new ArrayDeque<>();
        Deque<Integer> ingredientsStack = new ArrayDeque<>();

        for (int i : firstLine) {
            liquidsQueue.offer(i);
        }
        for (int i : secondLine) {
            ingredientsStack.push(i);
        }

        Map<Integer, String> foodMap = new HashMap<>();
        foodMap.put(25, "Biscuit");
        foodMap.put(50, "Cake");
        foodMap.put(75, "Pastry");
        foodMap.put(100, "Pie");

        while (true) {
            if (liquidsQueue.isEmpty()) {
                break;
            } else if (ingredientsStack.isEmpty()) {
                break;
            }
            int result = liquidsQueue.peek() * ingredientsStack.peek();
            if (foodMap.containsKey(result)) {
                liquidsQueue.poll();
                ingredientsStack.pop();
            }
        }

        System.out.println();
    }
}

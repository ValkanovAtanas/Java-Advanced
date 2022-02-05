package retake_exam_august.pastry_shop;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        int [] firstLine = new int[] {1, 25, 50, 50};
//        int [] secondLine = new int[] {50, 25, 25, 24};
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
        foodMap.put(100, "Pie");
        foodMap.put(75, "Pastry");
        Map<String, Integer> cookedFoods = new TreeMap<>();

        while (true) {
            if (liquidsQueue.isEmpty()) {
                break;
            } else if (ingredientsStack.isEmpty()) {
                break;
            }
            int result = liquidsQueue.peek() + ingredientsStack.peek();
            if (foodMap.containsKey(result)) {
                liquidsQueue.poll();
                ingredientsStack.pop();

                if (cookedFoods.containsKey(foodMap.get(result))) {
                    int newCount = cookedFoods.get(foodMap.get(result)) + 1;
                    cookedFoods.put(foodMap.get(result), newCount);
                } else {
                    cookedFoods.put(foodMap.get(result), 1);
                }
            } else {
                liquidsQueue.poll();
                int newIngredientValue = ingredientsStack.pop() + 3;
                ingredientsStack.push(newIngredientValue);
            }
        }
        if (cookedFoods.size() == 4) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            String liquidsToPrint = "";
            for (Integer integer : liquidsQueue) {
                liquidsToPrint += integer + ", ";
            }
            liquidsToPrint = liquidsToPrint.substring(0, liquidsToPrint.length() - 2);
            System.out.println(liquidsToPrint.trim());
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            String ingredientsToPrint = "";
            for (Integer integer : ingredientsStack) {
                ingredientsToPrint += integer + ", ";
            }
            ingredientsToPrint = ingredientsToPrint.substring(0, ingredientsToPrint.length() - 2);
            System.out.println(ingredientsToPrint.trim());
        }
        System.out.print("Biscuit: ");
        if (cookedFoods.containsKey("Biscuit"))
            System.out.println(cookedFoods.get("Biscuit"));
         else
             System.out.println(0);

        System.out.print("Cake: ");
        if (cookedFoods.containsKey("Cake"))
            System.out.println(cookedFoods.get("Cake"));
        else
            System.out.println(0);

        System.out.print("Pie: ");
        if (cookedFoods.containsKey("Pie"))
            System.out.println(cookedFoods.get("Pie"));
        else
            System.out.println(0);

        System.out.print("Pastry: ");
        if (cookedFoods.containsKey("Pastry"))
            System.out.println(cookedFoods.get("Pastry"));
        else
            System.out.println(0);

    }
}
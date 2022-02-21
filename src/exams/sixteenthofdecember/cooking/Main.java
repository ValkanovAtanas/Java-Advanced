package exams.sixteenthofdecember.cooking;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        int[] firstLine = new int[] {1, 25, 50, 50};     //liquids
//        int[] secondLine = new int[] {50, 25, 25, 24};   //ingredients
        Deque<Integer> liquidsQueue = new ArrayDeque<>();
        Deque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(firstLine).forEach(element -> liquidsQueue.offer(element));
        Arrays.stream(secondLine).forEach(element -> ingredientsStack.push(element));
        Map<Integer, String> foodMenu = new HashMap<>();
        foodMenu.put(25, "Bread");
        foodMenu.put(50, "Cake");
        foodMenu.put(75, "Pastry");
        foodMenu.put(100, "Fruit Pie");
        Map<String, Integer> preparedFood = new TreeMap<>();
        preparedFood.put("Bread", 0);
        preparedFood.put("Cake", 0);
        preparedFood.put("Pastry", 0);
        preparedFood.put("Fruit Pie", 0);

        while (true) {
            if (liquidsQueue.isEmpty()) {
                break;
            }
            if (ingredientsStack.isEmpty()) {
                break;
            }
            int sum = liquidsQueue.peek() + ingredientsStack.peek();

            if (foodMenu.containsKey(sum)) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                if (preparedFood.containsKey(foodMenu.get(sum))) {
                    int newCount = preparedFood.get(foodMenu.get(sum)) + 1;
                    preparedFood.put(foodMenu.get(sum), newCount);
                } else {
                    preparedFood.put(foodMenu.get(sum), 1);
                }
            } else {
                liquidsQueue.poll();
                int ingredientNewValue = ingredientsStack.pop() + 3;
                ingredientsStack.push(ingredientNewValue);
            }


        }
        if (preparedFood.get("Bread") != 0
                && preparedFood.get("Pastry") != 0
                && preparedFood.get("Fruit Pie") != 0
                && preparedFood.get("Cake") != 0
        ) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            String liquidsToPrint = "";
            for (Integer integer : liquidsQueue) {
                liquidsToPrint += integer;
                liquidsToPrint += ", ";
            }
            liquidsToPrint = liquidsToPrint.substring(0, liquidsToPrint.length() - 2);
            System.out.println(liquidsToPrint);
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            String ingredientsToPrint = "";
            for (Integer integer : ingredientsStack) {
                ingredientsToPrint += integer;
                ingredientsToPrint += ", ";
            }
            ingredientsToPrint = ingredientsToPrint.substring(0, ingredientsToPrint.length() - 2);
            System.out.println(ingredientsToPrint);
        }
        preparedFood.entrySet().stream().forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

    }
}

package stacks_and_queues;

import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArray = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
        int[] secondArray = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> freshnessStack = new ArrayDeque<>();
        Deque<Integer> ingredientsQueue = new ArrayDeque<>();
//        int[] firstArray = new int[]{10, 10, 12, 8, 10, 12};
//        int[] secondArray = new int[]{25, 15, 50, 25, 25, 15};
        for (Integer integer : secondArray) {
            freshnessStack.push(integer);
        }
        for (Integer integer : firstArray) {
            ingredientsQueue.offer(integer);
        }
        Integer[] cocktailsArray =  {150, 250, 300, 400};
        List<Integer> cocktailsList = new ArrayList<Integer>(Arrays.asList(cocktailsArray));
        Map<String, Integer> cocktailsDone = new TreeMap<>();

        while (true) {
            if (freshnessStack.isEmpty() || ingredientsQueue.isEmpty()) {
                break;
            }

            if (ingredientsQueue.peek() == 0) {
                ingredientsQueue.poll();
                continue;
            }
            if (freshnessStack.peek() == 0) {
                freshnessStack.pop();
                continue;
            }

            int currentLevel = ingredientsQueue.peek() * freshnessStack.peek();
            if (cocktailsList.contains(currentLevel)) {
                ingredientsQueue.poll();
                freshnessStack.pop();
                String currCocktail = "";
                switch (currentLevel) {
                    case 150:
                        currCocktail = "Pear Sour";
                        break;
                    case 250:
                        currCocktail = "The Harvest";
                        break;
                    case 300:
                        currCocktail = "Apple Hinny";
                        break;
                    case 400:
                        currCocktail = "High Fashion";
                        break;
                }
                if (!cocktailsDone.containsKey(currCocktail)) {
                    cocktailsDone.put(currCocktail, 1);
                } else {
                    int newCocktailsCount = cocktailsDone.get(currCocktail) + 1;
                    cocktailsDone.put(currCocktail, newCocktailsCount);
                }
            } else {
                freshnessStack.pop();
                int newIngredientValue = ingredientsQueue.poll() + 5;
                ingredientsQueue.addLast(newIngredientValue);
            }

        }
        if (cocktailsDone.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredientsQueue.isEmpty()) {
            int sum = 0;
            for (Integer integer : ingredientsQueue) {
                sum += integer;
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }

        cocktailsDone.entrySet().stream().forEach(entry -> System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue()));
    }
}
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstSequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondSequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        int[] firstSequence = new int[] {10, 10, 12, 8, 10, 12};
//        int[] secondSequence = new int[] {25, 15, 50, 25, 25, 15};
        Deque<Integer> ingredientsQueue = new ArrayDeque<>();
        Deque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(firstSequence).forEach(element -> ingredientsQueue.offer(element));
        Arrays.stream(secondSequence).forEach(element -> freshnessStack.push(element));
        Map<Integer, String> cocktailsMenu = new HashMap<>();
        cocktailsMenu.put(150, "Pear Sour");
        cocktailsMenu.put(250, "The Harvest");
        cocktailsMenu.put(300, "Apple Hinny");
        cocktailsMenu.put(400, "High Fashion");
        Map<String, Integer> cocktailsMade = new TreeMap<>();

        while (true) {
            if (ingredientsQueue.isEmpty())
                break;
            if (freshnessStack.isEmpty())
                break;
            if (ingredientsQueue.peek() == 0)
                ingredientsQueue.poll();
            if(freshnessStack.peek() == 0)
                freshnessStack.pop();
            int multiplication = ingredientsQueue.peek() * freshnessStack.peek();
            if(cocktailsMenu.containsKey(multiplication)) {
                ingredientsQueue.poll();
                freshnessStack.pop();
                addCocktail (multiplication, cocktailsMade, cocktailsMenu);
            } else {
                freshnessStack.pop();
                int newIngredientsValue = ingredientsQueue.poll() + 5;
                ingredientsQueue.offer(newIngredientsValue);
            }
        }

        if (cocktailsMade.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredientsQueue.isEmpty()) {
            int sum = 0;
            for (Integer integer : ingredientsQueue) {
                sum += integer;
            }
            System.out.print("Ingredients left: ");
            System.out.println(sum);
        }
        if (!cocktailsMade.isEmpty())
        cocktailsMade.entrySet().forEach(entry -> System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue()));



    }

    private static void addCocktail(int multiplication, Map<String, Integer> cocktailsMade, Map<Integer, String> cocktailsMenu) {
        String cocktailName = cocktailsMenu.get(multiplication);
        if (cocktailsMade.containsKey(cocktailName)) {
            int newCount = cocktailsMade.get(cocktailName) + 1;
            cocktailsMade.put(cocktailName, newCount);
        } else
            cocktailsMade.put(cocktailName, 1);
    }
}
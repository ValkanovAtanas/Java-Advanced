package exams.seventeenthofdecember.santaspresentfactory;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstSequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondSequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        int[] firstSequence = new int[] {10, 10, 12, 8, 10, 12};
//        int[] secondSequence = new int[] {25, 15, 50, 25, 25, 15};
        Deque<Integer> materialsStack = new ArrayDeque<>();
        Deque<Integer> magicLevelQueue = new ArrayDeque<>();
        Arrays.stream(firstSequence).forEach(element -> materialsStack.push(element));
        Arrays.stream(secondSequence).forEach(element -> magicLevelQueue.offer(element));
        Map<Integer, String> cocktailsMenu = new HashMap<>();
        cocktailsMenu.put(150, "Doll");
        cocktailsMenu.put(250, "Wooden train");
        cocktailsMenu.put(300, "Teddy bear");
        cocktailsMenu.put(400, "Bicycle");
        Map<String, Integer> cocktailsMade = new TreeMap<>();

        while (true) {
            if (materialsStack.isEmpty())
                break;
            if (magicLevelQueue.isEmpty())
                break;
            if (materialsStack.peek() == 0 || magicLevelQueue.peek() == 0){
                if (materialsStack.peek() == 0 && magicLevelQueue.peek() == 0){
                    materialsStack.pop();
                    magicLevelQueue.poll();
                    continue;
                }
                if (materialsStack.peek() == 0){
                    materialsStack.pop();
                    continue;
                }
                if (magicLevelQueue.peek() == 0) {
                    magicLevelQueue.poll();
                    continue;
                }
            }

            int multiplication = materialsStack.peek() * magicLevelQueue.peek();
            if(cocktailsMenu.containsKey(multiplication)) {
                materialsStack.pop();
                magicLevelQueue.poll();
                addCocktail (multiplication, cocktailsMade, cocktailsMenu);
            } else if (multiplication < 0){
                int sum = materialsStack.pop() + magicLevelQueue.poll();
                materialsStack.push(sum);
            } else if (multiplication > 0) {
                magicLevelQueue.poll();
                int newMaterialValue = materialsStack.pop() + 15;
                materialsStack.push(newMaterialValue);
            }
        }
        if ((cocktailsMade.containsKey("Wooden train") && cocktailsMade.containsKey("Doll"))
                || ((cocktailsMade.containsKey("Bicycle") && cocktailsMade.containsKey("Teddy bear")))) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()) {
            System.out.print("Materials left: ");
            String materialsLeft = "";
            for (Integer integer : materialsStack) {
                materialsLeft += integer;
                materialsLeft+= ", ";
            }
            materialsLeft = materialsLeft.substring(0, materialsLeft.length() - 2);
            System.out.println(materialsLeft);
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

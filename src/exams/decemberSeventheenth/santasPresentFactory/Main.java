package exams.decemberSeventheenth.santasPresentFactory;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        int[] firstLine = new int[] {10, -5, 20, 15, -30, 10};
//        int[] secondLine = new int[] {40, 60, 10, 4, 10, 0};

        Deque<Integer> materialsStack = new ArrayDeque<>();
        Deque<Integer> magicLevelQueue = new ArrayDeque<>();
        Arrays.stream(firstLine).forEach(element -> materialsStack.push(element));
        Arrays.stream(secondLine).forEach(element -> magicLevelQueue.offer(element));

        Map<Integer, String> presentsList = new HashMap<>();
        presentsList.put(150, "Doll");
        presentsList.put(250, "Wooden train");
        presentsList.put(300, "Teddy bear");
        presentsList.put(400, "Bicycle");

        Map<String, Integer> craftedToys = new TreeMap<>();

        while (areBothBoxesFull(materialsStack, magicLevelQueue)) {
            if (materialsStack.peek() == 0 || magicLevelQueue.peek() == 0) {
                if (materialsStack.peek() == 0)
                    materialsStack.pop();
                if (magicLevelQueue.peek() == 0)
                    magicLevelQueue.poll();
                continue;
            }

            int multiplication = materialsStack.peek() * magicLevelQueue.peek();
            if (presentsList.containsKey(multiplication)) {
                materialsStack.pop();
                magicLevelQueue.poll();
                addToysToMap(multiplication, presentsList, craftedToys);
                continue;
            }

            if (multiplication < 0) {
                int sum = materialsStack.pop() + magicLevelQueue.poll();
                materialsStack.push(sum);
                continue;
            }

            magicLevelQueue.poll();
            int newMaterialValue = materialsStack.pop() + 15;
            materialsStack.push(newMaterialValue);
        }

        if ((craftedToys.containsKey("Doll") && craftedToys.containsKey("Wooden train")) || (craftedToys.containsKey("Teddy bear") && craftedToys.containsKey("Bicycle"))) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Materials left: ");
            for (Integer integer : materialsStack) {
                sb.append(integer).append(", ");
            }
            String stringToPrint = sb.toString();
            stringToPrint = stringToPrint.substring(0, stringToPrint.length() - 2);
            System.out.println(stringToPrint);
        }

        if (!magicLevelQueue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Magic left: ");
            for (Integer integer : magicLevelQueue) {
                sb.append(integer).append(", ");
            }
            String stringToPrint = sb.toString();
            stringToPrint = stringToPrint.substring(0, stringToPrint.length() - 2);
            System.out.println(stringToPrint);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : craftedToys.entrySet()) {
            System.out.printf("%s: %d%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
    }

    private static void addToysToMap(int multiplication, Map<Integer, String> presentsList, Map<String, Integer> craftedToys) {
        String toy = presentsList.get(multiplication);
        if (craftedToys.containsKey(toy)) {
            int newCount = craftedToys.get(toy) + 1;
            craftedToys.put(toy, newCount);
        } else {
            craftedToys.put(toy, 1);
        }
    }

    private static boolean areBothBoxesFull(Deque<Integer> materialsStack, Deque<Integer> magicLevelQueue) {
        if (materialsStack.isEmpty())
            return false;
        if (magicLevelQueue.isEmpty())
            return false;

        return true;
    }
}
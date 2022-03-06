import java.util.*;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int[] firstSequence = new int[]{5, 25, 50, 115};
//        int[] secondSequence = new int[]{5, 15, 25, 35};
        int[] firstSequence = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] secondSequence = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> bombEffectsQueue = new ArrayDeque<>();
        Deque<Integer> bombCasingsStack = new ArrayDeque<>();
        Arrays.stream(firstSequence).forEach(bombEffectsQueue::offer);
        Arrays.stream(secondSequence).forEach(bombCasingsStack::push);

        Map<Integer, String> bombTypes = new HashMap<>();
        bombTypes.put(40, "Datura Bombs");
        bombTypes.put(60, "Cherry Bombs");
        bombTypes.put(120, "Smoke Decoy Bombs");

        Map<String, Integer> bombsCreated = new TreeMap<>();
        bombsCreated.put("Datura Bombs", 0);
        bombsCreated.put("Cherry Bombs", 0);
        bombsCreated.put("Smoke Decoy Bombs", 0);

        while (areBothDequesFull(bombEffectsQueue, bombCasingsStack)) {
            if (isBombPouchedFilled(bombsCreated)) {
                break;
            }
            int sum = bombEffectsQueue.peek() + bombCasingsStack.peek();
            if (bombTypes.containsKey(sum)) {
                String bombName = bombTypes.get(sum);
                int newBombsCount = bombsCreated.get(bombName) + 1;
                bombsCreated.put(bombName, newBombsCount);
                bombEffectsQueue.poll();
                bombCasingsStack.pop();
            } else {
                int newBombCasingValue = bombCasingsStack.pop() - 5;
                bombCasingsStack.push(newBombCasingValue);
            }
        }
        if (bombsCreated.get("Datura Bombs") >= 3
                && bombsCreated.get("Cherry Bombs") >= 3
                && bombsCreated.get("Smoke Decoy Bombs") >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        System.out.print("Bomb Effects: ");
        if (bombEffectsQueue.isEmpty()) {
            System.out.println("empty");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : bombEffectsQueue) {
                sb.append(integer).append(", ");
            }
            System.out.println(sb.toString().substring(0, sb.length() - 2));
        }

        System.out.print("Bomb Casings: ");
        if (bombCasingsStack.isEmpty()) {
            System.out.println("empty");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : bombCasingsStack) {
                sb.append(integer).append(", ");
            }
            System.out.println(sb.toString().substring(0, sb.length() - 2));
        }

        for (Map.Entry<String, Integer> entry : bombsCreated.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }

    private static boolean isBombPouchedFilled(Map<String, Integer> bombsCreated) {
        for (Map.Entry<String, Integer> entry : bombsCreated.entrySet()) {
            if (entry.getValue() < 3) {
                return false;
            }
        }
        return true;
    }

    private static boolean areBothDequesFull(Deque<Integer> bombEffectsQueue, Deque<Integer> bombCasingsStack) {
        if (bombEffectsQueue.isEmpty()) {
            return false;
        }
        if (bombCasingsStack.isEmpty()) {
            return false;
        }
        return true;
    }
}

package defining_classes.aquarium;

import java.util.LinkedHashMap;
import java.util.Map;

public class Aquarium {
    private Map<String, Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new LinkedHashMap<>();
    }

    public String report () {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d%n", this.name, this.size));
        for (Map.Entry<String, Fish> entry : fishInPool.entrySet()) {
            sb.append(String.format("Fish: %s%nColor: %s%nNumber of fins: %d%n", entry.getValue().getName(), entry.getValue().getColor(), entry.getValue().getFins()));
        }
        return sb.toString();
    }

    public void report2() {
        System.out.println(String.format("Aquarium: %s ^ Size: %d", this.name, this.size));
        this.fishInPool.entrySet().stream().forEach(entry -> System.out.printf("Fish: %s%nColor: %s%nNumber of fins: %d%n", entry.getValue().getName(), entry.getValue().getColor(), entry.getValue().getFins()));
    }

    public String findFish(String name) {
        if (fishInPool.containsKey(name)) {
            return name;
        }
        return null;
    }

    public boolean remove(String name) {
        if (this.fishInPool.containsKey(name)) {
            this.fishInPool.remove(name);
            return true;
        }
        return false;
    }

    public void add(Fish fish) {
        if (this.size > 0 && !this.fishInPool.containsKey(fish.getName())) {
            this.fishInPool.put(fish.getName(), fish);
            this.capacity -= 1;
        }
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
}

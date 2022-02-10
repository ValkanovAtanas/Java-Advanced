package exams.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add (Pet pet) {
        if (this.capacity > 0) {
            this.data.add(pet);
            capacity--;
        }
    }

    public boolean remove(String name) {
        for (Pet currPet : data) {
            if (currPet.getName().equals(name))
                this.data.remove(currPet);
                return true;
        }
        return false;
    }

    public Pet getPet (String name, String owner) {
        for (Pet currPet : data) {
            if (currPet.getName().equals(name) && currPet.getOwner().equals(owner)) {
                return currPet;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:").append(System.lineSeparator());
        this.data.stream().forEach(currPet -> sb.append(currPet.getName()).append(" ").append(currPet.getOwner()).append(System.lineSeparator()));
        return sb.toString();
    }
}

package exams.nineteenthofaugust.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public int getCount() {
        return this.data.size();
    }

    public Pet getOldestPet() {
        Pet oldestPet = null;
        int oldestPetAge = Integer.MIN_VALUE;
        for (Pet pet : data) {
            if (pet.getAge() > oldestPetAge) {
                oldestPet = pet;
                oldestPetAge = pet.getAge();
            }
        }
        return oldestPet;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public void add(Pet pet) {
        if (this.capacity > 0) {
            data.add(pet);
            this.capacity--;
        }
    }
}
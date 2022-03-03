package exams.nineteenthoffebruary.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<Parrot>();
    }

    public void add(Parrot parrot) {
        if (this.capacity > 0) {
            this.data.add(parrot);
            this.capacity--;
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : this.data) {
            String currentParrotName = parrot.getName();
            if (currentParrotName.equals(name)) {
                this.data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot (String name) {
        for (Parrot parrot : this.data) {
            String currentParrotName = parrot.getName();
            if (currentParrotName.equals(name)) {
                parrot.setAvailable();
                return parrot;
            }
        }
        return null;
    }

    public List<Parrot>	sellParrotBySpecies(String species) {
        List<Parrot> parrotList = new ArrayList<Parrot>();
        for (Parrot parrot : this.data) {
            if (parrot.getSpecies().equals(species)) {
                parrotList.add(parrot);
            }
        }
        return parrotList;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(this.name).append(":").append(System.lineSeparator());
        for (Parrot parrot : this.data) {
            sb.append(parrot).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    public String getName() {return this.name;}
    public int getCapacity() { return this.capacity;}

}

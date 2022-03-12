package exams.decemberSeventheenth.christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag (String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public int count () {
        return this.data.size();
    }

    public void add (Present present) {
        if (this.capacity > 0) {
            this.data.add(present);
            this.capacity--;
        }
    }

    public boolean remove (String name) {
        for (Present datum : this.data) {
            if (datum.getName().equals(name)) {
                this.data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent () {
        double heaviestPresentWeight = Double.MIN_VALUE;
        Present present = null;
        for (Present datum : this.data) {
            if (datum.getWeight() > heaviestPresentWeight) {
                heaviestPresentWeight = datum.getWeight();
                present = datum;
            }
        }
        return present;
    }

    public Present getPresent (String name) {
        for (Present datum : this.data) {
            if (datum.getName().equals(name)) {
                return datum;
            }
        }
        return null;
    }

    public String report () {
        StringBuilder sb = new StringBuilder();
        sb.append(this.color).append(" bag contains:").append(System.lineSeparator());
        for (Present datum : this.data) {
            sb.append(datum).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }
}
package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.capacity > 0) {
            this.roster.add(person);
            this.capacity--;
        }
    }

    public boolean remove(String name) {
        for (Person person : this.roster) {
            if (person.getName().equals(name)) {
                this.roster.remove(person);
                this.capacity++;
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        Person person = null;
        for (Person currPerson : this.roster) {
            if (currPerson.getName().equals(name) && currPerson.getHometown().equals(hometown)) {
                person = currPerson;
            }
        }
        return person;
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The people in the hotel ").append(this.name).append(" are").append(":").append(System.lineSeparator());
        for (Person person : roster) {
            sb.append(person).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
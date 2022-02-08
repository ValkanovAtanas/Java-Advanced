package defining_classes.hotel;

import java.util.LinkedHashMap;
import java.util.Map;

public class Hotel {
    private String name;
    private int capacity;
    private int count = 0;
    private Map<String, Person> personMap;

    public Hotel (String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.personMap = new LinkedHashMap<>();
    }

    public boolean remove (String name) {
        if (this.personMap.containsKey(name)) {
            this.personMap.remove(name);
            return true;
        }
        return false;
    }


    public Person getPerson (String name, String hometown) {
        if (this.personMap.containsKey(name)) {
            if (this.personMap.get(name).getHometown().equals(hometown))
            return this.personMap.get(name);
        }
        return null;
    }

    public int getCount() {
        return count;
    }

    public Map<String, Person> getPersonMap() {
        return personMap;
    }

    public void add (Person person) {
        if (this.capacity > 0) {
            this.personMap.put(person.getName(), person);
            this.capacity--;
            this.count++;
        }
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel Hilton are:%n"));
        this.personMap.entrySet().stream().forEach(entry -> {
            String stringToAppend = entry.getValue().toString();
            sb.append(stringToAppend).append("\n");

        });
        return sb.toString();
    }
}

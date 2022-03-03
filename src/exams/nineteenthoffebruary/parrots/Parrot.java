package exams.nineteenthoffebruary.parrots;

public class Parrot {
    private String name;
    private String species;
    private boolean available;

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
    }

    @Override
    public String toString() {
        return String.format("Parrot (%s): %s", this.species, this.name);
    }

    public String getName() { return this.name;}
    public String getSpecies() { return this.species;}
    public boolean isAvailable() {return this.available;}
    public boolean setAvailable() {return false;}


}

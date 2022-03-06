package defining_classes.hotel;

public class Person {
    private String name;
    private int id;
    private int age;
    private String hometown = "n/a";



    public Person (String name, int id, int age, String hometown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = hometown;
    }


    public int getAge() {
        return this.age;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getHometown() {
        return this.hometown;
    }

    public String toString() {
        return String.format("Person %s: %d, Age: %d, Hometown: %s", this.name, this.id, this.age, this.hometown);
    }
}

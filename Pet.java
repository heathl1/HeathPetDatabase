public class Pet {
    // instance variables for each pet
    private String name;
    private int age;
    private int id;
    // static variable to count how many objects have been created
    public static int count = 0;

    // no parameter constructor
    public Pet() {
        this.id = this.count++;
    }
    // constructor with parameters
    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = count++;
    }

    @Override
    public String toString() { // override default toString() method
        return String.format("|%3d | %-10s |%4d |", this.id, this.name, this.age);
    }
}

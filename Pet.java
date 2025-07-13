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
    // used to retrieve the id in non-private context
    public int getId() {
        return this.id;
    }
    // retrive pet name in non-private context
    public String getName() {
        return this.name;
    }
    // retrieve pet age in non-private context
    public int getAge() {
        return this.age;
    }
    // update pet info
    public void updatePet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() { // override default toString() method
        return String.format("|%3d | %-10s |%4d |", this.id, this.name, this.age);
    }
}

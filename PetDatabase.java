import java.util.ArrayList;

public class PetDatabase {
    protected ArrayList<Pet> petDatabase = new ArrayList<>(); // Arraylist object to hold the pet info

    public PetDatabase() {
        // no parameter constructor
    }
    public void menu() {
        // option menu - to be updated
        System.out.println("What would you like to do?");
        System.out.println("1) View all pets");
        System.out.println("2) Add new pets");
        System.out.println("3) Remove a pet");
        System.out.println("4) Exit the program");

    }
    public void addPet(Pet pet) {
        // add pet to the database
        if (petDatabase.size() < 5) {
            petDatabase.add(pet);
        }
        else {
            System.out.println("Error: Database is full");
        }
    }

    public Pet getPet(int id) {
        if ((id < petDatabase.size()) && (id >= 0)) {
            return petDatabase.get(id);
        }
        System.out.println("Pet not found");
        return null;
    }


    // print all the pets to the screen
    public void showPets() {
        System.out.println("+-----------------------+"); // line to seperate the table
        System.out.printf("|%3s | %-10s |%4s |\n", "ID", "NAME", "AGE"); // headers for the columns
        System.out.println("+-----------------------+"); // table separator
        for (Pet pet : this.petDatabase) {
            System.out.printf("|%3s %s\n", this.petDatabase.indexOf(pet), pet); // use toString defined in pet class
        }
        System.out.println("+-----------------------+"); // table separator
    }

    public void removePet(int id) {
        boolean found = false; // tracks whether the pet is found or not
        if ((petDatabase.size() > id) && (id >= 0)) {
            petDatabase.remove(id);
            found = true;
        }
        if (!found){ // prints if a pet is not found
            System.out.printf("Error: ID %d does not exist.\n", id);
        }
    }
/*
    public void searchByName(String name) {
        System.out.println("+-----------------------+"); // line to seperate the table
        System.out.printf("|%3s | %-10s |%4s |\n", "ID", "NAME", "AGE"); // headers for the columns
        System.out.println("+-----------------------+"); // table separator
        for (Pet pet : this.petDatabase) { //iterate through database
            if (name.equals(pet.getName())) {
                System.out.println(pet); // print pets with matching name
            }
        }
        System.out.println("+-----------------------+"); // table separator
    }

    public void searchByAge(int age) {
        System.out.println("+-----------------------+"); // line to seperate the table
        System.out.printf("|%3s | %-10s |%4s |\n", "ID", "NAME", "AGE"); // headers for the columns
        System.out.println("+-----------------------+"); // table separator
        for (Pet pet : this.petDatabase) { //iterate through database
            if (age == pet.getAge()) {
                System.out.printf("|%3s %s", this.petDatabase.indexOf(pet), pet); // print pets with matching age
            }
        }
        System.out.println("+-----------------------+"); // table separator
    }

 */

}
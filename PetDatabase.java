import java.util.ArrayList;

public class PetDatabase {
    protected ArrayList<Pet> petDatabase = new ArrayList<>(); // Arraylist object to hold the pet info

    public PetDatabase() {
        // no parameter constructor
    }
    public void menu() {
        // option menu - to be updated
        System.out.println("What would you like to do?");
        System.out.println("1) Show pets");
        System.out.println("2) Add new pets");
        System.out.println("3) Remove a pet");
        System.out.println("4) Exit the program");

    }
    public void addPet(Pet pet) {
        // add pet to the database
        petDatabase.add(pet);
    }

    public Pet getPet(int id) {
        for (Pet pet: petDatabase) {
            if (id == pet.getId()) {
                return pet;
            }
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
            System.out.println(pet); // use toString defined in pet class
        }
        System.out.println("+-----------------------+"); // table separator
    }

    public void removePet(int id) {
        boolean found = false; // tracks whether the pet is found or not
        for (Pet pet: petDatabase) { // iterate through the database
            if (pet.getId() == id) {
                int index = petDatabase.indexOf(pet);
                petDatabase.remove(index); // remove the pet with the matching id
                found = true;
                break;
            }
        }
        if (!found){ // prints if a pet is not found
            System.out.println("Pet not found");
        }
    }

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
                System.out.println(pet); // print pets with matching age
            }
        }
        System.out.println("+-----------------------+"); // table separator
    }



}
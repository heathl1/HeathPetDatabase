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
        System.out.println("2) Add more pets");
        System.out.println("3) Exit the program");

    }
    public void addPet(Pet pet) {
        // add pet to the database
        petDatabase.add(pet);
    }


    // print all the pets to the screen
    public void showPets() {
        System.out.println("+-----------------------+"); // line to seperate the table
        System.out.printf("|%3s | %-10s |%4s |\n", "ID", "NAME", "AGE"); // headers for the columns
        System.out.println("+-----------------------+"); // table separator
        for (Pet pet : petDatabase) {
            System.out.println(pet); // use toString defined in pet class
        }
        System.out.println("+-----------------------+"); // table separator
    }



}

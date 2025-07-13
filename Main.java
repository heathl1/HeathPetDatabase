import java.util.ArrayList;
import java.util.Scanner;
/* references
https://www.w3schools.com/java/java_switch.asp
 */

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // scanner to take in user input
        PetDatabase petDatabase = new PetDatabase(); // pet database to hold the

        int choice; // variable to hold the user choice
        System.out.println("Pet Database Program.");

        do {
            petDatabase.menu(); // print menu
            System.out.print("Your choice: ");
            choice = input.nextInt(); // take in user input
            input.nextLine(); // clear the buffer
            switch (choice) { // execute correspinding choice
                case 1:
                    petDatabase.showPets();
                    break;
                case 2:  // add new pets
                    String pet = ""; // initialize pet string variable
                    while (!pet.equalsIgnoreCase("done")) { // continue adding pets until user types done
                        System.out.print("add pet (name, age) or type done: ");
                        pet = input.nextLine();
                        if (pet.equalsIgnoreCase("done")) { // if done, break
                            break;
                        }
                        // otherwise split the string into an array
                        String[] petData = pet.split(" "); // use the data to create new pet objects
                        petDatabase.addPet(new Pet(petData[0], Integer.parseInt(petData[1])));
                    }
                    break;
                case 3: // exit the program
                    break;
                default:
                    System.out.println("Invalid choice. Please Try again"); // executes when the number is not a choice
            }
        } while (choice != 3);

        // print database objects to ensure they are properly loaded
        /*
        for (Pet pet: petDatabase.petDatabase) {
            System.out.println(pet);
        }
         */
    }
}
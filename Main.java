import java.util.Scanner;
/*
Assignment: Session 1 - pet database assignment
Author: Layla Heath

references:
https://www.w3schools.com/java/java_switch.asp
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Layla Heath - heathl1@csp.edu");
        System.out.println("I certify that this program is all my own work");
        System.out.println("Pet Database Program.");

        Scanner input = new Scanner(System.in); // scanner to take in user input
        PetDatabase petDatabase = new PetDatabase(); // pet database to hold the
        int choice; // variable to hold the user choice

        do {
            petDatabase.menu(); // print menu
            System.out.print("Your choice: ");
            choice = input.nextInt(); // take in user input
            input.nextLine(); // clear the buffer
            switch (choice) { // execute correspinding choice
                case 1: // show pets added to the choice
                    petDatabase.showPets();
                    break;
                case 2:  // add new pets
                    String pet = ""; // initialize pet string variable
                    while (!pet.equals("done")) { // continue adding pets until user types done
                        System.out.print("add pet (name, age): ");
                        pet = input.nextLine();
                        if (pet.equals("done")) { // if done, break
                            break;
                        }
                        // otherwise split the string into an array
                        String[] petData = pet.split(" "); // use the data to create new pet objects
                        petDatabase.addPet(new Pet(petData[0], Integer.parseInt(petData[1])));
                    }
                    break;
                case 3: // update existing pet;
                    petDatabase.showPets(); // display pets so user can see ids
                    System.out.print("Enter the ID of the pet you'd like to update: ");
                    int id = input.nextInt();
                    input.nextLine();
                    Pet petToUpdate = petDatabase.getPet(id);
                    if (petToUpdate != null) {
                        System.out.print("update pet (name, age): ");
                        String update = input.nextLine();
                        String[] updatedInfo = update.split(" ");
                        petToUpdate.updatePet(updatedInfo[0], Integer.parseInt(updatedInfo[1]));
                        System.out.println(petToUpdate);
                    }
                    break;
                case 4:
                    petDatabase.showPets();
                    System.out.print("Select the ID of the pet you'd like to remove: ");
                    int removeId = input.nextInt(); // get id to remove
                    petDatabase.removePet(removeId); // call removePet method
                    break;
                case 5: // search by name
                    System.out.print("Enter the name you would like to search: ");
                    String name = input.next(); // take in user input for name
                    petDatabase.searchByName(name);
                    break;
                case 6: // search by age
                    System.out.print("Enter the age you would like to search: ");
                    int age = input.nextInt(); // take in user input for age
                    petDatabase.searchByAge(age);
                    break;
                case 7: // exit the program
                    break;

                default:
                    System.out.println("Invalid choice. Please Try again"); // executes when the number is not a choice
            }
        } while (choice != 7);

    }
}
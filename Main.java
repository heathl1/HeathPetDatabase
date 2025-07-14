import java.util.Scanner;
import java.io.File;
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

        try {
            File petFile = new File("pets.txt");
            Scanner fileReader = new Scanner(petFile);
            String line;
            String[] lineData;
            while (fileReader.hasNextLine()) {
                line = fileReader.nextLine();
                try {
                    lineData = line.split(",");
                    if (lineData.length != 2) {
                        throw new Exception();
                    } else {
                        Pet newPet = new Pet(lineData[0], Integer.parseInt(lineData[1]));
                        petDatabase.addPet(newPet);
                    }
                }
                catch (Exception e) {
                    System.out.printf("Error : '%s' is not a valid input\n", line);
                }

            }
        } catch (Exception e) {
            System.out.println("Error loading file");
        }


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
                case 3: // Remove an existing pet by ID
                    petDatabase.showPets();
                    System.out.print("Select the ID of the pet you'd like to remove: ");
                    int removeId = input.nextInt(); // get id to remove
                    petDatabase.removePet(removeId); // call removePet method
                    break;
                case 4: // exit the program
                    break;

                default:
                    System.out.println("Invalid choice. Please Try again"); // executes when the number is not a choice
            }
        } while (choice != 4);

    }
}
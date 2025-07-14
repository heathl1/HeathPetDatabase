import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
/*
Assignment: Session 1 - pet database assignment
Author: Layla Heath

references:
https://www.w3schools.com/java/java_switch.asp
https://www.geeksforgeeks.org/java/throw-throws-java/
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Layla Heath - heathl1@csp.edu");
        System.out.println("I certify that this program is all my own work");
        System.out.println("Pet Database Program Version 2.");


        Scanner input = new Scanner(System.in); // scanner to take in user input
        PetDatabase petDatabase = new PetDatabase(); // pet database to hold the

        // try loading the file data
        try {
            File petFile = new File("pets.txt"); // file with info
            Scanner fileReader = new Scanner(petFile);
            String line;
            String[] lineData;
            while (fileReader.hasNextLine()) { // iterate through until there is no next line
                line = fileReader.nextLine();
                try {
                    lineData = line.split(","); // split the line using comma as delimiter
                    if (lineData.length != 2) {  // if there is too much or too little data, throw exception
                        throw new Exception();
                    } else {
                        Pet newPet = new Pet(lineData[0], Integer.parseInt(lineData[1])); // create pet object
                        petDatabase.addPet(newPet); // add the new pet to the database
                    }
                }
                catch (Exception e) {
                    System.out.printf("Error : '%s' is not a valid input\n", line); // handles invalid input
                }

            }
        } catch (Exception e) {
            System.out.println("Error loading file"); // handles errors with the file
        }

        int choice = -1; // initialize user choice

        do {
            petDatabase.menu(); // print menu
            System.out.print("Your choice: ");
            try {
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
                        try {
                            String[] petData = pet.split(" "); // use the data to create new pet objects
                            if (petData.length != 2) { // throw exception if there is too much or too little information
                                throw new Exception();
                            }
                            petDatabase.addPet(new Pet(petData[0], Integer.parseInt(petData[1]))); // create/add new pet
                        } catch (Exception e) {
                            System.out.printf("Error: '%s' is not a valid input\n", pet); // print error message
                        }
                    }
                    break;
                case 3: // Remove an existing pet by ID
                    petDatabase.showPets();
                    System.out.print("Select the ID of the pet you'd like to remove: ");
                    try {
                        int removeId = input.nextInt(); // get id to remove
                        petDatabase.removePet(removeId); // call removePet method
                    } catch (InputMismatchException e) {
                        System.out.println("Error: invalid input");
                    }

                    break;
                case 4: // exit the program
                    break;

                default:
                    System.out.println("Invalid choice. Please Try again"); // executes when the number is not a choice
            }
            } catch (InputMismatchException err) {
                System.out.println("Error: invalid input type. Expected integer type");
                input.nextLine();
            }
        } while (choice != 4);
        input.close(); // close the scanner for security
    }
}
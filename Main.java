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
                        System.out.print("add pet (name, age) or type 'done': ");
                        pet = input.nextLine();
                        if (pet.equalsIgnoreCase("done")) { // if done, break
                            break;
                        }
                        // otherwise split the string into an array
                        String[] petData = pet.split(" "); // use the data to create new pet objects
                        petDatabase.addPet(new Pet(petData[0], Integer.parseInt(petData[1])));
                    }
                    break;
                case 3:
                    System.out.print("Enter the name you'd like to search: ");
                    String name = input.next();
                    petDatabase.searchByName(name);
                    break;
                case 4:
                    System.out.print("Enter the age you'd like to search: ");
                    int age = input.nextInt();
                    petDatabase.searchByAge(age);
                case 5: // exit the program
                    break;
                default:
                    System.out.println("Invalid choice. Please Try again"); // executes when the number is not a choice
            }
        } while (choice != 5);
    }
}
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by win808mac on 8/19/16.
 */

/** his class' responsibility is displaying menus, prompting the user for input, and returning the results.*/

public class MenuService {

    public static final int LIST_ANIMAL = 1;
    public static final int CREATE_ANIMAL = 2;
    public static final int VIEW_DETAILS = 3;
    public static final int EDIT_ANIMAL = 4;
    public static final int DELETE_ANIMAL = 5;
    public static final int QUIT = 6;


    public static int promptForMainMenuSelection() {
        System.out.println("\n-- Main Menu --\n" +
                "\n" +
                "1) List animals\n" +
                "2) Create an animal\n" +
                "3) View animal details\n" +
                "4) Edit an animal\n" +
                "5) Delete an animal\n" +
                "6) Quit\n");

        return waitForInt("Please choose an option :");
    }

    public static int waitForInt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);

        String input = scanner.nextLine();

        int value;
        try {
            value = Integer.parseInt(input);

        } catch (Exception e) {
            System.out.println("\nPlease provide a number.\n");

            value = waitForInt(message);
        }
        if (value <= 0 || value > 6) {
            System.out.println("\nError: Sorry, that isn't a valid option.");
            System.out.println("Please choose options 1-6");
        }

        return value;

    }

    public void displayAnimalsList(AnimalsService service) {
        ArrayList<Animal> animals = service.listAnimals();

        if ((animals.size()) == (0)) {
            System.out.println("Nothing like an animal yet. Try again!!");
        } else {
            System.out.println("--List of Animals--");

            for (Animal anAnimal : animals) {
                String name = anAnimal.getName();
                String species = anAnimal.getSpecies();
                System.out.printf("%s \t %s\n", name, species);

            }

        }


    }

    public void createAnimal(AnimalsService service) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Animal> animals = service.listAnimals();
        String name, species, breed, description;

        System.out.println("--Create an Animal--");
        System.out.println("\n Please fill in the blanks.");

        System.out.println("\n Animal name: ");
        name = scanner.nextLine();

        System.out.println("Species: ");
        species = scanner.nextLine();

        System.out.println("Breed(optional): ");
        breed = scanner.nextLine();

        System.out.println("Description: ");
        description = scanner.nextLine();

        service.createAnimal(name, species, breed, description);


    }

    public void viewDetails(AnimalsService service) {
        System.out.println("--View Details--\n");
        int option = waitForInt("What is the numeric value of the animal you'd like to view") - 1;
        ArrayList<Animal> animals = service.listAnimals();
        if ((option <= animals.size() - 1) && option >= 0) {

            System.out.println("\n Name: " + animals.get(option).getName());
            System.out.println("Species: " + animals.get(option).getSpecies());
            System.out.println("Breed: " + animals.get(option).getBreed());
            System.out.println("Description: " + animals.get(option).getDescription());
        }
    }

    public void editAnimal(AnimalsService service) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--Edit Animal--\n");
        int option = waitForInt("What is the numeric value of the animal you'd like to edit") - 1;
        ArrayList<Animal> animals = service.listAnimals();
        if ((option <= animals.size() - 1) && option >= 0) {

            System.out.println("\n Name: " + animals.get(option).getName());
            animals.get(option).setName(scanner.nextLine());
            System.out.println("Species: " + animals.get(option).getSpecies());
            animals.get(option).setName(scanner.nextLine());
            System.out.println("Breed: " + animals.get(option).getBreed());
            animals.get(option).setName(scanner.nextLine());
            System.out.println("Description: " + animals.get(option).getDescription());
            animals.get(option).setName(scanner.nextLine());
        }
    }

    public void deleteAnimal(AnimalsService service) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--Delete Animal--\n");
        int option = waitForInt("What is the numeric value of the animal you'd like to delete") - 1;
        ArrayList<Animal> animals = service.listAnimals();
        if ((option <= animals.size() - 1) && option >= 0) {

            System.out.println("\n Name: " + animals.get(option).getName());
            System.out.println("Species: " + animals.get(option).getSpecies());
            System.out.println("Breed: " + animals.get(option).getBreed());
            System.out.println("Description: " + animals.get(option).getDescription());
            System.out.println("Are you sure?");

            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.println(" Gone");
                service.deleteAnimal(service, option);
            } else if (scanner.nextLine().equalsIgnoreCase("no")) {
                deleteAnimal(service);
            }

        }
        else
        {
            System.out.println("Hey! You don't have enough animals in your list. Try again!");
            deleteAnimal(service);
        }
    }

    public boolean quit(AnimalsService service) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAre you sure you want to quit (yes or no)?");
        System.out.println("If you choose 'yes', all of your data will be lost!");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            System.out.println(" See ya");
            return false;
        } else if (input.equalsIgnoreCase("no")) {
            return true;
        }
        return true;

    }
}
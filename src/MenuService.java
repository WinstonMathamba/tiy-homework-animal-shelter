import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class' responsibility is displaying menus, prompting the user for input, and returning the results.
 */

public class MenuService {
    //variables that drive the menu selection on Main. Each value points to one of the methods below
    public static final int LIST_ANIMAL = 1;
    public static final int CREATE_ANIMAL = 2;
    public static final int VIEW_DETAILS = 3;
    public static final int EDIT_ANIMAL = 4;
    public static final int DELETE_ANIMAL = 5;
    public static final int QUIT = 6;

    //Menue prompt text that also points to the method that confirms an integer input and returns it.
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

        return value;

    }

    public void displayAnimalsList(AnimalsService service) {
        ArrayList<Animal> animals = service.listAnimals();

        if ((animals.size()) == (0)) {
            System.out.println("No animals exist yet. Try creating an animal first (menu opt 2)!");
        } else {
            System.out.println("\n--List of Animals--");
            int x = 1;
            for (Animal anAnimal : animals) {
                String name = anAnimal.getName();
                String species = anAnimal.getSpecies();
                System.out.printf("%s) %s \t %s\n", x, name, species);
                x++;

            }
        }
    }

    public void createAnimal(AnimalsService service) {
        Scanner scanner = new Scanner(System.in);
        String name, species, breed, description;

        System.out.println("\n--Create an Animal--");
        System.out.println("\n Please fill in the blanks.");

        System.out.println("\nAnimal name: ");
        name = scanner.nextLine().trim();
        while (name.isEmpty() || name.equals("")) {
            System.out.println("\nUh,Oh! Name field is required. Try Again!\n");
            System.out.println("\nAnimal name: ");
            name = scanner.nextLine().trim();
        }
        System.out.println("\nSpecies: ");
        species = scanner.nextLine().trim();
        while (species.isEmpty() || name.equals("")) {
            System.out.println("\nUh,Oh! Species field is required. Try Again!\n");
            System.out.println("Species: ");
            species = scanner.nextLine().trim();
        }
        System.out.println("\nBreed(optional): ");
        breed = scanner.nextLine();

        System.out.println("\nDescription: ");
        description = scanner.nextLine().trim();
        while (description.isEmpty() || name.equals("")) {
            System.out.println("\nUh,Oh! Description field is required. Try Again!\n");
            System.out.println("Description: ");
            description = scanner.nextLine().trim();
        }

        service.createAnimal(name, species, breed, description);

        System.out.printf("\nSuccess! you added %s to the list of animals.\n", name);
    }

    public void viewDetails(AnimalsService service) {
        System.out.println("--View Details--\n");
        int option = waitForInt("What is the numeric value of the animal you would like to view") - 1;
        ArrayList<Animal> animals = service.listAnimals();
        int endOfList = animals.size();
        if ((option <= animals.size() - 1) && option >= 0) {

            System.out.println("\nName: " + animals.get(option).getName());
            System.out.println("Species: " + animals.get(option).getSpecies());
            System.out.println("Breed: " + animals.get(option).getBreed());
            System.out.println("Description: " + animals.get(option).getDescription());
        } else if (option < 0 || option > endOfList) {
            System.out.println("Oh Uh! Choose an animal from 1 to " + endOfList + " on the Animal List.\n");
            viewDetails(service);
        }
    }

    public void editAnimal(AnimalsService service) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--Edit Animal--\n");
        int option = waitForInt("What is the numeric value of the animal you'd like to edit") - 1;
        ArrayList<Animal> animals = service.listAnimals();
        int endOfList = animals.size();

        if ((option <= animals.size() - 1) && option >= 0) {
            System.out.println("\nName: [" + animals.get(option).getName() + "]");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                animals.get(option).setName(name);
            }
            System.out.println("Species: [" + animals.get(option).getSpecies() + "]");
            String species = scanner.nextLine().trim();
            if (!species.isEmpty()) {
                animals.get(option).setSpecies(species);
            }
            System.out.println("Breed: [" + animals.get(option).getBreed() + "]");
            String breed = scanner.nextLine().trim();
            if (!breed.isEmpty()) {
                animals.get(option).setBreed(breed);
            }
            System.out.println("Description: [" + animals.get(option).getDescription() + "]");
            String description = scanner.nextLine().trim();
            if (!description.isEmpty()) {
                animals.get(option).setDescription(description);
            }
        } else if (option < 0 || option > endOfList) {
            System.out.println("Oh Uh! Choose an animal from 1 to " + endOfList + " on the animal list.\n");
            editAnimal(service);
        }
    }

    public void deleteAnimal(AnimalsService service) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--Delete Animal--\n");
        int option = waitForInt("What is the numeric value of the animal you'd like to delete") - 1;
        ArrayList<Animal> animals = service.listAnimals();
        int endOfList = animals.size();
        if ((option <= animals.size() - 1) && option >= 0) {

            System.out.println("\nName: " + animals.get(option).getName());
            System.out.println("Species: " + animals.get(option).getSpecies());
            System.out.println("Breed: " + animals.get(option).getBreed());
            System.out.println("Description: " + animals.get(option).getDescription());
            System.out.println("Are you sure you want to delete " + animals.get(option).getName() + "? Yes or No");

            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("Deleted");
                service.deleteAnimal(option);
            } else if (scanner.nextLine().equalsIgnoreCase("no")) {
                deleteAnimal(service);
            }

        } else if (option < 0 || option > endOfList) {
            System.out.println("That's not a valid animal on your list\n");
            System.out.println("Select from 1 to " + endOfList + " on the animal list.");
            deleteAnimal(service);
        }
    }

    public boolean quit(AnimalsService service) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAre you sure you want to quit (yes or no)?");
        System.out.println("If you choose 'yes', all of your data will be lost!");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            System.out.println("\nThank You. Goodbye!");
            return false;
        } else if (input.equalsIgnoreCase("no")) {
            return true;
        }
        return true;
    }
}
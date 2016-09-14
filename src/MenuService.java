import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * This class' responsibility is displaying menus, prompting the user for input, and returning the results.
 */

public class MenuService {
    //variables that drive the menu selection on Main. Each value points to one of the methods below
    public static final int ADD_ANIMAL = 1;
    public static final int MANAGE_ANIMAL = 2;
    public static final int MANAGE_ANIMAL_TYPE = 3;
    public static final int QUIT = 4;

    public static final int TYPE = 1;
    public static final int NAME = 2;
    public static final int ID = 3;
    public static final int All_ANIMALS = 4;

    public static final int ADD_TYPE = 1;
    public static final int DELETE_TYPE = 2;
    public static final int LIST_TYPE = 3;

    public static final int EDIT = 1;
    public static final int DELETE = 2;
    public static final int ADD_NOTE = 3;


    Scanner scanner = new Scanner(System.in);
    TypeService typeService;
    AnimalsService animalsService;
    AnimalTypeRepo animalTypeRepo;


    public MenuService() throws IOException, SQLException {
    }

    public MenuService(AnimalsService as, TypeService ts) {
        this.typeService = ts;
        this.animalsService = as;


    }

    //Menue prompt text that also points to the method that confirms an integer input and returns it.
    public static int promptForMainMenuSelection() {
        System.out.println("\n-- Main Menu --\n" +
                "\n" +
                "1) Add an Animal\n" +
                "2) Manage an animal\n" +
                "3) Manage Animal Types\n" +
                "4) Quit\n");

        return waitForInt("Please choose an option :");
    }

    public static int promptForManageAnimal() {
        System.out.println("\n-- Manage an Animal --\n" +
                "\n" +
                "Search For an Animal:\n" +
                "1) Type\n" +
                "2) Name\n" +
                "3) ID\n" +
                "4) All Animals\n");

        return waitForInt("How Do You Wish To Search:");
    }
    public static int promptForManageAnimalType() {
        System.out.println("\n-- Manage Animal Types --\n" +
                "\n" +
                "1) Add an Animal Type\n" +
                "2) Delete an Animal Type\n" +
                "3) List Current Animal Types\n");

        return waitForInt("Please choose number from list above: ");
    }
    public static int promptViewAnimal(){
        System.out.println("Please Select An Option: \n" +
                "\n"+
                "1) Edit\n"+
                "2) Delete\n"+
                "3) Add Note\n");

        return waitForInt("What do you want to do: ");
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
    private String waitForString(String message, boolean required) {
        System.out.println(message);

        String value =  scanner.nextLine();

        if(required && value.trim().length() == 0){
            System.out.println("\nPlease provide an answer.\n");

            value = waitForString(message, required);
        }

        return value.trim();
    }


//    public void displayAnimalsList(AnimalsService service) {
//        ArrayList<Animal> animals = service.listAnimals();
//
//        if ((animals.size()) == (0)) {
//            System.out.println("No animals exist yet. Try creating an animal first (menu opt 2)!");
//        } else {
//            System.out.println("\n--List of Animals--");
//            int x = 1;
//            for (Animal anAnimal : animals) {
//                String name = anAnimal.getName();
//                String species = anAnimal.getSpecies();
//                System.out.printf("%s) %s\t %s\n", x, name, species);
//                x++;
//
//            }
//        }
//    }

    public void createAnimal(AnimalsService service) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String name;
        String type;
        String breed;
        String description;
        int convertedType = -1;

        System.out.println("\n--Create an Animal--");
        System.out.println("\n Please fill in the blanks.");

        System.out.println("\nAnimal name: ");
        name = scanner.nextLine().trim().toLowerCase();
        while (name.isEmpty() || name.equals("")) {
            System.out.println("\nUh,Oh! Name field is required. Try Again!\n");
            System.out.println("\nAnimal name: ");
            name = scanner.nextLine().trim();
        }

        displayAnimalType();
        System.out.println("\nSelect Type From List: ");
        type = scanner.nextLine().trim();
        while (type.isEmpty() || name.equals("")) {
            System.out.println("\nUh,Oh! Animal Type is required. Try Again!\n");
            System.out.println("Animal Type: ");
            type = scanner.nextLine().trim();
        }
        convertedType = animalsService.convertTypeFromString(type);

        System.out.println("\nBreed(optional): ");
        breed = scanner.nextLine();

        System.out.println("\nDescription: ");
        description = scanner.nextLine().trim();
        while (description.isEmpty() || name.equals("")) {
            System.out.println("\nUh,Oh! Description field is required. Try Again!\n");
            System.out.println("Description: ");
            description = scanner.nextLine().trim();
        }

        Animal animal = new Animal(name,convertedType,breed,description);
        try {
            service.createAnimal(animal);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("\nSuccess! you added %s to the list of animals.\n", name);
    }

    public void viewDetails(int animalid) throws SQLException {
        Animal newanimal = animalsService.getAnimal(animalid);
        //created a new animal above with get Animal from Animal service
        //displaying the details below

        System.out.println("--Animal Details--");
            System.out.println("\nName: " + newanimal.getName());
            System.out.println("Type: " + typeService.convertTypeIDToString(newanimal.getType()));
            System.out.println("Breed: " + newanimal.getBreed());
            System.out.println("Description: " + newanimal.getDescription());

        promptViewAnimal();
    }

//    public void editAnimal(AnimalsService service) {
//        Scanner scanner = new Scanner(System.in);
//        String name;
//        String species;
//        String breed;
//        String description;
//
//        System.out.println("--Edit Animal--\n");
//        int option = waitForInt("What is the numeric value of the animal you'd like to edit") - 1;
//        ArrayList<Animal> animals = service.listAnimals();
//        int endOfList = animals.size();
//
//        if ((option <= animals.size() - 1) && option >= 0) {
//            System.out.println("\nName: [" + animals.get(option).getName() + "]");
//            name = scanner.nextLine().trim();
//            if (!name.isEmpty()) {
//                animals.get(option).setName(name);
//            }
//            System.out.println("Species: [" + animals.get(option).getSpecies() + "]");
//            species = scanner.nextLine().trim();
//            if (!species.isEmpty()) {
//                animals.get(option).setSpecies(species);
//            }
//            System.out.println("Breed: [" + animals.get(option).getBreed() + "]");
//            breed = scanner.nextLine().trim();
//            if (!breed.isEmpty()) {
//                animals.get(option).setBreed(breed);
//            }
//            System.out.println("Description: [" + animals.get(option).getDescription() + "]");
//            description = scanner.nextLine().trim();
//            if (!description.isEmpty()) {
//                animals.get(option).setDescription(description);
//            }
//            service.updateAnimal(name, species, breed, description, option);
//
//        } else if (option < 0 || option > endOfList) {
//            System.out.println("Oh Uh! Choose an animal from 1 to " + endOfList + " on the animal list.\n");
//
//            editAnimal(service);
//        }
//    }

//    public void deleteAnimal(AnimalsService service) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("--Delete Animal--\n");
//        int option = waitForInt("What is the numeric value of the animal you'd like to delete") - 1;
//        ArrayList<Animal> animals = service.listAnimals();
//        int endOfList = animals.size();
//        if ((option <= animals.size() - 1) && option >= 0) {
//
//            System.out.println("\nName: " + animals.get(option).getName());
//            System.out.println("Species: " + animals.get(option).getSpecies());
//            System.out.println("Breed: " + animals.get(option).getBreed());
//            System.out.println("Description: " + animals.get(option).getDescription());
//            System.out.println("Are you sure you want to delete " + animals.get(option).getName() + "? Yes or No");
//
//            if (scanner.nextLine().equalsIgnoreCase("yes")) {
//                System.out.println("Deleted");
//                try {
//                    service.deleteAnimal(option);
//                } catch (IOException e) {
//                    e.printStackTrace()=
//                }
//            } else if (scanner.nextLine().equalsIgnoreCase("no")) {
//                deleteAnimal(service);
//            }
//
//        } else if (option < 0 || option > endOfList) {
//            System.out.println("That's not a valid animal on your list\n");
//            System.out.println("Select from 1 to " + endOfList + " on the animal list.");
//            deleteAnimal(service);
//        }
//    }

    public boolean quit(AnimalsService service) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAre you sure you want to quit (yes or no)?");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            System.out.println("\nThank You. Goodbye!");
            return false;
        } else if (input.equalsIgnoreCase("no")) {
            return true;
        }
        return true;
    }

    public void createAnimalType(TypeService type) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String typeEntry;

        System.out.println("\n--Create Animal Type--\n");
        System.out.println("Enter Animal Type:");
        typeEntry = scanner.nextLine().trim();

        while (typeEntry.isEmpty() || typeEntry.equals("")) {
            System.out.println("\nUh,Oh! That's not a valid entry or Type. Try Again!\n");
            System.out.println("Enter Animal Type:");
            typeEntry = scanner.nextLine().trim();
        }
        AnimalType animalType = new AnimalType(typeEntry);
        type.createAnimalType(animalType);
    }

    public void displayAnimalType() throws SQLException {
        List<AnimalType> types = typeService.listAnimalType();

        System.out.println("\n--Animal Types--");

        if(types.size() == 00){
            System.out.println("\nNo Animal Types Found.\n");
        } else {
            for(AnimalType type : types) {
                System.out.printf("%s, ", type.getType());
            }
        }
        System.out.println();
    }

    public void deleteAnimalType(TypeService type) throws SQLException {
        String typeSelection;
        typeSelection = waitForString("\nEnter Animal Type to Delete:", true);
        AnimalType animalType = new AnimalType(typeSelection);

        if (animalType.getType().equals(typeSelection)) {
            System.out.printf("%s does not exist. Please try again.\n", animalType.getType());
            deleteAnimalType(type);
        }
        else if (!animalType.getType().equals(typeSelection)){
            type.deleteAnimalType(animalType);
        }
    }

    public void displayAnimals() throws SQLException {
        ArrayList<Animal> animals = animalsService.displayAnimals();

        System.out.println("\n--Animal List--\n");

        for(Animal animal : animals){
            System.out.format("ID# %-4d" + "| %-14s" + "| %-1s", animal.getId(), animal.getName(),typeService.convertTypeIDToString(animal.getType()));
            System.out.println();
        }
        chooseAnimalByID();
    }

    public void chooseType() throws SQLException {
        ArrayList<Animal> animals = animalsService.displayAnimals();
        String userInput = waitForString("Choose Type", true);
        int typeID = animalsService.convertTypeFromString(userInput);

        for(Animal animal: animals){
            if(animal.getType() == (typeID)){
                System.out.format("ID# %-4d" + "| %-14s" + "| %-1s", animal.getId(), animal.getName(),typeService.convertTypeIDToString(animal.getType()));
                System.out.println();
            }
        }
        chooseAnimalByID();
    }
    public void chooseName() throws SQLException {
        ArrayList<Animal> animals = animalsService.displayAnimals();
        String userInput = waitForString("\nChoose Name", true);

        for (Animal animal : animals) {
            if (animal.getName().equals(userInput)) {
                System.out.format("ID# %-4d" + "| %-14s" + "| %-1s", animal.getId(), animal.getName(), typeService.convertTypeIDToString(animal.getType()));
                System.out.println();
            }
        }
//        if(animals. <= 0){
//            System.out.printf("%s is not a valid selection, please select an Animal from the list.");
//            chooseName();
//        }

        chooseAnimalByID();
     }

    public void chooseAnimalByID() throws SQLException {
        ArrayList<Animal> animals = animalsService.displayAnimals();
        //prompt for animal selection by ID
        int animalID = waitForInt("\nChoose Animal to Manage by ID: ");

        //looping over animal list and matching selected ID.
        for (Animal animal : animals) {
            if (animal.getId() == animalID) {
                viewDetails(animalID);
                //System.out.println("Name: " + animal.getName());
                // for (Note note: animal.getNotesArrayList)
            }
        }
    }
}


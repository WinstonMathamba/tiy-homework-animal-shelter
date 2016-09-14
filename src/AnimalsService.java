import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by win808mac on 8/19/16.
 */

// Methods for create animal, edit an animal, retrieve an animal, & delete an animal. an Arraylist for animals.

public class AnimalsService {

    private AnimalRepository animalRepository;
    private NoteRepo noteRepo;
    private AnimalTypeRepo animalTypeRepo;


    public AnimalsService(AnimalRepository animalRepository, AnimalTypeRepo animalTypeRepo) {
        this.animalRepository = animalRepository;
        this.animalTypeRepo = animalTypeRepo;
        //this.noteRepo = noteRepo;

    }

//    //this is the method to call on for the ArrayList of Animals.
//    public ArrayList<Animal> listAnimals() {
//        return animalRepository.listAnimals();
//
//    }

    //this is the method to create an animal with String arguments for name, species, breed, and description
    //and add will add to the ArrayList.
    public void createAnimal(Animal animal) throws IOException, SQLException {
        animalRepository.createAnimal(animal);
    }

//
//    public void updateAnimal(String name, String species, String breed, String description, int index) {
//        try {
//            animalRepository.updateAnimal(name, species, breed, description, index);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
    public Animal getAnimal(int index) throws SQLException {
        Animal animal = new Animal();
        try {
            ResultSet result = animalRepository.getAnimal(index);
            while (result.next()) {
                animal = new Animal(result.getString("name"),
                        result.getInt("typeid"),
                        result.getString("Breed"),
                        result.getString("Description"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return animal;
    }
//
//
//    //this method will delete an Animal from the ArrayList 'animalList'.
//    public void deleteAnimal(int index) throws IOException {
//        animalRepository.deleteAnimal(index);
//    }
    public ArrayList<Animal> displayAnimals() throws SQLException {
        ArrayList<Animal> allAnimals = new ArrayList<>();
        ResultSet results = this.animalRepository.getAllAnimals();

        while(results.next()){
            Animal animal = new Animal(
                    results.getInt("id"),
                    results.getString("name"),
                    results.getInt("typeid"),
                    results.getString("breed"),
                    results.getString("description"));

            allAnimals.add(animal);
        }
        return allAnimals;
    }
    public int convertTypeFromString(String type) throws SQLException {
        return this.animalTypeRepo.convertTypeFromString(type);
    }



}

import java.io.IOException;
import java.util.ArrayList;
/**
 * Created by win808mac on 8/19/16.
 */

// Methods for create animal, edit an animal, retrieve an animal, & delete an animal. an Arraylist for animals.

public class AnimalsService {

    private AnimalRepository animalRepository;

    public AnimalsService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    //this is the method to call on when I need the ArrayList of Animals.
    public ArrayList<Animal> listAnimals() {
        return animalRepository.listAnimals();

    }

    //this is the method to create an animal with String arguments for name, species, breed, and description
    //and add will add to the ArrayList.
    public void createAnimal(String name, String species, String breed, String description) throws IOException {
        Animal one = new Animal(name, species, breed, description);
        animalRepository.createAnimal(one);
    }

    public void updateAnimal(String name, String species, String breed, String description) {
        try {
            animalRepository.updateAnimal(name, species, breed, description);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //this method will delete an Animal from the ArrayList 'animalList'.
    public void deleteAnimal(int index) throws IOException {
        animalRepository.deleteAnimal(index);
    }

}

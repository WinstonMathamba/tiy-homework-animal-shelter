import java.util.ArrayList;
/**
 * Created by win808mac on 8/19/16.
 */

// Methods for create animal, edit an animal, retrieve an animal, & delete an animal. an Arraylist for animals.

public class AnimalsService {

    //this is an arraylist of Animal objects.
    private ArrayList<Animal> animalList = new ArrayList<>();

    //this is the method to call on when I need the ArrayList of Animals.
    public ArrayList<Animal> listAnimals() {
        return animalList;
    }

    //this is the method to create an animal with String arguments for name, species, breed, and description
    //and add will add to the ArrayList.
    public void createAnimal(String name, String species, String breed, String description) {
        Animal one = new Animal(name, species, breed, description);
        animalList.add(one);
    }

    //this method will delete an Animal from the ArrayList 'animalList'.
    public void deleteAnimal(AnimalsService service, int index) {
        animalList.remove(index);
    }

}

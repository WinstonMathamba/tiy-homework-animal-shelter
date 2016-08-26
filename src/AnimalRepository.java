import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Created by win808mac on 8/25/16.
 */
public class AnimalRepository {

        private final Path filePath;
        private final Gson gson;
        private ArrayList<Animal> animals = new ArrayList<>();

        public AnimalRepository(String file) throws IOException {
            gson = new GsonBuilder().setPrettyPrinting().create();

            filePath = Paths.get(file);

            if(Files.exists(filePath)) {
                String json = new String(Files.readAllBytes(filePath));
                Type listType = new TypeToken<ArrayList<Animal>>(){}.getType();

                animals = gson.fromJson(json, listType);
            }
        }

        public void createAnimal(Animal animal) throws IOException {
            animals.add(animal);

            persist();
        }

        public ArrayList<Animal> listAnimals() {
            return animals;
        }

        public void updateAnimal(String name, String species, String breed, String description) throws IOException {
        Animal one = new Animal(name, species, breed, description);
        //animals.add(one);

            persist();

        }

        private void persist() throws IOException {
            String json = gson.toJson(animals);
            Files.write(filePath, json.getBytes());
        }


        public void deleteAnimal(int index) throws IOException {
            animals.remove(index);
            persist();
        }
}





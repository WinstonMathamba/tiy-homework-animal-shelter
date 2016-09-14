import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by win808mac on 8/25/16.
 */

public class AnimalRepository {

        //private ArrayList<Animal> animals = new ArrayList<>();
        private Connection connection;


        public AnimalRepository(Connection connection) throws IOException {
            this.connection = connection;
        }

        public void createAnimal(Animal animal) throws IOException, SQLException {
        PreparedStatement statement = this.connection
                .prepareStatement("INSERT INTO animal (name, typeid, breed, description) VALUES (?,?,?,?) RETURNING id");

        //Value sets
        //statement.setInt(1,animal.getId());
        statement.setString(1,animal.getName());
        statement.setInt(2,animal.getType());
        statement.setString(3,animal.getBreed());
        statement.setString(4,animal.getDescription());

        //run query
        ResultSet result = statement.executeQuery();

        // set ID of animal
        while (result.next()) {
            animal.setId(result.getInt("id"));
        }


        }

//        public ArrayList<Animal> listAnimals() {
//            return animals;
//        }
//
//        public void updateAnimal(String name, String species, String breed, String description, int index) throws IOException {
//        Animal one = new Animal(name, species, breed, description);
//        animals.add(index, one);
//
//            persist();
//
//        }
//
        public ResultSet getAnimal(int index) throws SQLException {
            PreparedStatement stmt = this.connection
                    .prepareStatement("SELECT * FROM animal WHERE id = ?");

            stmt.setInt(1,index);
           return stmt.executeQuery();
        }
//
//        private void persist() throws IOException {
//            String json = gson.toJson(animals);
//            Files.write(filePath, json.getBytes());
//        }
//
//        public void deleteAnimal(int index) throws IOException {
//            animals.remove(index);
//            persist();
//        }

        public ResultSet getAllAnimals() throws SQLException {
                PreparedStatement statement = this.connection
                        .prepareStatement("SELECT * FROM animal ORDER BY id");

                return statement.executeQuery();
        }

}





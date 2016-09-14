import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by win808mac on 9/9/16.
 */
public class TypeService {
    private AnimalTypeRepo animalTypeRepo;

    public TypeService(AnimalTypeRepo animalTypeRepo){
        this.animalTypeRepo = animalTypeRepo;
    }

    public void createAnimalType(AnimalType type) throws SQLException {
        animalTypeRepo.createAnimalType(type);
    }

    public void deleteAnimalType(AnimalType type) throws SQLException {
        animalTypeRepo.deleteAnimalType(type);
    }

    public List<AnimalType> listAnimalType() throws SQLException {
        ResultSet results = animalTypeRepo.listAnimalType();

        ArrayList<AnimalType> typeList = new ArrayList<>();

        while(results.next()){
            AnimalType type = new AnimalType(results.getString("type"));
            typeList.add(type);
        }
        return typeList;
    }
    public String convertTypeIDToString(int typeid) throws SQLException {
        String typeString = this.animalTypeRepo.convertTypeFromID(typeid);
        return typeString;
    }
}

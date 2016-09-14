import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by win808mac on 8/19/16.
 */
public class Main {

    public static void main(String[] args) throws IOException, SQLException {

        String jdbcUrl = "jdbc:postgresql://localhost/animal_shelter";
        Connection connection = DriverManager.getConnection(jdbcUrl);

        AnimalRepository animalRepository = new AnimalRepository(connection);
        AnimalTypeRepo animalTypeRepo = new AnimalTypeRepo(connection);
        AnimalsService service = new AnimalsService(animalRepository, animalTypeRepo);
        TypeService typeService = new TypeService(animalTypeRepo);

        MenuService menu = new MenuService(service, typeService);

        boolean repeat = true;
        while (repeat) {
            int action = MenuService.promptForMainMenuSelection();

            if (action == MenuService.ADD_ANIMAL) {
                menu.createAnimal(service);
            }
            else if (action == MenuService.MANAGE_ANIMAL) {
                int index = menu.promptForManageAnimal();

                if(index == menu.TYPE){
                    menu.displayAnimalType();
                    menu.chooseType();
                } else if(index == menu.NAME){
                    menu.chooseName();
                }else if (index == menu.ID){
                    menu.chooseAnimalByID();
                }else if (index == menu.All_ANIMALS){
                    menu.displayAnimals();
                }

            }

            else if (action == MenuService.MANAGE_ANIMAL_TYPE) {
                int index = menu.promptForManageAnimalType();

                if (index == MenuService.ADD_TYPE) {
                    menu.createAnimalType(typeService);
                } else if (index == MenuService.DELETE_TYPE) {
                    menu.deleteAnimalType(typeService);
                } else if (index == MenuService.LIST_TYPE) {
                    //create list of types
                    List<AnimalType> animalTypes = typeService.listAnimalType();
                    //display list of types
                    menu.displayAnimalType();
                }
            }
//            else if (action == MenuService.EDIT_ANIMAL) {
//                        menu.editAnimal(service);
//            }
//            else if (action == MenuService.DELETE_ANIMAL) {
//                        menu.deleteAnimal(service);
//            }
            else if (action < 1 || action > 4) {
                System.out.println("\nPlease input a valid menu option (1 - 4)");
            }
            else if (action == MenuService.QUIT) {
                        repeat = menu.quit(service);
            }

        }
    }
}
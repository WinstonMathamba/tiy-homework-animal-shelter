import org.junit.After;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by win808mac on 8/30/16.
 */
//public class AnimalsServiceTest {
//    AnimalRepository animalRepository = new AnimalRepository("test.json");
//    AnimalsService service = new AnimalsService(animalRepository);
//
//    public AnimalsServiceTest() throws IOException {
//    }
//
//    @Test
//    public void createAnimalTest() throws IOException {
//        //Arrange
//        service.createAnimal("Lulu","Bearded Dragon","","Spiky");
//
//        //Act
//        Animal anAnimal = service.getAnimal(0);
//
//        //Assert
//        assertThat(anAnimal.getName(),is(equalTo("Lulu")));
//        assertThat(anAnimal.getBreed(),is(equalTo("")));
//
//    }
//
//    @Test
//    public void updateAnimalTest() throws IOException{
//        //Arrange
//        service.updateAnimal("ben","rat","","grey",0);
//
//        //Act
//
//        //Assert
//        assertThat(service.getAnimal(0).getName(),is(equalTo("ben")));
//        assertThat(service.getAnimal(0).getDescription(),is(equalTo("grey")));
//    }
//
//    @Test
//    public void listAnimalTest() throws IOException {
//        //Arrange
//        service.createAnimal("Lulu","Bearded Dragon","","Spiky");
//        service.createAnimal("Chachi","Eagle","","majestic");
//
//        //Act
//
//        //Assert
//        assertThat(service.listAnimals().size(),equalTo(2));
//
//    }
//
//    @Test
//    public void deleteAnimalTest() throws IOException {
//        //Arrange
//        service.createAnimal("Nemo", "clownfish","","lost");
//
//
//        //Act
//        service.deleteAnimal(0);
//        int test = service.listAnimals().size();
//
//        //Assert
//        assertThat(test,equalTo(0));
//
//    }
//
//    @After
//    public void clearTestFile() {
//        File f = new File("test.json");
//        if (f.exists()) {
//            f.delete();
//        }
//    }

//}

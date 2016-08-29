import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by win808mac on 8/29/16.
 */
public class AnimalTest {
    @Test
    /*Given an Animal
    //When setName is invoked
    //Then name is assigned
    */
    public void setNameTest(){
        //arrange
        Animal testAnimal = new Animal("Lou","Parrot","","Chatty Bird");

        //act
        testAnimal.setName("Larry");

        //assert
        assertThat(testAnimal.getName(),equalTo("Larry"));
    }

    @Test
    /*Given an Animal
    //When setSpecies is invoked
    //Then species is assigned
    */
    public void setSpeciesTest(){
        //arrange
        Animal testAnimal = new Animal("Lou","Parrot","","Chatty Bird");

        //act
        testAnimal.setSpecies("BeardedDragon");

        //assert
        assertThat(testAnimal.getSpecies(),equalTo("BeardedDragon"));
    }

    @Test
    /*Given an Animal
    //When setBreed is invoked
    //Then breed is assigned
    */
    public void setBreedTest(){
        //arrange
        Animal testAnimal = new Animal("Lou","Parrot","","Chatty Bird");

        //act
        testAnimal.setBreed("Spiketail");

        //assert
        assertThat(testAnimal.getBreed(),equalTo("Spiketail"));
    }

    @Test
    /*Given an Animal
    //When setDescription is invoked
    //Then Description is assigned
    */
    public void setDescriptionTest(){
        //arrange
        Animal testAnimal = new Animal("Lou","Parrot","","Chatty Bird");

        //act
        testAnimal.setDescription("Grumpy lazy lizard");

        //assert
        assertThat(testAnimal.getDescription(),equalTo("Grumpy lazy lizard"));
    }
}

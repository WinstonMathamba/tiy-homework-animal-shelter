/**
 * This class will also have methods for managing a list of animals.
 */

/**
 * Created by win808mac on 8/19/16.
 */

public class Animal {
    private String name;
    private String species;
    private String breed;
    private String description;


    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;

    }

    public void setSpecies(String s) {
        species = s;
    }

    public String getSpecies() {
        return species;
    }

    public void setBreed(String b) {
        breed = b;
    }

    public String getBreed() {
        return breed;
    }

    public void setDescription(String d) {
        description = d;
    }

    public String getDescription() {
        return description;
    }

    public Animal(String name, String species, String breed, String description) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.description = description;

    }

}

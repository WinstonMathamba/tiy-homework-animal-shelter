/**
 * This class will also have methods for managing a list of animals.
 */

import java.util.ArrayList;

/**
 * Created by win808mac on 8/19/16.
 */

public class Animal {
    private int id;
    private String name;
    private int typeid;
    private String breed;
    private String description;
    private ArrayList<Notes> notes = new ArrayList<Notes>();


    public void setId(int i) { id = i; }

    public int getId() { return id; }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setType(int t) {
        typeid = t;
    }

    public int getType() {
        return typeid;
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

    public Animal(int id, String name, int typeid, String breed, String description) {
        this.id = id;
        this.name = name;
        this.typeid = typeid;
        this.breed = breed;
        this.description = description;
    }

    public Animal(String name, int typeid, String breed, String description) {
        this.name = name;
        this.typeid = typeid;
        this.breed = breed;
        this.description = description;
    }

    public Animal(){

    }

}

import java.util.ArrayList;

/**
 * Created by win808mac on 9/9/16.
 */
public class AnimalType {
    private String type;
    private int id;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AnimalType(String type){
        this.type = type;
    }

    public AnimalType(int id, String type){
        this.type = type;
        this.id = id;
    }
}

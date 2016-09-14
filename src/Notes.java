import java.sql.Date;

/**
 * Created by win808mac on 9/8/16.
 */
public class Notes {
    private int id;
    private String text;
    private Date date;

    public Notes(String text) {
        this.text = text;
    }

    public Notes(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Date getDate(){
        return date;
    }

}

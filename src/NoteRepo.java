import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by win808mac on 9/11/16.
 */
public class NoteRepo {
    private final Connection connection;

    public NoteRepo(Connection connection) {
        this.connection = connection;
    }

    public void createNote(Notes notes) throws SQLException {
        PreparedStatement stmnt = this.connection
                .prepareStatement("INSERT INTO notes(note_txt, animalid, DATE) VALUES (?,?,?)RETURNING id");
        //set values
        stmnt.setString(1,notes.getText());
        stmnt.setInt(2,notes.getId());
        stmnt.setDate(3, notes.getDate());

        //run my query
        ResultSet result = stmnt.executeQuery();

        // set the Note ID
        while (result.next()){
            notes.setId(result.getInt("id"));
        }
    }

    public ResultSet dispayNotes(int animalid) throws SQLException {
        PreparedStatement stmnt = this.connection
                .prepareStatement("SELECT * FROM notes WHERE animalid = ?");

        stmnt.setInt(1, animalid);
        return stmnt.executeQuery();
    }

    public void deleteNote(Notes note) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("DELETE FROM notes WHERE id = ?");

        statement.setInt(1, note.getId());

        statement.execute();

    }
}

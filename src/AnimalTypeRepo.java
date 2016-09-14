import java.sql.*;

/**
 * Created by win808mac on 9/9/16.
 */
public class AnimalTypeRepo {
    private final Connection connection;

    public AnimalTypeRepo(Connection connection) {
        this.connection = connection;
    }

    public void createAnimalType(AnimalType type) throws SQLException {
        PreparedStatement statement = this.connection
                .prepareStatement("INSERT INTO animal_type (type) VALUES (?) RETURNING id");

        //set value for type
        statement.setString(1, type.getType());
        //run the query
        ResultSet result = statement.executeQuery();
        //set the ID of the type just persisted
        while(result.next()){
            type.setId(result.getInt("id"));
        }
    }

    public ResultSet listAnimalType() throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery("SELECT * FROM animal_type ORDER BY type");

    }

    public void deleteAnimalType(AnimalType type) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("DELETE FROM animal_type WHERE type = ?");

        statement.setString(1, type.getType());

        statement.execute();

    }
    public int convertTypeFromString(String type) throws SQLException {
        int returnTypeId = -1;
        PreparedStatement statement = connection
                .prepareStatement("SELECT * FROM animal_type WHERE type = ?");

        statement.setString(1, type);

        ResultSet typeIdResult = statement.executeQuery();
        if(typeIdResult.next()) {
            returnTypeId = ((Number)typeIdResult.getObject(1)).intValue();
        }
        return returnTypeId;
    }

    public String convertTypeFromID(int typeid) throws SQLException {
        String typeString = "";

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM animal_type WHERE id = ?");

        statement.setInt(1, typeid);

        ResultSet type = statement.executeQuery();
        if(type.next()) {
            typeString = type.getString(2);
        }
        return typeString;
    }
}

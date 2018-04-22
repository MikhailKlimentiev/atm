package tasks.files.database.xml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * SedanDatabaseReader.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 04/05/2018
 */
public class SedanDatabaseReader extends AbstractReader {

    private Connection connection;

    public SedanDatabaseReader(Connection connection) {
        super();
        // Connection initialization
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * readInfo.
     * readInfo() method overrides abstract method from AbstractReader class gets id, creates prepareStatement
     * with select query for connected database, gets resultSet from connected database for id received as a parameter,
     * initializes Sedan object with values from received resultSet and returns initialized Sedan object.
     *
     * @param id
     * @return Sedan sedan
     */
    @Override
    public Sedan readInfo(int id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Sedan sedan = null;

        try {
            // prepareStatement creation
            preparedStatement = getConnection().prepareStatement("select * from public.\"Sedan\" where id=?;");
            preparedStatement.setInt(1, id);

            // execution prepareStatement for connected data base
            resultSet = preparedStatement.executeQuery();
            // passage through resultSet
            while (resultSet.next()) {
                if (resultSet.getInt("id") == id) {
                    // sedan object initialization with values of database's columns from resultSet object's value
                    sedan = new Sedan(resultSet.getInt("id"), resultSet.getString("type"),
                            resultSet.getString("model"), resultSet.getString("transmission"),
                            resultSet.getDouble("litresPerHudredKm "), resultSet.getInt("cost"),
                            resultSet.getInt("numberOfSeats"), resultSet.getInt("yearOfManufacture"),
                            resultSet.getString("color"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (InvalidTransmissionTypeException e) {
            e.printStackTrace();
        } catch (InvalidCarTypeException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != resultSet) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sedan;
    }
}

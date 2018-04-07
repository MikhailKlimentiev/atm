package tasks.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TruckDatabaseReader.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 04/07/2018
 */
public class TruckDatabaseReader extends AbstractReader {

	private Connection connection;

	public TruckDatabaseReader(Connection connection) {
		super();
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
	 * initializes Truck object with values from received resultSet and returns initialized Truck object.
	 *
	 * @param id
	 * @return Truck truck
	 */
	@Override
	public Truck readInfo(int id) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Truck truck = null;

		try {
			preparedStatement = getConnection().prepareStatement("select * from public.\"Truck\" where id=?;");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("id") == id) {
					truck = new Truck(resultSet.getInt("id"), resultSet.getString("type"),
							resultSet.getString("model"), resultSet.getString("transmission"),
							resultSet.getDouble("litresPerHudredKm"), resultSet.getInt("cost"),
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
		return truck;
	}
}

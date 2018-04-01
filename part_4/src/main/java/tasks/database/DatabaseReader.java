package tasks.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseReader extends AbstractReader {

	private Connection connection;

	public DatabaseReader(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public Vehicle readInfo(int id) {
		PreparedStatement prState = null;
		ResultSet rs = null;

		Sedan sedan = null;

		try {
			prState = getConnection().prepareStatement("select * from Sedan where id=?;");
			prState.setInt(1, id);

			rs = prState.executeQuery();
			while (rs.next()) {
				if (rs.getInt("id") == id) {
					sedan = new Sedan(rs.getInt("id"), rs.getString("type"),
							rs.getString("model"), rs.getString("transmission"),
							rs.getDouble("litresPerHudredKm"), rs.getInt("cost"),
							rs.getInt("numberOfSeats"), rs.getInt("yearOfManufacture"),
							rs.getString("color"));
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
				if (null != rs) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (prState != null) {
					prState.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sedan;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}

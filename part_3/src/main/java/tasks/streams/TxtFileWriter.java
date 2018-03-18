package tasks.streams;

import java.io.*;

public class TxtFileWriter extends AbstractWriter {

	public static final String OUTPUT_FILE_PATH = "resources\\Output.txt";

	@Override
	public void writeObjectIntoFile(Vehicle vehicle) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH, true));
			out.write("\n" + vehicle.getId() + ":" + vehicle.getType() + ":" + vehicle.getModel() + ":"
					+ vehicle.getTransmission() + ":" + vehicle.getYearOfManufacture());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
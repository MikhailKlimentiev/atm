package tasks.streams;

import java.io.*;

/**
 * TxtFileReaderForCabriolet.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/18/2018
 */
public class TxtFileReaderForCabriolet extends AbstractReader {

	//Path for file to read
	private String fullPath;

	public String getFullPath() {

		return fullPath;
	}

	public void setFullPath(String fullPath) {

		this.fullPath = fullPath;
	}

	public TxtFileReaderForCabriolet(String fullPath) {
		super();
		this.fullPath = fullPath;
	}

	/**
	 * readInfoFromFile.
	 * readInfoFromFile() method according to getted id chooses row in a file, read info splitted by ":" from this file,
	 * passes readed information into Cabriolet object's constructor and returns Cabriolet object.
	 * @param id
	 * @return Cabriolet cabriolet
	 */
	@Override
	public Cabriolet readInfoFromFile(int id) {
		File f = new File(getFullPath());
		BufferedReader br = null;
		String str = null;
		Cabriolet cabriolet = null;
		try {
			br = new BufferedReader(new FileReader(f));

			while ((str = br.readLine()) != null) {
				String[] info = str.split(":");
				if (Integer.parseInt(info[0]) == id) {
					cabriolet = new Cabriolet(Integer.parseInt(info[0]), info[1], info[2], info[3],
							Double.parseDouble(info[4]), Integer.parseInt(info[5]), Integer.parseInt(info[6]),
							Integer.parseInt(info[7]), info[8], Boolean.parseBoolean(info[9]));
				}
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InvalidTransmissionTypeException e) {
			e.printStackTrace();
		} catch (InvalidCarTypeException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return cabriolet;
	}
}
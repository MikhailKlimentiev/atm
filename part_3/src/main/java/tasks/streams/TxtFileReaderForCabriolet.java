package tasks.streams;

import java.io.*;

public class TxtFileReaderForCabriolet extends AbstractReader {

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
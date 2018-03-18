package tasks.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TxtFileReaderForTruck extends AbstractReader {

	private String fullPath;

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public TxtFileReaderForTruck(String fullPath) {
		super();
		this.fullPath = fullPath;
	}

	@Override
	public Truck readInfoFromFile(int id) {
		File f = new File(getFullPath());
		BufferedReader br = null;
		String str = null;
		Truck truck = null;
		try {
			br = new BufferedReader(new FileReader(f));

			while ((str = br.readLine()) != null) {
				String[] info = str.split(":");
				if (Integer.parseInt(info[0]) == id) {
					truck = new Truck(Integer.parseInt(info[0]), info[1], info[2], info[3],
							Double.parseDouble(info[4]), Integer.parseInt(info[5]), Integer.parseInt(info[6]),
							Integer.parseInt(info[7]), info[8]);
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
		return truck;
	}
}

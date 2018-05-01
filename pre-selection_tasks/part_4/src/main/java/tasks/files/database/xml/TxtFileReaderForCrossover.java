package tasks.files.database.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * TxtFileReaderForCrossover.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/18/2018
 */
public class TxtFileReaderForCrossover extends AbstractReader {

    //Path for file to read
    private String fullPath;

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public TxtFileReaderForCrossover(String fullPath) {
        super();
        this.fullPath = fullPath;
    }

    /**
     * readInfoFromFile.
     * readInfoFromFile() method according to getted id chooses row in a file, read info splitted by ":" from this file,
     * passes readed information into Crossover object's constructor and returns Crossover object.
     *
     * @param id
     * @return Crossover crossover
     */
    @Override
    public Crossover readInfo(int id) {
        File f = new File(getFullPath());
        BufferedReader br = null;
        String str = null;
        Crossover crossover = null;
        try {
            br = new BufferedReader(new FileReader(f));

            while ((str = br.readLine()) != null) {
                String[] info = str.split(":");
                if (Integer.parseInt(info[0]) == id) {
                    crossover = new Crossover(Integer.parseInt(info[0]), info[1], info[2], info[3],
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
        return crossover;
    }
}

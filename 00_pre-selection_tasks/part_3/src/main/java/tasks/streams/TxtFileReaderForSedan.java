package tasks.streams;

import java.io.*;

/**
 * TxtFileReaderForSedan.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/18/2018
 */
public class TxtFileReaderForSedan extends AbstractReader {

    //Path for file to read
    private String fullPath;

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public TxtFileReaderForSedan(String fullPath) {
        super();
        this.fullPath = fullPath;
    }

    /**
     * readInfoFromFile.
     * readInfoFromFile() method according to getted id chooses row in a file, read info splitted by ":" from this file,
     * passes readed information into Sedan object's constructor and returns Sedan object.
     *
     * @param id
     * @return Sedan sedan
     */
    @Override
    public Sedan readInfoFromFile(int id) {
        File f = new File(getFullPath());
        BufferedReader br = null;
        String str = null;
        Sedan sedan = null;
        try {
            br = new BufferedReader(new FileReader(f));

            while ((str = br.readLine()) != null) {
                String[] info = str.split(":");
                if (Integer.parseInt(info[0]) == id) {
                    sedan = new Sedan(Integer.parseInt(info[0]), info[1], info[2], info[3],
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
        return sedan;
    }
}

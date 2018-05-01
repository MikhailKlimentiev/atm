package tasks.streams;

import java.io.*;

/**
 * TxtFileWriter.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/18/2018
 */
public class TxtFileWriter extends AbstractWriter {

    //Path for file to write
    public static final String OUTPUT_FILE_PATH = "pre-selection_tasks\\resources\\Output.txt";

    /**
     * writeObjectIntoFile.
     * writeObjectIntoFile() method gets Vehicle object, creates file if it does not exist into specified folder
     * and write information into file from the Vehicle object.
     *
     * @param vehicle
     */
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
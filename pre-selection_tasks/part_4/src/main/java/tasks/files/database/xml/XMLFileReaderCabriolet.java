package tasks.files.database.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * XMLFileReaderCabriolet.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 04/22/2018
 */
public class XMLFileReaderCabriolet extends AbstractReader {
    private String fullPathForXmlToBeParsed;

    public XMLFileReaderCabriolet(String fullPath) {
        super();
        this.fullPathForXmlToBeParsed = fullPath;
    }

    @Override
    public Vehicle readInfo(int id) {
        ArrayList<Vehicle> vehicleSetByCarType = null;
        Vehicle vehicle = null;
        File fileInput = new File(fullPathForXmlToBeParsed);
        SAXParserFactory spfac = SAXParserFactory.newInstance();
        CarsSAXParser handler = null;
        try {
            SAXParser sp = spfac.newSAXParser();
            handler = new CarsSAXParser();
            sp.parse(fileInput, handler);
            vehicleSetByCarType = handler.getVehicleByType(2);
            vehicle = handler.getVehicleById(vehicleSetByCarType, id);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Parsing fails: " + e.getMessage());
        }
        return vehicle;
    }
}

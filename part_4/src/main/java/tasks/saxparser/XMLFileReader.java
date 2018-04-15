package tasks.saxparser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 * XMLFileReader.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 04/16/2018
 */
public class XMLFileReader extends AbstractReader {

	private String fullPath;

	public XMLFileReader(String fullPath) {
		super ();
		this.fullPath = fullPath;
	}

	@Override
	public ArrayList<Vehicle> readInfo() {
		File fileInput = new File(fullPath);
		Vehicle vehicle = null;
		SAXParserFactory spfac = SAXParserFactory.newInstance();
		CarsSAXParser handler = null;
		try {
			SAXParser sp = spfac.newSAXParser();
			handler = new CarsSAXParser();
			sp.parse(fileInput, handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println ("Parsing fails: " + e.getMessage());
		}
		return handler.getTaxiPark();
	}
}


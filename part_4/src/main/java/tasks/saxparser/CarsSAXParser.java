package tasks.saxparser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import tasks.database.InvalidCarTypeException;
import tasks.database.InvalidTransmissionTypeException;

import java.util.ArrayList;

/**
 * CarSAXParser.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 04/15/2018
 */
public class CarsSAXParser extends DefaultHandler {

	private StringBuilder thisElement;
	private Sedan sedan;
	private Cabriolet cabriolet;
	private Crossover crossover;
	private Truck truck;

	private ArrayList<Vehicle> taxiPark = new ArrayList<Vehicle>();

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parse XML document with Cars Info");
	}

	@Override
	public void startElement(String namespaceURI, String localName,
	                         String qName, Attributes atts) throws SAXException {
		thisElement = new StringBuilder();
		if (qName.equals("sedan")) {
			try {
				sedan = new Sedan(0, "Sedan", "model", "Manual", 0,
						0, 0, 0, "color");
			} catch (InvalidCarTypeException e) {
				e.printStackTrace();
			} catch (InvalidTransmissionTypeException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException {
		if (qName.equals("sedan")) {
			System.out.println(sedan.toString());
			taxiPark.add(sedan);
		} else {
			String elementVal = thisElement.toString();
			if (qName.equals("sedanId")) {
				sedan.setId(Integer.parseInt(elementVal));
			} else if (qName.equals("sedanType")) {
				sedan.setType(elementVal);
			} else if (qName.equals("sedanModel")) {
				sedan.setModel(elementVal);
			} else if (qName.equals("sedanTransmission")) {
				sedan.setTransmission(elementVal);
			} else if (qName.equals("sedanLitresPerHudredKm")) {
				sedan.setLitresPerHudredKm(Double.parseDouble(elementVal));
			} else if (qName.equals("sedanCost")) {
				sedan.setCost(Integer.parseInt(elementVal));
			} else if (qName.equals("sedanNumberOfSeats")) {
				sedan.setNumberOfSeats(Integer.parseInt(elementVal));
			} else if (qName.equals("sedanYearOfManufacture")) {
				sedan.setYearOfManufacture(Integer.parseInt(elementVal));
			} else if (qName.equals("sedanColor")) {
				sedan.setColor(elementVal);
			}
		}
		thisElement = new StringBuilder();
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Stop parse XML document with Cars Info...");
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		thisElement.append(ch, start, length);
	}

	public ArrayList<Vehicle> getTaxiPark() {
		return taxiPark;
	}
}
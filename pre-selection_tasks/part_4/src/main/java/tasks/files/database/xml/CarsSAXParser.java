package tasks.files.database.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * CarSAXParser.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 04/16/2018
 */
public class CarsSAXParser extends DefaultHandler {

    private StringBuilder thisElement;
    private tasks.files.database.xml.Sedan sedan;
    private tasks.files.database.xml.Cabriolet cabriolet;
    private Crossover crossover;
    private Truck truck;

    private ArrayList<Vehicle> taxiPark = new ArrayList<Vehicle>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML document with Cars Info.");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = new StringBuilder();
        if (qName.equals("sedan")) {
            try {
                sedan = new Sedan(0, "Sedan", "model", "Manual", 0, 0,
                        0, 0, "color");
            } catch (InvalidCarTypeException e) {
                e.printStackTrace();
            } catch (InvalidTransmissionTypeException e) {
                e.printStackTrace();
            }
        } else if (qName.equals("cabriolet")) {
            try {
                cabriolet = new Cabriolet(0, "Cabriolet", "model", "Manual",
                        0, 0, 0, 0, "color", true);
            } catch (InvalidCarTypeException e) {
                e.printStackTrace();
            } catch (InvalidTransmissionTypeException e) {
                e.printStackTrace();
            }
        } else if (qName.equals("crossover")) {
            try {
                crossover = new Crossover(0, "Crossover", "model", "Manual",
                        0, 0, 0, 0, "color");
            } catch (InvalidCarTypeException e) {
                e.printStackTrace();
            } catch (InvalidTransmissionTypeException e) {
                e.printStackTrace();
            }
        } else if (qName.equals("truck")) {
            try {
                truck = new Truck(0, "Truck", "model", "Manual", 0,
                        0, 0, 0, "color");
            } catch (InvalidCarTypeException e) {
                e.printStackTrace();
            } catch (InvalidTransmissionTypeException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {

        if (qName.equals("sedan")) {
            System.out.println(sedan.toString());
            taxiPark.add(sedan);
        } else if (qName.equals("cabriolet")) {
            System.out.println(cabriolet.toString());
            taxiPark.add(cabriolet);
        } else if (qName.equals("crossover")) {
            System.out.println(crossover.toString());
            taxiPark.add(crossover);
        } else if (qName.equals("truck")) {
            System.out.println(truck.toString());
            taxiPark.add(truck);
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

            } else if (qName.equals("cabrioletId")) {
                cabriolet.setId(Integer.parseInt(elementVal));
            } else if (qName.equals("cabrioletType")) {
                cabriolet.setType(elementVal);
            } else if (qName.equals("cabrioletModel")) {
                cabriolet.setModel(elementVal);
            } else if (qName.equals("cabrioletTransmission")) {
                cabriolet.setTransmission(elementVal);
            } else if (qName.equals("cabrioletLitresPerHudredKm")) {
                cabriolet.setLitresPerHudredKm(Double.parseDouble(elementVal));
            } else if (qName.equals("cabrioletCost")) {
                cabriolet.setCost(Integer.parseInt(elementVal));
            } else if (qName.equals("cabrioletNumberOfSeats")) {
                cabriolet.setNumberOfSeats(Integer.parseInt(elementVal));
            } else if (qName.equals("cabrioletYearOfManufacture")) {
                cabriolet.setYearOfManufacture(Integer.parseInt(elementVal));
            } else if (qName.equals("cabrioletColor")) {
                cabriolet.setColor(elementVal);
            } else if (qName.equals("cabrioletTopRaised")) {
                cabriolet.setTopRaised(Boolean.parseBoolean(elementVal));

            } else if (qName.equals("crossoverId")) {
                crossover.setId(Integer.parseInt(elementVal));
            } else if (qName.equals("crossoverType")) {
                crossover.setType(elementVal);
            } else if (qName.equals("crossoverModel")) {
                crossover.setModel(elementVal);
            } else if (qName.equals("crossoverTransmission")) {
                crossover.setTransmission(elementVal);
            } else if (qName.equals("crossoverLitresPerHudredKm")) {
                crossover.setLitresPerHudredKm(Double.parseDouble(elementVal));
            } else if (qName.equals("crossoverCost")) {
                crossover.setCost(Integer.parseInt(elementVal));
            } else if (qName.equals("crossoverNumberOfSeats")) {
                crossover.setNumberOfSeats(Integer.parseInt(elementVal));
            } else if (qName.equals("crossoverYearOfManufacture")) {
                crossover.setYearOfManufacture(Integer.parseInt(elementVal));
            } else if (qName.equals("crossoverColor")) {
                crossover.setColor(elementVal);

            } else if (qName.equals("truckId")) {
                truck.setId(Integer.parseInt(elementVal));
            } else if (qName.equals("truckType")) {
                truck.setType(elementVal);
            } else if (qName.equals("truckModel")) {
                truck.setModel(elementVal);
            } else if (qName.equals("truckTransmission")) {
                truck.setTransmission(elementVal);
            } else if (qName.equals("truckLitresPerHudredKm")) {
                truck.setLitresPerHudredKm(Double.parseDouble(elementVal));
            } else if (qName.equals("truckCost")) {
                truck.setCost(Integer.parseInt(elementVal));
            } else if (qName.equals("truckNumberOfSeats")) {
                truck.setNumberOfSeats(Integer.parseInt(elementVal));
            } else if (qName.equals("truckYearOfManufacture")) {
                truck.setYearOfManufacture(Integer.parseInt(elementVal));
            } else if (qName.equals("truckColor")) {
                truck.setColor(elementVal);
            }
            thisElement = new StringBuilder();
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Stop parse XML document with Cars Info.");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        thisElement.append(ch, start, length);
    }

    public ArrayList<Vehicle> getVehicleByType(int typeId) {
        String selectedCarType;
        ArrayList<Vehicle> vehicleSetByCarType = new ArrayList<Vehicle>();
        switch (typeId) {
            case 1:
                selectedCarType = "Sedan";
                for (Vehicle vehicle : taxiPark) {
                    if ((vehicle.getType()).equals(selectedCarType)) {
                        vehicleSetByCarType.add(vehicle);
                    }
                }
                break;

            case 2:
                selectedCarType = "Cabriolet";
                for (Vehicle vehicle : taxiPark) {
                    if ((vehicle.getType()).equals(selectedCarType)) {
                        vehicleSetByCarType.add(vehicle);
                    }
                }
                break;

            case 3:
                selectedCarType = "Crossover";
                for (Vehicle vehicle : taxiPark) {
                    if ((vehicle.getType()).equals(selectedCarType)) {
                        vehicleSetByCarType.add(vehicle);
                    }
                }
                break;

            case 4:
                selectedCarType = "Truck";
                for (Vehicle vehicle : taxiPark) {
                    if ((vehicle.getType()).equals(selectedCarType)) {
                        vehicleSetByCarType.add(vehicle);
                    }
                }
                break;
        }
        return vehicleSetByCarType;
    }


    public Vehicle getVehicleById(ArrayList<Vehicle> getVehicleByType, int carId) {
        Vehicle result = null;
        for (Vehicle vehicle : getVehicleByType) {
            if (vehicle.getId() == carId) {
                result = vehicle;
            }
        }
        return result;
    }
}
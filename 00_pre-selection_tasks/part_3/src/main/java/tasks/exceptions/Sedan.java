package tasks.exceptions;

/**
 * Sedan.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 03/11/2018
 */
public class Sedan extends Vehicle {

    private static final String TYPE = "Sedan";

    public Sedan(String type, String model, String transmission, double litresPerHudredKm, int cost, int numberOfSeats,
                 int yearOfManufacture, String color
    ) throws InvalidCarTypeException, InvalidTransmissionTypeException {
        super(type, model, transmission, litresPerHudredKm, cost, numberOfSeats, yearOfManufacture, color);
        if (!(this.TYPE.equalsIgnoreCase(type))) {
            throw new InvalidCarTypeException("Sedan");
        }
        if (!(transmission.equalsIgnoreCase("Automatic") || transmission.equalsIgnoreCase("Manual"))) {
            throw new InvalidTransmissionTypeException("Sedan");
        }
    }

    /**
     * inform.
     * inform() method overrides abstract method from Vehicle class and prints information what sedan is in console
     */
    @Override
    public void inform() {
        System.out.println(super.type +
                " is defined as a vehicle with four doors that features a traditional trunk design.");
    }

}

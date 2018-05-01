package tasks.streams;

/**
 * Truck.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 03/11/2018
 */
public class Truck extends Vehicle implements Loaded, Passable {

    private static final String TYPE = "Truck";

    public Truck(int id, String type, String model, String transmission, double litresPerHudredKm, int cost,
                 int numberOfSeats, int yearOfManufacture, String color
    )
            throws InvalidCarTypeException, InvalidTransmissionTypeException {
        super(id, type, model, transmission, litresPerHudredKm, cost, numberOfSeats, yearOfManufacture, color);
        if (!this.TYPE.equalsIgnoreCase(type)) {
            throw new InvalidCarTypeException("Truck");
        }
        if (!(transmission.equalsIgnoreCase("Automatic") || transmission.equalsIgnoreCase("Manual"))) {
            throw new InvalidTransmissionTypeException("Truck");
        }
    }

    /**
     * inform.
     * inform() method overrides abstract method from Vehicle class and prints information what truck is in console
     */
    @Override
    public void inform() {
        System.out.println("About " + super.type + ": \n" +
                "When you see the great variety and sheer number of pickup trucks on today's roads, it's hard  \n" +
                "to believe that pickups used to be strictly workhorses for farmers and business owners. \n" +
                "Though they are still used for those purposes, modern-day pickup trucks are just \n" +
                "as likely to be seen taking the family on a ski vacation or to the lake, \n" +
                "passengers ensconced in a spacious crew cab fitted with heated \n" +
                "leather seats and a DVD entertainment system.");
    }

    /**
     * transportGoods.
     * transportGoods() method overrides abstract method from Loaded interface, prints text in console
     */
    @Override
    public void transportGoods() {
        System.out.println("You can transport goods on " + super.getModel());
    }

    /**
     * driveOffRoad.
     * driveOffRoad() method overrides abstract method from Passable interface, prints text in console
     */
    @Override
    public void driveOffRoad() {
        System.out.println("On " + super.getModel() + " you can drive off-road");
    }
}

package tasks.model;

/**
 * Truck.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/09/2018
 */
public class Truck extends Vehicle implements Loaded, Passable {

    public Truck(String type, String model, String transmission, double litresPerHudredKm, int cost,
                 int numberOfSeats, int yearOfManufacture
    ) {
        super(type, model, transmission, litresPerHudredKm, cost, numberOfSeats, yearOfManufacture);
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

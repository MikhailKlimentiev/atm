package tasks.model;

/**
 * Crossover.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/09/2018
 */
public class Crossover extends Vehicle implements Roomy, Passable {

    public Crossover(String type, String model, String transmission, double litresPerHudredKm, int cost,
                     int numberOfSeats, int yearOfManufacture
    ) {
        super(type, model, transmission, litresPerHudredKm, cost, numberOfSeats, yearOfManufacture);
    }

    /**
     * inform.
     * inform() method overrides abstract method from Vehicle class and prints information what crossover is in console
     */
    @Override
    public void inform() {
        System.out.println("The idea behind an average " + super.type +
                " is simple: Deliver the smooth ride and efficiency of a family sedan \n" +
                "with the high-driving position, cargo capacity and rugged nature of a sport-utility vehicle.");
    }

    /**
     * setAddedSeats.
     * setAddedSeats() method overrides abstract method from Roomy interface, increases umberOfSeats variable by and
     * prints result in console
     */
    @Override
    public void setAddedSeats() {
        System.out.println("Number of seats of the \"" + super.getModel() + "\" has been increased by 3 places and equals " +
                (super.numberOfSeats + 3));
    }

    /**
     * driveOffRoad.
     * driveOffRoad() method overrides abstract method from Passable interface, prints text in console
     */
    @Override
    public void driveOffRoad() {
        System.out.println("On \"" + super.getModel() + "\" you can drive off-road");
    }
}

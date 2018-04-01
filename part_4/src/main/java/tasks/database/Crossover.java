package tasks.database;

/**
 * Crossover.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 03/11/2018
 */
public class Crossover extends Vehicle implements Roomy, Passable {

	private static final String TYPE = "Crossover";

	public Crossover(int id, String type, String model, String transmission, double litresPerHudredKm, int cost,
	                 int numberOfSeats, int yearOfManufacture, String color)
			throws InvalidCarTypeException, InvalidTransmissionTypeException {
		super(id, type, model, transmission, litresPerHudredKm, cost, numberOfSeats, yearOfManufacture, color);
		if (!this.TYPE.equalsIgnoreCase(type)) {
			throw new InvalidCarTypeException("Crossover");
		}
		if (!(transmission.equalsIgnoreCase("Automatic") || transmission.equalsIgnoreCase("Manual"))) {
			throw new InvalidTransmissionTypeException("Crossover");
		}
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

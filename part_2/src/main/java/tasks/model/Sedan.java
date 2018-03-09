package tasks.model;

/**
 * Sedan.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/09/2018
 */
public class Sedan extends Vehicle {

	public Sedan(String type, String model, String transmission, double litresPerHudredKm, int cost, int numberOfSeats,
	             int yearOfManufacture) {
		super(type, model, transmission, litresPerHudredKm, cost, numberOfSeats, yearOfManufacture);
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

package tasks.model;

public class Sedan extends Vehicle {

	public Sedan(String type, String model, String transmission, double litresPerHudredKm, int cost, int numberOfSeats,
	             int yearOfManufacture) {
		super(type, model, transmission, litresPerHudredKm, cost, numberOfSeats, yearOfManufacture);
	}

	@Override
	public void inform() {
		System.out.println(super.type +
				" is defined as a vehicle with four doors that features a traditional trunk design.");
	}

}

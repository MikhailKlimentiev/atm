package tasks.model;

public class Crossover extends Vehicle implements Roomy, Passable {

	public Crossover(String type, String model, String transmission, double litresPerHudredKm, int cost,
	                 int numberOfSeats, int yearOfManufacture) {
		super(type, model, transmission, litresPerHudredKm, cost, numberOfSeats, yearOfManufacture);
	}

	@Override
	public void inform() {
		System.out.println("The idea behind the average" + super.type + "\n" +
				"is simple: Deliver the smooth ride and efficiency of a family sedan \n" +
				"with the high-driving position, cargo capacity and rugged nature of a sport-utility vehicle");
	}

	@Override
	public void setAddedSeats() {
		System.out.println("Number of seats has been increased by 3 places and equals " + (super.numberOfSeats + 3));
	}

	@Override
	public void driveOffRoad() {
		System.out.println("On " + super.getModel() + " you can drive off-road");
	}
}

package tasks.model;

import sun.security.util.Length;

public abstract class Vehicle {

	protected String type;
	protected String model;
	protected String transmission;
	protected double litresPerHudredKm;
	protected int cost;
	protected int numberOfSeats;
	protected int yearOfManufacture;

	public Vehicle(String type, String model, String transmission, double litresPerHudredKm, int cost,
	               int numberOfSeats, int yearOfManufacture) {
		this.type = type;
		this.model = model;
		this.transmission = transmission;
		this.litresPerHudredKm = litresPerHudredKm;
		this.cost = cost;
		this.numberOfSeats = numberOfSeats;
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getLitresPerHudredKm() {
		return litresPerHudredKm;
	}

	public void setLitresPerHudredKm(double litresPerHudredKm) {
		this.litresPerHudredKm = litresPerHudredKm;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public abstract void inform();

	public void drive() {
		System.out.println(getModel() + " which has: " +
				" 1) transmission: " + getTransmission() + ";" +
				" 2) fuel consumption on l/100 km: " + getYearOfManufacture() + ";" +
				" 3) number of seats: " + getNumberOfSeats() + ";" +
				" 4) year of manufacture: " + getYearOfManufacture() + ";");
	}
}

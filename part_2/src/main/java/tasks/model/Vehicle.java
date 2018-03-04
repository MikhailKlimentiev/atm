package tasks.model;

import sun.security.util.Length;

public abstract class Vehicle {

	protected String type;
	protected String model;
	protected String transmission;
	protected double lpk;
	protected int cost;
	protected int numberOfSeats;

	public Vehicle(String type, String model, String transmission, double lpk, int cost, int numberOfSeats) {
		this.type = type;
		this.model = model;
		this.transmission = transmission;
		this.lpk = lpk;
		this.cost = cost;
		this.numberOfSeats = numberOfSeats;
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

	public double getLpk() {
		return lpk;
	}

	public void setLpk(double lpk) {
		this.lpk = lpk;
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

	public abstract void inform();

	public void drive() {
		System.out.println("You drive " + getModel() + "which has: \n" +
				"transmission: " + getTransmission() + "\n" +
				"fuel consumption in l/100 km: " + getLpk() + "\n" +
				"numberOfSeats: " + getNumberOfSeats());
	}
}

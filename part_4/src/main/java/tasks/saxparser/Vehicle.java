package tasks.saxparser;

/**
 * Vehicle.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/09/2018
 */
public abstract class Vehicle {

	protected int id;
	protected String type;
	protected String model;
	protected String transmission;
	protected double litresPerHudredKm;
	protected int cost;
	protected int numberOfSeats;
	protected int yearOfManufacture;
	protected String color;

	public Vehicle(int id, String type, String model, String transmission, double litresPerHudredKm, int cost,
	               int numberOfSeats, int yearOfManufacture, String color) {
		this.id = id;
		this.type = type;
		this.model = model;
		this.transmission = transmission;
		this.litresPerHudredKm = litresPerHudredKm;
		this.cost = cost;
		this.numberOfSeats = numberOfSeats;
		this.yearOfManufacture = yearOfManufacture;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public abstract void inform();

	/**
	 * drive.
	 * drive() method prints values of model, type, transmission, litresPerHudredKm, numberOfSeats,
	 * getYearOfManufacture variables in console
	 */
	public void drive() {
		System.out.println("\"" + getModel() + "\"" + " which has:" +
				" {Type: " + getType() + "}" + "," +
				" {Transmission: " + getTransmission() + "}" + "," +
				" {Fuel consumption on l/100 km: " + getLitresPerHudredKm() + "}" + "," +
				" {Number of seats: " + getNumberOfSeats() + "}" + "," +
				" {Color: " + getColor() + "}" + "," +
				" {Year of manufacture: " + getYearOfManufacture() + "}");
	}
}

package tasks.model;

import sun.security.util.Length;

/**
 * Vehicle.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/09/2018
 */
public abstract class Vehicle {

    protected String type;
    protected String model;
    protected String transmission;
    protected double litresPerHudredKm;
    protected int cost;
    protected int numberOfSeats;
    protected int yearOfManufacture;

    public Vehicle(String type, String model, String transmission, double litresPerHudredKm, int cost,
                   int numberOfSeats, int yearOfManufacture
    ) {
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

    /**
     * drive.
     * drive() method prints values of model, type, transmission, litresPerHudredKm, numberOfSeats,
     * getYearOfManufacture variables in console
     */
    public void drive() {
        System.out.println("\"" + getModel() + "\"" + " which has:" +
                " {Type: " + getType() + "}" +
                " {Transmission: " + getTransmission() + "}" +
                " {Fuel consumption on l/100 km: " + getLitresPerHudredKm() + "}" +
                " {Number of seats: " + getNumberOfSeats() + "}" +
                " {Year of manufacture: " + getYearOfManufacture() + "}");
    }
}

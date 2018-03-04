package tasks.model;

public class Sedan extends Vehicle {

	public Sedan(String type, String model, String transmission, double lpk, int cost, int numberOfSeats) {
		super("Sedan", model, transmission, lpk, cost, numberOfSeats);
	}

	@Override
	public void inform() {
		System.out.println(this.type +
				" is defined as a vehicle with four doors that features a traditional trunk design.");
	}

}

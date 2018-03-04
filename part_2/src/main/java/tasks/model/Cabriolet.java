package tasks.model;

public class Cabriolet extends Vehicle implements Modifiable {

	public boolean topRaised = true;

	public Cabriolet(String type, String model, String transmission, double lpk, int cost, int numberOfSeats, boolean topRaised) {
		super(type, model, transmission, lpk, cost, numberOfSeats);
		this.topRaised = topRaised;
	}

	@Override
	public void inform() {
		System.out.println("About" + super.type + ":\n" +
			" First and foremost, convertibles are about fun in the sun. As such, you can expect to make certain \n" +
			"compromises in terms of practicality. Power-hardtop convertibles have particularly small trunks \n" +
			"because the folded roof takes up a lot of space. As a general rule, convertibles just aren't very \n" +
			"good at hauling cargo. They also tend to have either cramped backseats or none at all, \n" +
			"and visibility suffers with the top up relative to comparable vehicles with fixed roofs.");
	}

	@Override
	public void liftTop() {
		if (this.topRaised = false) {
			this.topRaised = true;
			System.out.println("Top is raised");
		} else {
			System.out.println("Top is already raised");
		}
	}

	@Override
	public void lowerTop() {
		if (this.topRaised = true) {
			this.topRaised = false;
			System.out.println("Top is lowered");
		} else {
			System.out.println("Top is already lowered");
		}

	}
}
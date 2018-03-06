package tasks.model;

import java.util.Comparator;

public class FuelConsumptionComparator implements Comparator<Vehicle> {

	@Override
	public int  compare(Vehicle o1, Vehicle o2) {
		Double lpk1 = o1.getLitresPerHudredKm();
		Double lpk2 = o2.getLitresPerHudredKm();
		return lpk1.compareTo(lpk2);
	}
}

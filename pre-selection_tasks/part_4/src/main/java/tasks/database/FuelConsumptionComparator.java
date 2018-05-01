package tasks.database;

import java.util.Comparator;

/**
 * FuelConsumptionComparator.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/09/2018
 */
public class FuelConsumptionComparator implements Comparator<Vehicle> {

    /**
     * compare.
     * compare() method overrides compare() method from the Comparator interface and compares objects in a collection
     * by fuel consumption.
     *
     * @param o1
     * @param o2
     * @return It returns a positive value if obj1 is greater than obj2. Otherwise, a negative value is returned.
     * It returns zero if the objects are equal.
     */
    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        Double lpk1 = o1.getLitresPerHudredKm();
        Double lpk2 = o2.getLitresPerHudredKm();
        return lpk1.compareTo(lpk2);
    }
}


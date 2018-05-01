package tasks.streams;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cabriolet.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 03/11/2018
 */
public class Cabriolet extends Vehicle implements Modifiable {

    private static final String TYPE = "Cabriolet";
    public boolean topRaised;

    public Cabriolet(int id, String type, String model, String transmission, double litresPerHudredKm, int cost,
                     int numberOfSeats, int yearOfManufacture, String color, boolean topRaised
    )
            throws InvalidCarTypeException, InvalidTransmissionTypeException {
        super(id, type, model, transmission, litresPerHudredKm, cost, numberOfSeats, yearOfManufacture, color);
        this.topRaised = topRaised;
        if (!this.TYPE.equalsIgnoreCase(type)) {
            throw new InvalidCarTypeException("Cabriolet");
        }
        if (!(transmission.equalsIgnoreCase("Automatic") || transmission.equalsIgnoreCase("Manual"))) {
            throw new InvalidTransmissionTypeException("Cabriolet");
        }
    }

    /**
     * inform.
     * inform() method overrides abstract method from Vehicle class and prints information what cabriolet is in console
     */
    @Override
    public void inform() {
        System.out.println("About " + super.type + ":\n" +
                "First and foremost, convertibles are about fun in the sun. As such, you can expect to make certain \n" +
                "compromises in terms of practicality. Power-hardtop convertibles have particularly small trunks \n" +
                "because the folded roof takes up a lot of space. As a general rule, convertibles just aren't very \n" +
                "good at hauling cargo. They also tend to have either cramped backseats or none at all, \n" +
                "and visibility suffers with the top up relative to comparable vehicles with fixed roofs.");
    }

    /**
     * liftRoof.
     * liftRoof() method overrides abstract method from Modifiable interface,
     * checks and changes value of topRaised variable
     *
     * @param scan
     */
    @Override
    public void liftRoof(Scanner scan) {

        boolean correctMenuInput = true;

        try {
            if (topRaised == true) {
                throw new ImpossibilityChangingRoofStateException("Roof is already raised");
            }
            System.out.print("\nDo you want to raise the roof? Please input a number below:\n1. Yes\n2. No\n3. Exit\nAnswer: ");
            while (correctMenuInput) {
                try {
                    correctMenuInput = false;
                    int answer = scan.nextInt();
                    if (answer != 1 && answer != 2 && answer != 3) {
                        throw new MenuSymbolInputException("Lift Roof");
                    }
                    switch (answer) {
                        case 1: {
                            topRaised = true;
                            System.out.println("Roof state: raised");
                            break;
                        }
                        case 2: {
                            System.out.println("Roof state: lowered");
                            break;
                        }
                        case 3: {
                            break;
                        }
                    }
                } catch (MenuSymbolInputException msie) {
                    correctMenuInput = true;
                    msie.warn();
                } catch (InputMismatchException ime) {
                    correctMenuInput = true;
                    System.err.println("Invalid Input. Instead String please input a number from the list");
                    scan.next();
                }
            }
        } catch (ImpossibilityChangingRoofStateException icrse) {
            System.err.print("You cannot raise the roof because the roof is already raised");
        }
    }

    /**
     * lowerRoof.
     * lowerRoof() method overrides abstract method from Modifiable interface,
     * checks and changes value of topRaised variable
     *
     * @param scan
     */
    @Override
    public void lowerRoof(Scanner scan) {

        boolean correctMenuInput = true;
        try {
            if (topRaised == false) {
                throw new ImpossibilityChangingRoofStateException("Roof is already lowered");
            }
            System.out.print("\nDo you want to lower the roof? Please input a number below:\n1. Yes\n2. No\n3. Exit\nAnswer: ");
            while (correctMenuInput) {
                try {
                    correctMenuInput = false;
                    int answer = scan.nextInt();
                    if (answer != 1 && answer != 2 && answer != 3) {
                        throw new MenuSymbolInputException("Lower Roof");
                    }
                    switch (answer) {
                        case 1: {
                            topRaised = false;
                            System.out.println("Roof state: lowered");
                            break;
                        }
                        case 2: {
                            System.out.println("Roof state: raised");
                            break;
                        }
                        case 3: {
                            break;
                        }
                    }
                } catch (MenuSymbolInputException msie) {
                    correctMenuInput = true;
                    msie.warn();
                } catch (InputMismatchException ime) {
                    correctMenuInput = true;
                    System.err.println("Invalid Input. Instead String please input a number from the list");
                    scan.next();
                }
            }
        } catch (ImpossibilityChangingRoofStateException icrse) {
            System.err.print("You cannot lower the roof because the roof is already lowered");
        }
    }
}
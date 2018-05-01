package tasks.model;

import java.util.Scanner;

/**
 * Cabriolet.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/09/2018
 */
public class Cabriolet extends Vehicle implements Modifiable {

    public boolean topRaised;

    public Cabriolet(String type, String model, String transmission, double litresPerHudredKm, int cost,
                     int numberOfSeats, int yearOfManufacture, boolean topRaised
    ) {
        super(type, model, transmission, litresPerHudredKm, cost, numberOfSeats, yearOfManufacture);
        this.topRaised = topRaised;
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
        boolean condition = true;
        if (topRaised == true) {
            System.out.print("Do you want to raise the roof?\nRoof is already raised");
            condition = false;
        }
        while (condition) {
            System.out.print("\nDo you want to raise the roof? Please input a number below:\n1. Yes\n2. No\n3. Exit\nAnswer: ");
            int answer = scan.nextInt();
            if (answer == 3) {
                return;
            } else if (topRaised == true) {
                System.out.print("Roof is already raised");
                break;
            } else if (answer == 1) {
                topRaised = true;
                System.out.println("Roof state: raised");
            } else if (answer == 2) {
                System.out.println("Roof state: lowered");
            }
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
        boolean condition = true;
        if (topRaised == false) {
            System.out.print("Do you want to lower the roof?\nRoof is already lowered");
            condition = false;
        }
        while (condition) {
            System.out.print("\nDo you want to lower the roof? Please input a number below:\n1. Yes\n2. No\n3. Exit\nAnswer: ");
            int answer = scan.nextInt();
            if (answer == 3) {
                return;
            } else if (topRaised == false) {
                System.out.print("Roof is already lowered");
                break;
            } else if (answer == 1) {
                topRaised = false;
                System.out.println("Roof state: lowered");
            } else if (answer == 2) {
                System.out.println("Roof state: raised");
            }
        }
    }
}
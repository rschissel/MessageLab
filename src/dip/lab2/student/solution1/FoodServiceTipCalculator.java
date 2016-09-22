package dip.lab2.student.solution1;

import dip.lab2.*;
import java.util.Scanner;

/**
 * An example low-level class. Does this class definition follow the DIP? If
 * not, fix it.
 *
 * Any other best practice violations? Fix them too.
 *
 * @author your name goes here
 */
public class FoodServiceTipCalculator implements Calculator {

    private static final double MIN_BILL = 0.00;
    private static final String BILL_ENTRY_ERR
            = "Error: bill must be greater than or equal to " + MIN_BILL;
    private double goodRate = 0.20;
    private double fairRate = 0.15;
    private double poorRate = 0.10;

    
    private double billBeforeTip;

    private ServiceQuality serviceQuality;

    private String calcName = "Food Service";

    public FoodServiceTipCalculator(double billBeforeTip) {
        this.setBillBeforeTip(billBeforeTip);
    }

    public FoodServiceTipCalculator() {

    }

    @Override
    public double getTip() {
        double tip = 0.00; // always initialize local variables

        switch (serviceQuality) {
            case GOOD:
                tip = billBeforeTip * goodRate;
                break;
            case FAIR:
                tip = billBeforeTip * fairRate;
                break;
            case POOR:
                tip = billBeforeTip * poorRate;
                break;
        }

        return tip;
    }

    @Override
    public void setBillBeforeTip(double billBeforeTip) {
        if (billBeforeTip < MIN_BILL) {
            throw new IllegalArgumentException(BILL_ENTRY_ERR);
        }
        this.billBeforeTip = billBeforeTip;
    }

    @Override
    public void setServiceRating(ServiceQuality q) {
        // No need to validate because enums provide type safety!
        serviceQuality = q;
    }

    @Override
    public ServiceQuality getServiceQuality() {
        return serviceQuality;
    }

    @Override
    public String getCalcName() {
        return calcName;
    }

    @Override
    public String getFinalBill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The final ");
        sb.append(this.getCalcName());
        sb.append(" bill is: ");
        sb.append(this.getTip());
        return sb.toString();
    }

    @Override
    public void enterBillingInfo() {
        Scanner kybd = new Scanner(System.in);
        String input;
        System.out.print("Enter " + this.getCalcName() + " rating(good/fair/poor): ");
        input = kybd.nextLine();
        this.setServiceRating(ServiceQuality.valueOf(input.toUpperCase()));
        System.out.print("Enter bill before tip: ");
        input = kybd.nextLine();
        this.setBillBeforeTip(Double.parseDouble(input));
    }

}

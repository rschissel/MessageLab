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
public class BaggageServiceTipCalculator implements Calculator {

    private static final double MIN_BILL = 0.00;
    private static final double MAX_BILL = 100.00;
    private static final String BILL_ENTRY_ERR
            = "Error: bill must be between " + MIN_BILL + " and "
            + MAX_BILL;
    private double goodRate = 0.20;
    private double fairRate = 0.15;
    private double poorRate = 0.10;

    private double billBeforeTip;
    private int bagCount;

    private ServiceQuality serviceQuality;
    private String calcName = "Baggage Service";

    public BaggageServiceTipCalculator(double billBeforeTip, int bags) {
        this.setBillBeforeTip(billBeforeTip); // perform validation
        this.setBagCount(bags);
    }

    public BaggageServiceTipCalculator() {

    }

    @Override
    public final double getTip() {
        double tip = 0.00; // always initialize local variables

        switch (serviceQuality) {
            case GOOD:
                tip = billBeforeTip * bagCount * (1 + goodRate);
                break;
            case FAIR:
                tip = billBeforeTip * bagCount * (1 + fairRate);
                break;
            case POOR:
                tip = billBeforeTip * bagCount * (1 + poorRate);
                break;
            
        }

        return tip;
    }

    public final void setServiceRating(ServiceQuality q) {
        // No need to validate because enums provide type safety!
        serviceQuality = q;
    }

    public final ServiceQuality getServiceQuality() {
        return serviceQuality;
    }

    public final int getBagCount() {
        return bagCount;
    }

    public final void setBagCount(int bagCount) {
        if (bagCount < 0) {
            throw new IllegalArgumentException(
                    "bag count must be greater than or equal to zero");
        }
        this.bagCount = bagCount;
    }

    public final double getBaseTipPerBag() {
        return billBeforeTip;
    }

    public final void setBillBeforeTip(double billBeforeTip) {
        if (billBeforeTip < 0) {
            throw new IllegalArgumentException(
                    BILL_ENTRY_ERR);
        }
        this.billBeforeTip = billBeforeTip;
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
        System.out.print("Enter number of bags: ");
        input = kybd.nextLine();
        this.setBagCount(Integer.parseInt(input));
    }
}

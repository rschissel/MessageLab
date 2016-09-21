/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab2.student.solution1;

/**
 *
 * @author Ryan Schissel
 */
public interface Calculator {

    public abstract ServiceQuality getServiceQuality();

    public abstract double getTip();

    public abstract void setBillBeforeTip(double billBeforeTip);

    public abstract void setServiceRating(ServiceQuality q);

    public abstract String getCalcName();

    public abstract void enterBillingInfo();

    public abstract String getFinalBill();

}

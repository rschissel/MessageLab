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
public class TipCalculatorManager {
    private TipCalculator tipCalculator;

    public TipCalculatorManager(TipCalculator tipCalculator) {
        this.tipCalculator = tipCalculator;
    }
    public double getTip(){
        return tipCalculator.getTip();
    }
}

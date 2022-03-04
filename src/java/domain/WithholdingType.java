/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import DataAccess.WithholdingTypeDA;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author stoke
 */
public class WithholdingType {
    private int withholdingID;
    private String description;
    private double amount;
    private double rate;

    public int getWithholdingID() {
        return withholdingID;
    }

    public void setWithholdingID(int withholdingID) {
        this.withholdingID = withholdingID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
     public static ArrayList<WithholdingType> getWithholdingTypes(){
        return WithholdingTypeDA.getWithholdingTypes();
    }

    public static double calculateWithholding(double grossPay){
        return WithholdingTypeDA.calculateWithholding(grossPay);
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String amount = formatter.format(this.amount);
        return "Withholding ID: " + withholdingID + ", Description: " + description + ", Amount: " + amount + ", Rate: " + rate;
    }
}

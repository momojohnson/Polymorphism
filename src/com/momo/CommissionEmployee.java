package com.momo;

import java.time.LocalDate;

/**
 * Created by Momo Johnson on 12/20/2017.
 */
public class CommissionEmployee extends Employee {
    private double grossSales; // gross sales
    private double commissionRate; // Commission rate

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                              double grossSales, double commissionRate, LocalDate birthDate)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate);
        // Set the gross sales and if the gross sales is invalid, throw an exception
        if(grossSales < 0){
            throw new IllegalArgumentException("Gross sales must be >= 0");
        }

        // Set the commission rate and if the commission rate is invalid, throw an exception
        if(commissionRate < 0 || commissionRate > 1){
            throw new IllegalArgumentException("Commisson rate must be > 0 or <= 1");

        }
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }
    // returns the gross sales
    public double getGrossSales() {
        return grossSales;
    }

    // Sets the gross sales and if the gross sales is invalid, throw and exception
    public void setGrossSales(double grossSales) {
        if(grossSales < 0){
            throw new IllegalArgumentException("Gross sales must be >= 0");
        }
        this.grossSales = grossSales;
    }
    // returns the commission rate
    public double getCommissionRate() {
        return commissionRate;
    }

    // Set the commission rate and if the commission rate is invalid, throw and exception
    public void setCommissionRate(double commissionRate) {
        if(commissionRate < 0 || commissionRate > 1){
            throw new IllegalArgumentException("Commission rate must be > 0 or <= 1");
        }
        this.commissionRate = commissionRate;
    }

    @Override
    //Returns this employee earnings. If it's the employee birthday add 100.00 as bonus
    public double getPaymentAmount() {
        if(super.getCurrentMonth() == getBirthMonth()){
            return (getGrossSales() * getCommissionRate())+100.00;
        }
        return getGrossSales() * getCommissionRate();
    }

    @Override
    //Return the formatted string containing the employee information
    public String toString() {
        return String.format("%s %s%n%s: %,.2f%n%s: %,.2f%n%s: %,.2f",
                "commission employee:", super.toString(),
                "Gross sales", getGrossSales(),
                "Commission rate", getCommissionRate(),
                "Earnings", getPaymentAmount());
    }
}

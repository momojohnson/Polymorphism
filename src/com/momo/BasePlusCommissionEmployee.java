package com.momo;

import java.time.LocalDate;

/**
 * Created by Momo Johnson on 12/20/2017.
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                      double grossSales, double commissionRate, double baseSalary,
                                      LocalDate birthDate)
    {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate, birthDate);
        // Set the base and if base salary is invalid, throw an exception
        if(baseSalary < 0){
            throw new IllegalArgumentException("Base salary must >= 0");
        }
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Set the base salary and if the base salary is invalid, throw an exception
    public void setBaseSalary(double baseSalary) {
        if(baseSalary < 0){
            throw new IllegalArgumentException("Base salary must be >= 0");
        }
        this.baseSalary = baseSalary;
    }

    @Override
    //Returns this employee earnings. If it's the employee birthday add 100.00 as bonus
    public double getPaymentAmount() {
        if(getCurrentMonth() == getBirthMonth()){
            return super.getPaymentAmount() + baseSalary + 100.00;
        }
        return super.getPaymentAmount() + baseSalary;
    }

    @Override
    //Return the formatted string containing the employee information
    public String toString() {
        return String.format("%s %s", "base-salary", super.toString());
    }
}


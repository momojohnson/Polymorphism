package com.momo;

import java.time.LocalDate;

/**
 * Created by Momo Johnson on 12/20/2017.
 */
public class SalariedEmployee extends Employee {
    private double weeklySalary;


    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber,
                            double weeklySalary, LocalDate birthDate)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate);
        if(weeklySalary < 0){
            throw new IllegalArgumentException("Weekly salary must be >= 0");
        }
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        if(weeklySalary < 0){
            throw  new IllegalArgumentException("Weekly salary must be >= 0");
        }
        this.weeklySalary = weeklySalary;
    }

    @Override
    //Returns this employee earnings. If it's the employee birthday add 100.00 as bonus
    public double getPaymentAmount() {
        if(getCurrentMonth() == getBirthMonth()){
            return getWeeklySalary() + 100.00;
        }
        return getWeeklySalary();
    }

    @Override
    //Return the formatted string containing the employee information
    public String toString() {
        return String.format("Salaried Employee: %s%n%s: %.2f", super.toString(),
                "Earnings", getPaymentAmount());

    }
}

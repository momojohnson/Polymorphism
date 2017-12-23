package com.momo;

import java.time.LocalDate;

/**
 * Created by Momo Johnson on 12/20/2017.
 */
public class HourlyEmployee extends Employee {
    private double wage; // Wage
    private double hour; // hours

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber,
                          double wage, double hour, LocalDate birthDate)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate);
        if(wage < 0 ){
            throw new IllegalArgumentException("Wage must be >= 0");
        }
        this.wage = wage;

        if(hour <0 || hour > 168){
            throw new IllegalArgumentException("Hours must be > 0 or <= 168");
        }
        this.hour = hour;
    }
    // return the wage
    public double getWage() {

        return wage;
    }
    // sets the wage. If wage is invalid, throw an exception
    public void setWage(double wage) {
        if(wage < 0){
            throw new IllegalArgumentException("Wage must be >= 0");
        }
        this.wage = wage;
    }

    // returns hour
    public double getHour() {
        return hour;
    }
    // set hours. If hour is invalid throw an exception
    public void setHour(double hour) {
        if(hour <0 || hour > 168){
            throw new IllegalArgumentException("Hours must be > 0 or <= 168");
        }
        this.hour = hour;
    }

    @Override
    //Returns this employee earnings. If it's the employee birthday add 100.00 as bonus
    public double getPaymentAmount() {
        double totalPay;
        if(hour <= 40){
            totalPay = hour * wage;
        }else {
            totalPay = (hour-40)*(wage*1.5)+(40*wage);
        }
        if(getCurrentMonth() == getBirthMonth()){
            return totalPay + 100.00;
        }

        return totalPay;
    }

    @Override
    //Return the formatted string containing the employee information
    public String toString() {
        return String.format("Hourly Employee: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f", super.toString(),
                "Hours work", getHour(),
                "Wage", getWage(),
                "Earnings", getPaymentAmount());
    }
}

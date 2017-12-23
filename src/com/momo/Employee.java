package com.momo;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by Momo Johnson on 12/20/2017.
 */
public abstract class Employee implements Payable {
    private final String firstName; // Employee first name
    private final String lastName; // Employee last name
    private final String socialSecurityNumber; // Employee social security number
    private LocalDate birthDate; // Employee date of birth
    private LocalDate currentMonth = LocalDate.now(); // A variable that that use to get current month

    public Employee(String firstName, String lastName, String socialSecurityNumber, LocalDate birthDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.birthDate = birthDate;
    }
    // return first name
    public String getFirstName() {
        return firstName;
    }
    // Returns the month of the employee to determine bonus on pay day
    public Month getBirthMonth(){
        return birthDate.getMonth();
    }

    // return the current month to determine if employee is eligible for birthday bonus
    public Month getCurrentMonth() {
        return this.currentMonth.getMonth();
    }

    // return last name
    public String getLastName() {
        return lastName;
    }
    // return social security number
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    // return string format of first name, last name and social security number
    @Override
    public String toString() {
        return String.format("%s %s%n%s: %s", getFirstName(),
                getLastName(),
                "Social Security Number",getSocialSecurityNumber());
    }
}

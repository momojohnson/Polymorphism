package com.momo;

import java.time.LocalDate;

/**
 * Created by Momo Johnson on 12/22/2017.
 */
public class PieceWorker extends Employee implements Payable{
    private double wage; //Wage for this employee
    private int pieces; // Pieces made by this employee

    public PieceWorker(String firstName, String lastName, String socialSecurityNumber,
                       double wage, int pieces, LocalDate birthDate)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate);
        // if wage is invalid, throw an exception
        if(wage < 0){
            throw new IllegalArgumentException("Wage must be >= 0");
        }
        //If pieces is invalid, throw an exception
        if(pieces < 0){
            throw new IllegalArgumentException("pieces made must be >=0 ");
        }
        this.wage = wage;
        this.pieces = pieces;
    }

    // Return the wage
    public double getWage() {
        return wage;
    }
    // Return the pieces
    public int getPieces() {
        return pieces;
    }
    // Set the wage amount
    public void setWage(double wage) {
        if(wage < 0)
        {
            throw new IllegalArgumentException("Wage must be >= 0");
        }
        this.wage = wage;
    }
    // Set the number of pieces
    public void setPieces(int pieces) {
        if(pieces < 0){
            throw new IllegalArgumentException("Pieces must be >= 0");
        }
        this.pieces = pieces;
    }
    // Returns this employee earnings. If it's the employee birthday add 100.00 as bonus
    @Override
    public double getPaymentAmount() {
        if(getCurrentMonth() == getBirthMonth()){
            return (getWage() *getPieces())+ 100.0;
        }
        return getWage() * getPieces();
    }
    // //Return the formatted string containing the employee information
    @Override
    public String toString() {
        return String.format("Piece Worker: %s%n%s: %.2f%n%s: %d%n%s: %.2f", super.toString(),
                "Wage",  getWage(),
                "Pieces made", getPieces(),
                "Earnings", getPaymentAmount() );
    }
}

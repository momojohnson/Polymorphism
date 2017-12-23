package com.momo;

/**
 * Created by Momo Johnson on 12/20/2017.
 */
public class Invoice implements Payable {
    private final String partNumber; // part number
    private final String description; // description
    private int quantity; // qualities
    private double price; // price

    public Invoice(String partNumber, String description, int quantity, double price)
    {
        this.partNumber = partNumber;
        this.description = description;
        // If quantity is invalid throw and exception
        if(quantity < 0){
            throw new IllegalArgumentException("Quantity must be >= 0");
        }
        // If price is invalid, throw an exception
        if(price <= 0){
            throw new IllegalArgumentException("Price must be > 0");
        }
        this.quantity = quantity;
        this.price = price;
    }
    // return partnumber
    public String getPartNumber() {
        return partNumber;
    }

    // return description
    public String getDescription() {
        return description;
    }

    // return quantities amount
    public int getQuantity() {
        return quantity;
    }

    // Sets quantities and if the quantities is invalid, throw an exception
    public void setQuantity(int quantity) {
        if(quantity < 0){
            throw new IllegalArgumentException("Quantity must be >= 0");
        }
        this.quantity = quantity;
    }

    // return the price
    public double getPrice() {
        return price;
    }

    // Set the price and if the price is invalid, throw and exception
    public void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException("Price must be > 0");
        }
        this.price = price;
    }

    @Override
    // Returns the payment for the invoice amount
    public double getPaymentAmount() {
        return getPrice() * getQuantity();
    }

    @Override
    public String toString() {
        return String.format("Invoice Summary%n%s: %s%n%s: %s%n%s: %d%n%s: %.2f%n%s: %.2f",
                "Part number", getPartNumber(),
                "Description", getPaymentAmount(),
                "Quantity", getQuantity(),
                "Price", getPrice(),
                "Total", getPaymentAmount());
    }
}

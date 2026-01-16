package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//Giving the Transactions objects it's attributes
public class Transactions {
    private LocalDate transactionDate;
    private LocalTime transactionTime;
    private String description;
    private String vendor;
    private Double amount;

    //All getters for the Transaction object
    public Transactions(LocalDate paymentDate, LocalTime paymentTime, String description, String vendor, Double amount) {
        this.transactionDate = paymentDate;
        this.transactionTime = paymentTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return transactionDate;
    }

    public LocalTime getTime() {
        return transactionTime;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public Double getAmount() {
        return amount;
    }

    // calculating manually to center a text for the user
    private String centerText(String text, int width) {

        int spaces = width - text.length();
        int left = spaces / 2;
        int right = spaces - left;

        String result = ""; // empty box

        for (int i = 0; i < left; i++) {
            result += " ";
        }
        result += text;

        for (int i = 0; i < right; i++) {
            result += " ";
        }
        return result;
    }

    // Should format how to display the transaction into the console.log
    @Override
    public String toString() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = transactionTime.format(timeFormatter);

        String formattedAmount = String.format("$%.2f", amount);

        return centerText(transactionDate.toString(), 14) + "|" +
                centerText(formattedTime, 12) + "|" +
                centerText(description, 28) + "|" +
                centerText(vendor, 25) + "|" +
                centerText(formattedAmount, 12) + "|";
    }
}
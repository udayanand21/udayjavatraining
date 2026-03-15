package com.coforge.assignment;

import java.time.LocalDateTime;

public class Pay {
    double amount;
    LocalDateTime dateTime;

    public Pay(double amount) {
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public void pay() {
        System.out.println("Payment of amount " + amount + " started.");
    }

    public void receipt() {
        System.out.println("----- RECEIPT -----");
        System.out.println("Amount : " + amount);
        System.out.println("Date   : " + dateTime);
        System.out.println("-------------------");
    }
}
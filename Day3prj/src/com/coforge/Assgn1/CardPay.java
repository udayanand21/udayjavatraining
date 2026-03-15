package com.coforge.Assgn1;


import java.time.LocalDateTime;

public class CardPay implements PayInterface {
    double amount;
    String cardNumber;
    LocalDateTime dateTime;

    public CardPay(double amount, String cardNumber) {
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public void pay() {
        System.out.println("Processing Card payment using card " + cardNumber + " for amount " + amount);
    }

    @Override
    public void receipt() {
        System.out.println("----- CARD RECEIPT ----");
        System.out.println("Amount : " + amount);
        System.out.println("Card   : " + cardNumber);
        System.out.println("Date   : " + dateTime);
        System.out.println("-----------------------");
    }
}
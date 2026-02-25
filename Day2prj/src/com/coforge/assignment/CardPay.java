package com.coforge.assignment;

public class CardPay extends Pay {
    String cardNumber;

    public CardPay(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay() {
        System.out.println("Processing Card payment using card " + cardNumber + " for amount " + amount);
    }

    @Override
    public void receipt() {
        super.receipt();
        System.out.println("Card No : " + cardNumber);
    }
}
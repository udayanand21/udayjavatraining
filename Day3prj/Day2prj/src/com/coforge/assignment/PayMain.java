package com.coforge.assignment;

public class PayMain {
    public static void main(String[] args) {

        UpiPay upi = new UpiPay(500, "uday@upi");
        upi.pay();
        upi.receipt();

        System.out.println();

        CardPay card = new CardPay(1200, "1234-5678-9000");
        card.pay();
        card.receipt();
    }
}
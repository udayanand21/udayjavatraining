package com.coforge.Assgn1;



import java.time.LocalDateTime;

public class WalletPay implements PayInterface {
    double amount;
    String walletId;       
    LocalDateTime dateTime;

    public WalletPay(double amount, String walletId) {
        this.amount = amount;
        this.walletId = walletId;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public void pay() {
        System.out.println("Processing Wallet payment from " + walletId + " for amount " + amount);
    }

    @Override
    public void receipt() {
        System.out.println("---- WALLET RECEIPT ---");
        System.out.println("Amount  : " + amount);
        System.out.println("Wallet  : " + walletId);
        System.out.println("Date    : " + dateTime);
        System.out.println("-----------------------");
    }
}

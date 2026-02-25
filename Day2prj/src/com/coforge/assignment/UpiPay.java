package com.coforge.assignment;

public class UpiPay extends Pay {
    String upiId;

    public UpiPay(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    public void pay() {
        System.out.println("Processing UPI payment via " + upiId + " for amount " + amount);
    }

    @Override
    public void receipt() {
        super.receipt();
        System.out.println("UPI ID : " + upiId);
    }
}
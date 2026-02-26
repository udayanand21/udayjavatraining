package com.coforge.Assgn1;


import java.time.LocalDateTime;

public class UpiPay implements PayInterface {
    double amount;
    String upiId;
    LocalDateTime dateTime;

    public UpiPay() {
		super();
	}


	public UpiPay(double amount, String upiId) {
        this.amount = amount;
        this.upiId = upiId;
        this.dateTime = LocalDateTime.now();
    }

   
    public void pay() {
        System.out.println("Processing UPI payment via " + upiId + " for amount " + amount);
    }

    
    public void receipt() {
        System.out.println("----- UPI RECEIPT -----");
        System.out.println("Amount : " + amount);
        System.out.println("UPI ID : " + upiId);
        System.out.println("Date   : " + dateTime);
        System.out.println("-----------------------");
    }
}
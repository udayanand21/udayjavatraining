package com.coforge.Assgn1;

import java.util.Scanner;

public class PayMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String again;

        do {
            System.out.println("=== Payment Menu ===");
            System.out.println("1. UPI");
            System.out.println("2. Card");
            System.out.println("3. Wallet");
           
            System.out.print("Enter option (1/2/3): ");

            int option = sc.nextInt();

            PayInterface payment=null;;

            switch (option) {
                case 1:
                    System.out.print("Enter amount: ");
                    double upiAmount = sc.nextDouble();
                    System.out.print("Enter UPI ID (e.g., name@bank): ");
                    String upiId = sc.next();
                    payment = new UpiPay(upiAmount, upiId);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double cardAmount = sc.nextDouble();
                    System.out.print("Enter card number: ");
                    String cardNumber = sc.next();
                    payment = new CardPay(cardAmount, cardNumber);
                    break;

                case 3:
                    System.out.print("Enter amount: ");
                    double walletAmount = sc.nextDouble();
                    System.out.print("Enter wallet ID (mobile/email): ");
                    String walletId = sc.next();
                    payment = new WalletPay(walletAmount, walletId);
                    break;

                
                default:
                    System.out.println("Invalid option. Please try again.");
                    // Skip processing and go to continue prompt
            }

            if (payment != null) {
                payment.pay();
                payment.receipt();
            }

            System.out.print("Do you want to make another payment? (y/n): ");
            again = sc.next();

        } while (again.equalsIgnoreCase("y"));

        System.out.println("Thank you! Session ended.");
        sc.close();
    }
}
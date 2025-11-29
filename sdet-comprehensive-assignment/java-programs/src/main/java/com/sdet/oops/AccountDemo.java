package com.sdet.oops;

/**
 * Demo class to demonstrate Java OOPs concepts with Account hierarchy
 */
public class AccountDemo {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Java OOPs - Account Management System");
        System.out.println("========================================");

        // Create a Savings Account
        SavingsAccount savingsAccount = new SavingsAccount(
            "SA001", 
            "John Doe", 
            5000.00, 
            4.5, 
            1000.00
        );

        savingsAccount.displayAccountInfo();
        savingsAccount.addInterestToAccount();

        // Create a Current Account
        CurrentAccount currentAccount = new CurrentAccount(
            "CA001", 
            "Jane Smith", 
            3000.00, 
            2.0, 
            5000.00
        );

        currentAccount.displayAccountInfo();
        currentAccount.addInterestToAccount();
        
        // Process some transactions on current account
        System.out.println("\n--- Processing Transactions ---");
        currentAccount.processTransaction(1000.00);  // Deposit
        currentAccount.processTransaction(-500.00);  // Withdrawal
        currentAccount.displayAccountInfo();

        // Create a Savings Account with low balance
        System.out.println("\n\n========================================");
        System.out.println("Testing with Low Balance");
        System.out.println("========================================");
        
        SavingsAccount lowBalanceSavings = new SavingsAccount(
            "SA002", 
            "Bob Johnson", 
            500.00, 
            4.5, 
            1000.00
        );

        lowBalanceSavings.displayAccountInfo();
        lowBalanceSavings.addInterestToAccount();

        System.out.println("\n========================================");
        System.out.println("Demo completed successfully!");
        System.out.println("========================================");
    }
}

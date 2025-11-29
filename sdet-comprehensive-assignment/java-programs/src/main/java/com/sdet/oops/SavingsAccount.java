package com.sdet.oops;

/**
 * SavingsAccount class extending Account with specific interest calculation
 */
public class SavingsAccount extends Account {
    private double minimumBalance;

    /**
     * Constructor for SavingsAccount
     */
    public SavingsAccount(String accountNumber, String accountHolder, double balance, 
                          double interestRate, double minimumBalance) {
        super(accountNumber, accountHolder, balance, interestRate);
        this.minimumBalance = minimumBalance;
    }

    /**
     * Overridden method to calculate interest for savings account
     * Higher interest rate if balance is above minimum
     */
    @Override
    public double calculateInterest() {
        if (balance >= minimumBalance) {
            // Higher interest for maintaining minimum balance
            return balance * interestRate / 100;
        } else {
            // Reduced interest if below minimum balance
            return balance * (interestRate * 0.5) / 100;
        }
    }

    /**
     * Overridden method to add interest with savings account specific logic
     */
    @Override
    public void addInterestToAccount() {
        double interest = calculateInterest();
        balance += interest;
        System.out.println("\n--- Savings Account Interest Calculation ---");
        System.out.println("Interest added: $" + String.format("%.2f", interest));
        if (balance < minimumBalance) {
            System.out.println("Warning: Balance below minimum ($" + minimumBalance + "). Interest rate reduced.");
        }
        System.out.println("New balance: $" + String.format("%.2f", balance));
    }

    /**
     * Overridden display method for savings account
     */
    @Override
    public void displayAccountInfo() {
        System.out.println("\n=== Savings Account Information ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Minimum Balance: $" + String.format("%.2f", minimumBalance));
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}

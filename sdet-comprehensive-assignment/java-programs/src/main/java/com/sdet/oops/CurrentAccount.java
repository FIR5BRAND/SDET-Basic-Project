package com.sdet.oops;

/**
 * CurrentAccount class extending Account with specific interest calculation
 */
public class CurrentAccount extends Account {
    private double overdraftLimit;
    private int transactionCount;

    /**
     * Constructor for CurrentAccount
     */
    public CurrentAccount(String accountNumber, String accountHolder, double balance, 
                          double interestRate, double overdraftLimit) {
        super(accountNumber, accountHolder, balance, interestRate);
        this.overdraftLimit = overdraftLimit;
        this.transactionCount = 0;
    }

    /**
     * Overridden method to calculate interest for current account
     * Lower interest rate as current accounts are primarily for transactions
     */
    @Override
    public double calculateInterest() {
        // Current accounts typically have lower interest rates
        // Interest only calculated on positive balance
        if (balance > 0) {
            return balance * interestRate / 100;
        } else {
            return 0.0;
        }
    }

    /**
     * Overridden method to add interest with current account specific logic
     */
    @Override
    public void addInterestToAccount() {
        double interest = calculateInterest();
        if (interest > 0) {
            balance += interest;
            System.out.println("\n--- Current Account Interest Calculation ---");
            System.out.println("Interest added: $" + String.format("%.2f", interest));
            System.out.println("New balance: $" + String.format("%.2f", balance));
        } else {
            System.out.println("\n--- Current Account Interest Calculation ---");
            System.out.println("No interest added (balance is not positive)");
        }
    }

    /**
     * Overridden display method for current account
     */
    @Override
    public void displayAccountInfo() {
        System.out.println("\n=== Current Account Information ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Overdraft Limit: $" + String.format("%.2f", overdraftLimit));
        System.out.println("Transaction Count: " + transactionCount);
    }

    /**
     * Process a transaction (withdrawal or deposit)
     */
    public void processTransaction(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit: $" + String.format("%.2f", amount));
        } else {
            if (balance + amount >= -overdraftLimit) {
                balance += amount;
                System.out.println("Withdrawal: $" + String.format("%.2f", Math.abs(amount)));
            } else {
                System.out.println("Transaction denied: Exceeds overdraft limit");
            }
        }
        transactionCount++;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public int getTransactionCount() {
        return transactionCount;
    }
}

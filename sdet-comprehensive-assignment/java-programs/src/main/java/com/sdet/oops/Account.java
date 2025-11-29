package com.sdet.oops;

/**
 * Base class representing a bank account with interest calculation functionality
 */
public class Account {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;
    protected double interestRate;

    /**
     * Constructor to initialize account details
     */
    public Account(String accountNumber, String accountHolder, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    /**
     * Calculate interest based on balance and interest rate
     */
    public double calculateInterest() {
        return balance * interestRate / 100;
    }

    /**
     * Add calculated interest to the account balance
     */
    public void addInterestToAccount() {
        double interest = calculateInterest();
        balance += interest;
        System.out.println("Interest added: $" + String.format("%.2f", interest));
        System.out.println("New balance: $" + String.format("%.2f", balance));
    }

    /**
     * Display account details
     */
    public void displayAccountInfo() {
        System.out.println("\n--- Account Information ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}

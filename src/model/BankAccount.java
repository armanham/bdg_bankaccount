package model;

public class BankAccount {

    private String accountNumber;
    private String nameOfHolder;
    private double balance;

    public BankAccount(String accountNumber, String nameOfHolder) {
        setAccountNumber(accountNumber);
        setNameOfHolder(nameOfHolder);
        this.balance = 0;
    }

    public BankAccount(String accountNumber, String nameOfHolder, double balance) {
        setAccountNumber(accountNumber);
        setNameOfHolder(nameOfHolder);
        setBalance(balance);
    }

    public double depositing(double money) {
        if (money < 0) {
            System.out.println("Passed number for money must be non-negative: ");
            return -1;
        }
        return this.balance + money;
    }

    public double withdrawing(double money) {
        if (money < 0) {
            System.out.println("Passed number for money must be non-negative: ");
            return -1;
        }
        if (money > this.balance) {
            System.out.println("You do not have this money on your balance: your balance is: " + this.balance);
        }

        return this.balance - money;
    }

    private void setBalance(double balance) {
        if (balance < 0){
            System.out.println("Balance must be non-negative number");
        }
        this.balance = balance;
    }

    public double checkBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            System.out.println("Passed null or empty value for accountNumber: ");
            return;
        }
        this.accountNumber = accountNumber;
    }

    public String getNameOfHolder() {
        return nameOfHolder;
    }

    public void setNameOfHolder(String nameOfHolder) {
        if (nameOfHolder == null || nameOfHolder.isEmpty()) {
            System.out.println("Passed null or empty value for accountNumber: ");
            return;
        }
        this.nameOfHolder = nameOfHolder;
    }
}
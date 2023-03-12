package model;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private List<BankAccount> accounts = new ArrayList<>();

    public Bank(String name) {
        setName(name);
    }


    public BankAccount openAccount(String accountNumber, String nameOfHolder) {
        if (accountNumber == null || accountNumber.isEmpty() || nameOfHolder == null || nameOfHolder.isEmpty()) {
            throw new IllegalArgumentException("Passed null or empty value: ");
        }

        BankAccount newAccount = new BankAccount(accountNumber, nameOfHolder);
        if (accounts.contains(newAccount)) {
            System.out.println("Account already exists: ");
            return null;
        }

        for (BankAccount item : accounts) {
            if (item.getAccountNumber().equals(accountNumber)) {
                System.out.println("Account number is reserved: ");
                return null;
            }
        }

        accounts.add(newAccount);
        return newAccount;
    }


    public BankAccount openAccount(String accountNumber, String nameOfHolder, double balance) {
        if (accountNumber == null || accountNumber.isEmpty() || nameOfHolder == null || nameOfHolder.isEmpty() || balance < 0) {
            throw new IllegalArgumentException("Passed null or empty value: ");
        }

        BankAccount newAccount = new BankAccount(accountNumber, nameOfHolder, balance);
        if (accounts.contains(newAccount)) {
            System.out.println("Account already exists: ");
            return null;
        }

        for (BankAccount item : accounts) {
            if (item.getAccountNumber().equals(accountNumber)) {
                System.out.println("Account number is reserved: ");
                return null;
            }
        }

        accounts.add(newAccount);
        return newAccount;
    }


    public boolean closeAccount(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Passed null or empty value: ");
        }

        return accounts.remove(findBy(accountNumber));
    }


    public void deposit(String accountNumber, double money) {
        if (accountNumber == null || accountNumber.isEmpty() || money < 0) {
            throw new IllegalArgumentException("Passed illegal argument: ");
        }

        BankAccount account = findBy(accountNumber);
        if (account == null){
            System.out.println("Account does not exists: ");
            return;
        }
        account.depositing(money);
    }


    public void withdraw(String accountNumber, double money) {
        if (accountNumber == null || accountNumber.isEmpty() || money < 0) {
            throw new IllegalArgumentException("Passed illegal argument: ");
        }

        BankAccount account = findBy(accountNumber);
        if (account == null){
            System.out.println("Account does not exists: ");
            return;
        }
        account.withdrawing(money);
    }


    public double getTotalBalance() {
        if (accounts == null || accounts.isEmpty()){
            System.out.println("Bank does not have accounts: ");
            return -1;
        }

        double sum = 0;
        for (BankAccount item : accounts) {
            sum += item.checkBalance();
        }
        return sum;
    }


    public BankAccount findBy(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Passed null or empty value: ");
        }

        for (BankAccount item : accounts) {
            if (item.getAccountNumber().equals(accountNumber)) {
                return item;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()){
            System.out.println("Passed null or empty value: ");
            return;
        }
        this.name = name;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
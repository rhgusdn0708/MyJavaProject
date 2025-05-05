package workshop.bank.entity;

import workshop.bank.exception.InsufficientBalanceException;

public class Account {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) throw new InsufficientBalanceException("잔액이 부족합니다.");
        balance -= amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return "일반";
    }

    public String toString() {
        return String.format("계좌번호: %s, 소유주: %s, 잔액: %.0f원", accountNumber, ownerName, balance);
    }
}
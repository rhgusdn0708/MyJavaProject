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
        if (balance < amount) throw new InsufficientBalanceException("�ܾ��� �����մϴ�.");
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
        return "�Ϲ�";
    }

    public String toString() {
        return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.0f��", accountNumber, ownerName, balance);
    }
}
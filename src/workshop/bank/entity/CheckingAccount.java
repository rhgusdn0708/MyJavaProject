package workshop.bank.entity;

import workshop.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) throws WithdrawalLimitExceededException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException("��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: " + withdrawalLimit + "��");
        }
        balance -= amount;
    }

    @Override
    public String getAccountType() {
        return "üũ";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", ��� �ѵ�: %.0f��", withdrawalLimit);
    }
}
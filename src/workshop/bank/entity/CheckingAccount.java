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
            throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
        }
        balance -= amount;
    }

    @Override
    public String getAccountType() {
        return "체크";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", 출금 한도: %.0f원", withdrawalLimit);
    }
}
package workshop.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        balance += balance * interestRate;
    }

    @Override
    public String getAccountType() {
        return "����";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", ������: %.1f%%", interestRate * 100);
    }
}

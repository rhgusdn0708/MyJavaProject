package workshop.bank.control;

import workshop.bank.entity.*;
import workshop.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("\n== ���� ���� ==");
        Account acc1 = bank.createAccount("Savings", "ȫ�浿", 10000.0, 0.03);
        Account acc2 = bank.createAccount("Checking", "��ö��", 20000.0, 5000.0);
        Account acc3 = bank.createAccount("Savings", "�̿���", 30000.0, 0.02);

        bank.printAllAccounts();

        System.out.println("\n== �Ա�/��� �׽�Ʈ ==");
        acc1.deposit(5000);
        System.out.printf("5000.0���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.0f��\n", acc1.getBalance());

        try {
            acc2.withdraw(3000);
            System.out.printf("3000.0���� ��ݵǾ����ϴ�. ���� �ܾ�: %.0f��\n", acc2.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println("��� ����: " + e.getMessage());
        }

        System.out.println("\n== ���� ���� �׽�Ʈ ==");
        if (acc1 instanceof SavingsAccount) {
            ((SavingsAccount) acc1).applyInterest();
            System.out.printf("���ڰ� ����Ǿ����ϴ�. ���� �ܾ�: %.0f��\n", acc1.getBalance());
        }

        System.out.println("\n== ���� ��ü �׽�Ʈ ==");
        try {
            acc3.withdraw(5000);
            acc1.deposit(5000);
            System.out.printf("5000.0���� ��ü�Ǿ����ϴ�. %s -> %s\n", acc3.getOwnerName(), acc1.getOwnerName());
        } catch (InsufficientBalanceException e) {
            System.out.println("��ü ����: " + e.getMessage());
        }

        bank.printAllAccounts();

        System.out.println("\n== ���� ó�� �׽�Ʈ ==");
        try {
            acc2.withdraw(6000);  // ����ѵ� �ʰ� �õ�
        } catch (InsufficientBalanceException e) {
            System.out.println("��� ����: " + e.getMessage());
        }

        try {
            bank.getAccount("AC9999"); // �������� �ʴ� ����
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

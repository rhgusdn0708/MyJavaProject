package workshop.bank.control;

import workshop.bank.entity.*;
import workshop.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("\n== 계좌 생성 ==");
        Account acc1 = bank.createAccount("Savings", "홍길동", 10000.0, 0.03);
        Account acc2 = bank.createAccount("Checking", "김철수", 20000.0, 5000.0);
        Account acc3 = bank.createAccount("Savings", "이영희", 30000.0, 0.02);

        bank.printAllAccounts();

        System.out.println("\n== 입금/출금 테스트 ==");
        acc1.deposit(5000);
        System.out.printf("5000.0원이 입금되었습니다. 현재 잔액: %.0f원\n", acc1.getBalance());

        try {
            acc2.withdraw(3000);
            System.out.printf("3000.0원이 출금되었습니다. 현재 잔액: %.0f원\n", acc2.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println("출금 오류: " + e.getMessage());
        }

        System.out.println("\n== 이자 적용 테스트 ==");
        if (acc1 instanceof SavingsAccount) {
            ((SavingsAccount) acc1).applyInterest();
            System.out.printf("이자가 적용되었습니다. 현재 잔액: %.0f원\n", acc1.getBalance());
        }

        System.out.println("\n== 계좌 이체 테스트 ==");
        try {
            acc3.withdraw(5000);
            acc1.deposit(5000);
            System.out.printf("5000.0원이 이체되었습니다. %s -> %s\n", acc3.getOwnerName(), acc1.getOwnerName());
        } catch (InsufficientBalanceException e) {
            System.out.println("이체 오류: " + e.getMessage());
        }

        bank.printAllAccounts();

        System.out.println("\n== 예외 처리 테스트 ==");
        try {
            acc2.withdraw(6000);  // 출금한도 초과 시도
        } catch (InsufficientBalanceException e) {
            System.out.println("출금 오류: " + e.getMessage());
        }

        try {
            bank.getAccount("AC9999"); // 존재하지 않는 계좌
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

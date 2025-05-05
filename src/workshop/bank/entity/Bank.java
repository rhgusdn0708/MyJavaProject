package workshop.bank.entity;

import java.util.*;
import workshop.bank.exception.AccountNotFoundException;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int nextAccountNumber = 1000;

    public Account createAccount(String type, String ownerName, double balance, double param) {
        String accountNumber = "AC" + nextAccountNumber++;
        Account account;
        if (type.equals("Savings")) {
            account = new SavingsAccount(accountNumber, ownerName, balance, param);
        } else {
            account = new CheckingAccount(accountNumber, ownerName, balance, param);
        }
        accounts.add(account);
        System.out.printf("%s 계좌가 생성되었습니다! %s\n", account.getAccountType(), account);
        return account;
    }

    public Account getAccount(String accountNumber) throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    public void printAllAccounts() {
        System.out.println("\n== 모든 계좌 목록 ==");
        for (Account acc : accounts) {
            System.out.printf("%s: %s\n", acc.getAccountType(), acc);
        }
    }
}
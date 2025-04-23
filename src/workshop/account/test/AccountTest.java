package workshop.account.test;

//ctrl + shift + o
import workshop.account.entity.Account;

public class AccountTest {
	public static void main(String[] args) {
		//Account °´Ã¼
		Account account = new Account("A1100","221-22-3477",100000);
		System.out.println(account); //account.toString()
		System.out.println("°í°´¹øÈ£: " + account.getCustId());
		System.out.println("°èÁÂ¹øÈ£: " + account.getAcctId());
		System.out.println("ÀÜ¾×:" + account.getBalance());
		//ÀÔ±İ
		System.out.println("10000¿øÀÔ±İ");
		account.deposit(10000);
		System.out.println("ÀÜ¾×:" + account.getBalance());
		
		//Ãâ±İ
		System.out.println("20000¿øÃâ±İ");
		account.withdraw(20000);
		System.out.println("ÀÜ¾×:" + account.getBalance());
		
		account.withdraw(100000);
		System.out.println("ÀÜ¾×:" + account.getBalance());
		
	}
	
}

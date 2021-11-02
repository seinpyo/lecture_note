package days12;

class Account {
	
	private double balance; // 계좌 정보 클래스에 잔액이 저장되는 멤버 변수
	
	public void initBalance(int i) {	//잔고 확인 기능
		balance = i;
	}
	
	public void display() {
		System.out.printf("현재 잔액은 %.2f원 입니다.\n", balance);
	}
	
	public void withraw(int money) {	//출금 기능
		balance -= money;
	}
	
	public void deposit(int money) {	//입금 기능
		balance += money;
	}
	
}

public class Class05 {

	public static void main(String[] args) {
		Account a = new Account();
//		a.balance = 500000;	//err
//		System.out.printf("현재 잔액은 %.2f원 입니다.\n", balance);	//err
		a.initBalance(1000000);
		a.display();
		a.withraw(5000);
		a.display();
		a.deposit(20000);
		a.display();
		
	}

}

package days12;

import java.util.Scanner;

class MyAccount {
	
	int money;
	private double balance; // 계좌 정보 클래스에 잔액이 저장되는 멤버 변수
	
	public void initBalance(int i) {	//잔고 확인 기능
		balance = i;
	}
	
	public void withraw() {	//출금 기능
		System.out.println("\n비밀번호 네자리를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int pass = sc.nextInt();
		if (pass != 1234) {
			System.out.println("\n비밀번호를 확인하세요.\n");
			return;
		}
		System.out.println("\n출금할 금액을 입력하세요.");
		money = sc.nextInt();
		if(money > balance) {
			System.out.println("\n잔액이 부족합니다.");
			return;
		}
		balance -= money;
		System.out.println("출금이 완료되었습니다.");
		System.out.printf("현재 잔액은 %.2f원 입니다.\n", balance);

	}
	
	public void display() {
		System.out.printf("\n현재 잔액은 %.2f원 입니다.", balance);
		System.out.println();
	}
	
	public void deposit() {	//입금 기능
		Scanner sc = new Scanner(System.in);
		System.out.println("\n입금할 금액을 입력하세요.");
		money = sc.nextInt();
		System.out.println("입금이 완료되었습니다.");
		System.out.printf("현재 잔액은 %.2f원 입니다.\n", balance);
		if(money <= 0) {
			System.out.println("\n입금액 오류. 관리자에게 문의하세요.");
			System.out.println();
			return;
		}
		balance += money;
	}
	
}

public class Class06 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MyAccount a = new MyAccount();
		int selectMenu = 0; 
		a.initBalance(100000);
		
		while(selectMenu != 4) {
			
			System.out.println("\n원하는 서비스 번호를 입력하세요");
			System.out.println("1. 잔액 확인, 2. 출금 3. 입금 4. 종료 ");
			selectMenu = sc.nextInt();
			
			switch(selectMenu) {
			case 1: a.display(); break;
			case 2: a.withraw(); break;
			case 3: a.deposit(); break;
			}
			
		}
		
	}

}

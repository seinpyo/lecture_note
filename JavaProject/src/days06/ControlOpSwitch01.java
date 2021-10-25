package days06;

import java.util.Scanner;

public class ControlOpSwitch01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int a = sc.nextInt();
	
		switch(a) {
		case 1: 
			System.out.println("1을 입력하셨습니다.");
			break;
		case 2: 
			System.out.println("2를 입력하셨습니다.");
			break;
		case 3: 
			System.out.println("3을 입력하셨습니다.");
			break;
		case 4: 
			System.out.println("4를 입력하셨습니다.");
			break;
		case 5: System.out.println("5를 입력하셨습니다.");
		}
		
		sc.close();
	}
}
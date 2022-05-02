package days05;

import java.util.Scanner;

public class ControlOpIf06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		double b = 0;
		System.out.print("기본급을 입력하세요 : ");
		a = sc.nextInt();
		
		// 기본급이 100만원 이상이라면 기본급의 50%를 보너스로 합산
		// 기본급이 100만원 미만이라면 기본급의 60%를 보너스로 합산
		// 총 지급액을 출력하세요
		
//		String fmPrice = String.format("%,f", b);

//		if (a>=1000000) { 
//			b = a*1.5;
//		} else {
//			b = a*1.6;
//		}
		
		double bonus;
		if (a>=1000000) { 
			bonus = 0.5;
		} else {
			bonus = 0.6;
		}
		b = a+a*bonus;
		String fmPrice = String.format("%,d", (int) b);
		System.out.println("총 지급액은 " + fmPrice + "입니다.");
		
		sc.close();
	}
}

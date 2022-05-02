package days11;

import java.util.Scanner;

public class Method08 {
	public static void main(String[] args) {
		
		//반지름을 입력받아 원주와 원넓이를 출력하는 메소드 작성
		
		Scanner sc = new Scanner(System.in);
		System.out.println("반지름을 입력하세요");
		int r = sc.nextInt();
		double d = calculate2(r); // 원의 둘레를 구하는 메서드
		double n = calculate1(r);	// 원의 넓이를 구하는 메서드
		prn(n,d); //넓이와 둘레를 출력하는 메서드
		
		sc.close();
				
	}
	
	public static double calculate1 (int r) {
		double d = 2* 3.14 * r;
		return d;
	}
	
	public static double calculate2(int r) {
		double n = 3.14 * r * r;
		return n;
	}
	
	public static void prn(double d, double n) {
		System.out.printf("원주는 %.2f, 원넓이는 %.2f입니다", d, n);
	}
}

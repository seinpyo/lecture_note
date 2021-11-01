package days11;

import java.util.Scanner;

public class Method10 {
	public static void main(String[] args) {
		
		//삼각형의 밑변과 높이를 입력받아 삼각형의 넓이를 계산하여 출력
		
		int a,b; 
		double c;
		a = myInput1();	// 밑변 입력받기
		b = myInput2();	// 높이 입력받기
		c = calculate(a,b); // 넓이 계산
		prn(c); //출력
		

	}

	public static int myInput1() {
		System.out.print("밑변을 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); 
		return a;
	}
	
	public static int myInput2() {
		System.out.print("높이을 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt(); 
		return b;
	}
	
	public static double calculate(int a, int b) {
		return a*b*0.5;
		
	}

	public static void prn(double c) {
		System.out.printf("삼각형의 넓이는 %.1f입니다.", c);
	}
	

}

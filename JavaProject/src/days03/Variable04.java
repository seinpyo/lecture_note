package days03;

import java.util.Scanner;

public class Variable04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double pi = 3.141592;
		System.out.print("반지름을 입력하세요 : ");
		int r = sc.nextInt();
		double area = r*r*pi;
		double circumference = 2*r*pi;
		System.out.printf("입력한 원의 넓이는 %.2f입니다.\n", area);
		System.out.printf("입력한 원의 둘레는 %.2f입니다.\n", circumference);
		
		System.out.println("입력한 원의 넓이는 " + (int)(area*100)/100.0 + " 입니다.");
		// ex) area = 123.1234
		//		123.1234*100 = 12312.34 
		//		->(int)123412.34 = 12312
		//		--> 12312/100.0 = 123.12  

	}
}

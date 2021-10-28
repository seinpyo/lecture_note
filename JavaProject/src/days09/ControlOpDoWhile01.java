package days09;

import java.util.Scanner;

public class ControlOpDoWhile01 {
	public static void main(String[] args) {
		int i;
		for (i=11; i<=10; i++) 
			System.out.printf("%d ", i);
		System.out.println("\nfor 반복 종료후 i 변수 값 : " + i);
		System.out.println("---------------------------------------------");
		i=11;
		while(i<=10 ) {
			System.out.printf("%d ", i);
			i++;
		}
		System.out.println("\nwhile 반복 종료후 i 변수 값 : " + i);
		System.out.println("---------------------------------------------");
		
		
		do {
			System.out.printf("%d ", i);
			i++;
		} while (i<=10);
		System.out.println("\ndo-while 반복 종료후 i 변수 값 : " + i);
	
		// do ~ while 반복문을 입력하여 사용자가 100을 입력할때까지 반복해서 입력받아라
		
		Scanner sc = new Scanner(System.in)	;
		int input;
		do {
			System.out.print("정수를 입력하세요 : ");
			input = sc.nextInt();
		} while( input != 100 );
		System.out.println("프로그램 종료");
	
		sc.close();
	}
}



		
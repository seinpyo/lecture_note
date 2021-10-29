package days10;

import java.util.Scanner;

public class Method05 {
	public static void main(String[] args) {
		
		// 구구단 메서드 제작하기
		
		Scanner sc = new Scanner(System.in);
		int i=1;
		
		while (i!=0) {
			System.out.print("단을 입력하세요 : ");
			int k = sc.nextInt();
			gugudan(k);
			
			System.out.println("계속하시겠습니까? (y:1/n:0)");
			i = sc.nextInt();
			if (i==0) break;
			
		}
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}
	
	public static void gugudan(int dan) {
		for(int i=1; i<10; i++) 
			System.out.printf("%d x %d = %d\n", dan, i, (dan*i));
		
	}
	
}

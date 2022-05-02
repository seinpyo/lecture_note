package days11;

import java.util.Scanner;

public class Method07 {
	public static void main(String[] args) {
		
		//리턴 값이 존재하는 메소드의 선언
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요.");
		int num = sc.nextInt();
		int k = square(num);
		System.out.printf("%d의 제곱은 %d입니다.", num, k);
		
		System.out.println();
		int max_result = max(10, 34, 67);
		System.out.printf("가장 큰 숫자는 -> %d\n", max_result);
		
		
		sc.close();
		
	}
	
	
	public static int square(int num) {
		int sq = num*num;
		return sq;
	}
	
	
	public static int max (int a, int b, int c) {
		int result = 0;
		
		if(a>b) result = a; 
		else result = b;
		
		if(result<c) result = c;
		return result;
		
	}
	
}

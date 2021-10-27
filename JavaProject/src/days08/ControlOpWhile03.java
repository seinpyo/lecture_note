package days08;

import java.util.Scanner;

public class ControlOpWhile03 {
	public static void main(String[] args) {
		//팩토리얼을 출력하기
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		int fact=1;
		System.out.printf("%d! = ", num);
		while(num>1) {
			fact *= num;
			System.out.printf("%d * ", num);
			num--;
		}
		
		System.out.printf("1 = %d", fact);
		sc.close();
	}
}

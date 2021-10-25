package days06;

import java.util.Scanner;

public class ControlOpFor07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fact = 1;
		System.out.print("정수를 입력하세요 : ");
		int x = sc.nextInt();
		System.out.printf("%d! = ", x);
		for (int i=x; i>1; i--) {
			System.out.printf("%d x " , i);
			fact = fact * i;
		}
		System.out.printf("1 = %d", fact);
		sc.close();
	}
}

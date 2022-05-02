package days05;

import java.util.Scanner;

public class controllOpIf01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요: ");
		int a = sc.nextInt();
		int b = a%2;
		boolean result = a%2==0;
		System.out.println("입력한 정수가 짝수인가요?" + result);
		if(b==0) {
		System.out.println("입력한 정수는 짝수입니다");
		} 
		if(b!=0){
		System.out.println("입력한 정수는 홀수입니다");
		}
		
		// 다르게 나타내기
		if (result) System.out.println("입력한 정수는 짝수입니다.");
		if (a%2==0)  System.out.println("입력한 정수는 짝수입니다.");
		if (result==true)  System.out.println("입력한 정수는 짝수입니다.");
		if(b==0) System.out.println("입력한 정수는 짝수입니다.");
		
		if (!result) System.out.println("입력한 정수는 홀수입니다.");
		if (a%2!=0) System.out.println("입력한 정수는 홀수입니다.");
		if (result==false) System.out.println("입력한 정수는 홀수입니다.");
		if(b!=0) System.out.println("입력한 정수는 홀수입니다.");
				
		sc.close();
	}

}



package days08;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		//1부터 100사이의 소수를 출력하라
		
		System.out.println("1부터 100까지의 소수는 다음과 같습니다.");
		for(int i=2; i<=100; i++) {
			int cut=0;
			for(int j=2; j<=i/2;j++) {
				if(i%j==0) { cut++; }
			}
			if(cut==0) System.out.printf("%d ", i);
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\n정수를 입력하세요 : ");
		int num = sc.nextInt();
		int cnt=0;
		for(int i=0; i<=num; i++) {
			if(num%i==0) cnt++;
		} 
		if (cnt==2) System.out.println("입력한 정수는 소수입니다.");
		else System.out.println("입력한 정수는 소수가 아닙니다.");
		
		sc.close();
	}
}



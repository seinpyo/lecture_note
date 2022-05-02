package days08;

import java.util.Scanner;

public class ControlOpWhile04 {

	public static void main(String[] args) {
		
		//구구단 출력하기
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("구구단을 출력합니다. 종료하려면 0을 입력하세요");
			System.out.printf("몇 단? : ");
			int num = sc.nextInt();
			int x = 1;
			if(num==0) break;
			
				while (x<10) {
					System.out.printf("%d x %d = %d\n", num, x, (num*x));
					x++;
					if(x == 10) break;
				}	
			
		}
		
		System.out.println("프로그램을 종료합니다");
		sc.close();
	}
}

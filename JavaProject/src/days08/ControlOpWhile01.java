package days08;

import java.util.Scanner;

public class ControlOpWhile01 {
	public static void main(String[] args) {
		
		//while문 
		
		int i;
		
		for (i=1; i<=10; i++) {
			System.out.print(i + " ");
		}
		
		//위 for문을 while문으로 변경한 예
		System.out.println("");
		i=1;
		
		while(i<=10) {
			System.out.print(i + " ");
			i++;
		}
		
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴 선택 : 1(저장), 2(불러오기), 3(종료)");
		int input = sc.nextInt();

		while (input!=3) {

			System.out.print("메뉴 선택 : 1(저장), 2(불러오기), 3(종료)");
			input = sc.nextInt();
			
			switch (input) {
			case 1: {
				System.out.println("저장되었습니다.");
				break;
			}
			case 2: {
				System.out.println("이전 내용을 불러옵니다.");
				break;
			}
			}
		}

		System.out.println("프로그램을 종료합니다.");
		sc.close();

	}
}
package days05;

import java.util.Scanner;

public class ControlOpIf05 {

	public static void main(String[] args) {
		// 12세 미만 어린이 , 12~18세 청소년, 19~25세 청년
		// 26세 이상은 성년 이라고 출력하는 if문 작성
		
		Scanner sc = new Scanner(System.in);
		System.out.print("출생년도를 입력하세요 : ");
		int year = sc.nextInt();
		int age = 2021 - year + 1;
		
		System.out.print("2021년 현재 " + age + "세 ");
		if (age<12) { System.out.println("어린이입니다."); }
		else if (age<19) { System.out.println("청소년입니다."); }
		else if (age<26) { System.out.println("청년입니다"); }
		else { System.out.println("성인입니다.");}
	
		sc.close();
	}
}

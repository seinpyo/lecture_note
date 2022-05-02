package days06;

import java.util.Scanner;

public class ControlOpQuestionMark {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();
		
		String prnText;
		//if (score >= 70 ) prnText = "합격";
		//else prnText = "불합격";
		//아래 물음표 연산은 if - else 두가지 경우만 분류 가능
		
		prnText = (score>=70)? "합격" : "불합격";
		
		System.out.println(prnText + "입니다.");

		System.out.print("기본급을 입력하세요 : ");
		int a = sc.nextInt();
		double per = (a>=1000000)? 0.5 : 0.6;
		System.out.println("총 지급액 : " + (int)(a+a*per));

		sc.close();
	}

}

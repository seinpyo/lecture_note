package days09;

import java.util.Scanner;

public class Array08 {

	public static void main(String[] args) {
		// 점수를 입력받아서 학점을 출력하라
		// 90이상 A, 80이상 B, 70이상 C, 60이상 D, 나머지 F
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 (0~100) : ");
		int score = sc.nextInt();
		
		// 아래 배열을 이용하시오.
		char [] grade = {'F','F','F','F','F','F','D','C','B','A'};
		
		if(score == 0) System.out.println("학점 : " + grade[0]);
		else System.out.println("학점 : " + grade[score/10]);
		
		sc.close();
		
	}
}

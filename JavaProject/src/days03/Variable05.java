package days03;

import java.util.Scanner;

public class Variable05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("국어 점수를 입력하세요 : ");
		int kScore = sc.nextInt();
		System.out.print("영어 점수를 입력하세요 : ");
		int eScore = sc.nextInt();
		System.out.print("수학 점수를 입력하세요 : ");
		int mScore = sc.nextInt();
		sc.close();
		
		int sum = kScore + eScore + mScore;
		double avg = (double) sum/3;
		
		System.out.println("");
		System.out.println("\t\t###성적표###\t\t");
		System.out.println("---------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t");
		System.out.println("---------------------------------------------");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t", name, kScore, eScore, mScore, sum, avg);

	}
}

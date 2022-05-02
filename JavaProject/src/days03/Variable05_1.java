package days03;

import java.util.Scanner;

public class Variable05_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		int sum = 0;       
		for(int i=0; i<3; i++) {
			switch (i+1) {
			case 1 :
				System.out.print("국어 점수를 입력하세요 : ");
				break;
			case 2 :
				System.out.print("영어 점수를 입력하세요 : ");
				break;
			case 3 :
				System.out.print("수학 점수를 입력하세요 : ");
				break; 
			}
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		double avg = sum/3;
		
		System.out.println("");
		System.out.println("\t\t###성적표###\t\t");
		System.out.println("---------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t");
		System.out.println("---------------------------------------------");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t", name, arr[0], arr[1], arr[2], sum, avg);


		sc.close();
	}
}

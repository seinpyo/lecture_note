package days09;

import java.util.Scanner;

public class Array04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생이 몇 명입니까?");
		int std = sc.nextInt();

		
		int[] kor = new int[std]; // 국어 점수 저장용 배열
		int[] eng = new int[std]; // 영어 점수 저장용 배열
		int[] mat = new int[std]; // 수학 점수 저장용 배열
		int[] tot = new int[std]; // 총점 저장용 배열
		double[] avg = new double[std]; // 평균 저장용 배열
		String[] name = new String[std]; // 이름 저장용 배열
		
		for(int i=0; i<std; i++) {
			System.out.printf("%d번 학생의 이름 : ", i+1);
			name[i] = sc.next();
			System.out.printf("%d번 학생의 국어 점수 : ", i+1);
			kor[i] = sc.nextInt();
			System.out.printf("%d번 학생의 영어 점수 : ", i+1);
			eng[i] = sc.nextInt();
			System.out.printf("%d번 학생의 수학 점수 : ", i+1);
			mat[i] = sc.nextInt();
			tot[i] = kor[i]+eng[i]+mat[i];
			avg[i] = tot[i]/3.0;
			
			
		}
		System.out.println("\n\t\t###성적표###");
		System.out.println("================================================");
		System.out.println("이름 \t 국어 \t 영어 \t 수학 \t 총점 \t 평균");
		for(int i=0; i<std; i++) {
			System.out.printf("%s \t %d \t %d \t %d \t %d \t %.1f\n", name[i], kor[i], eng[i], mat[i], tot[i], avg[i]);	
		}
		
		sc.close();
		
	}
}

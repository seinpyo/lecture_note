package days11;

import java.util.Scanner;

public class Method11 {
	
	public static void main(String[] args) {
		
		// 점수를 입력받고 총점과 평균을 출력하는 메소드 작성
		
		int kor, eng, mat, tot;
		double ave;
		kor = myInput(1);	//점수입력
		eng = myInput(2); 
		mat = myInput(3); 
		tot = sum(kor, eng, mat);
		ave = avg(kor, eng, mat);
		prn(tot, ave);	//총점 평균 학점 출력
		
		
	}

	public static int myInput(int i) {
		Scanner sc = new Scanner(System.in);
		switch (i) {
		case 1 : 
			System.out.print("국어 점수를 입력하세요 : ");
			break;
			
		case 2:
			System.out.print("영어 점수를 입력하세요 : ");
			break;
			
		case 3 :
			System.out.print("수학 점수를 입력하세요 : ");
			break;
		}
		
		return sc.nextInt();
		
	}

	public static int sum(int kor, int eng, int mat) {
		return kor + eng + mat;
		
	}
	
	public static double avg(int kor, int eng, int mat) {
		return (kor + eng + mat)/3.0;
	}
	
	public static void prn(int t, double a) {
		
		System.out.printf("총점 : %d, 평균 %.2f", t, a);
		
	}
	
}

package days05;

import java.util.Scanner;

public class ControlOpIf08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor, eng, math, total;
		double avg;
		
		System.out.print("국어 점수 : ");
		kor = sc.nextInt();
		System.out.print("영어 점수 : ");
		eng = sc.nextInt();
		System.out.print("수학 점수 : ");
		math = sc.nextInt();
		
		total = kor+eng+math;
		avg = total/3.0;
		
		// 평균 60점 이상이면서 모든 과목 40이상이면 합격, 아니라면 불합격
		// 해당되는 불합격 사유 (평균 미달, 국어 과락, 영어 과락, 수학 과락)을 함꼐 출력하세요
		
		if(avg>=60 && kor>=40 && eng>=40 && math>=40) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
			System.out.print("불합격 사유 : ");
			if (avg<60) {System.out.print("평균미달");}  
			if (kor<40) {System.out.print(" 국어과락");} 
			if (eng<40) {System.out.print(" 영어과락");} 
			if (math<40) {System.out.print(" 수학과락");}
		}
		
		sc.close();
	}
}

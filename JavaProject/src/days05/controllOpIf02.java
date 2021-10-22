package days05;

import java.util.Scanner;

public class controllOpIf02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = a%2;
		
		//아래 두 if문은 상호 독립적(하나가 실행되면 하나는 실행 안됨)
		if(b==0) {
			System.out.println("입력한 정수는 짝수(even)입니다.");
		}
		if(b==1) {
			System.out.println("입력한 정수는 홀수(odd)입니다.");
		}
		
		// 위 두개의 if문을 하나로 합쳐 둘 중하나는 무조건 실행되도록
		if(b==0) {
			System.out.println("입력한 정수는 짝수(even)입니다.");
		} else {
			System.out.println("입력한 정수는 홀수(odd)입니다.");
		}
		
		sc.close();
		
		int kor=70, eng=98, math=95;
		double avg = (kor+eng+math)/3.0;
		
		System.out.println("단일 if문 실행 : ");
		if(avg>=80.0) {
			System.out.println("평균 80 이상 합격");
		}
		
		//평균 80이상이면 합격, 아니면 불합격을 출력
		System.out.println("if~else문 실행 : ");
		if(avg>=80.0) {
			System.out.println("평균 80 이상 합격");
		} else {
			System.out.println("평균 80 이하 불합격");
		}
		
		
		//평균 60이상이거나 영어점수가 80이상이면 합격
		if ((avg>=60)||eng>=80) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		
		// 평균 60이상이면서 모든 과목 40이상이라면 합격
		if ((avg>=60)&&(eng>=40)&&(kor>=40)&&(math>=40)) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		
		// 평균 60이상이거나 모든 과목 50이상이라면 합격
		if ((avg>=60)||((eng>=50)&&(kor>=50)&&(math>=50))) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}

}
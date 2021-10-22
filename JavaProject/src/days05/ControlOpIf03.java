package days05;

import java.util.Scanner;

public class ControlOpIf03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 :");
		int a = sc.nextInt();
		
/*		if(a>0) {
			System.out.println("입력한 정수는 양수입니다.");
		}else {
			if (a<0) {
				System.out.println("입력한 정수는 음수입니다.");
			}else {
				System.out.println("입력한 정수는 0입니다.");
			}
		} */
		
		// 세가지 이상을 판단할 수 있는 else if 문
		if(a>0) {
			System.out.println("입력한 정수는 양수입니다.");
		}else if (a<0) {
			System.out.println("입력한 정수는 음수입니다.");
		}else {
			System.out.println("입력한 정수는 0입니다.");
		}
		
		sc.close();
		
		// ( )안의 연산식으로 계산한 결과가 true인 경우 { }안의 명령어가 실행
		
		// 중괄호 안의 명령이 한 개라면 중괄호는 생략 가능
		
		if(a>0) System.out.println("입력한 정수는 양수입니다.");
		else if (a<0) System.out.println("입력한 정수는 음수입니다.");
		else System.out.println("입력한 정수는 0입니다.");
		
		
		int kor=70, eng=98, math=95;
		//평균 점수가 80이상이면 합격, 70이상 79이하는 대기 순번, 나머지는 불합격을 출력
		double avg = (kor+eng+math)/3.0;
//		System.out.println(avg);	//87.67
		if(avg>=80) {
			System.out.println("합격");
		}else if ((avg>=70.0)&&(avg<80)) {
			System.out.println("대기 순번");
		}else {
			System.out.println("불합격");
		}
		
	}
}

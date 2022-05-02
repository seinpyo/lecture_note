package days05;

import java.util.Scanner;

public class ControlOpIf07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("직급 입력(과장/대리/사원) : ");
		String level = sc.nextLine();
		System.out.print("판매 실적 금액 입력 : ");
		int pay = sc.nextInt();
		
		// 판매 실적 금액에 과장 50%, 대리 25%, 사원 15%의 활동비를 합산하여 출력
		
		double ratio = 0;
		double cost = 0;
		int k = 1;
		
		if (level.equals("과장")) {
			ratio = 0.5;
		} else if (level.equals("대리")) {
			ratio = 0.25;
		} else if (level.equals("사원")) {
			ratio = 0.15;
		} else {
			ratio = 0.0;
			k = 0;
			System.out.println("다시 입력해주세요.");
		}
		
		cost = pay + pay*ratio;
		String fmCost = String.format("%,d", (int) cost*k);
		System.out.println("지급 활동비는 " + fmCost + "원 입니다.");
		
		sc.close();
	}
}

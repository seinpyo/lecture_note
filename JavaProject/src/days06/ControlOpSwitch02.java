package days06;

import java.util.Scanner;

public class ControlOpSwitch02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("월을 입력하세요 : ");
		int month = sc.nextInt();
		System.out.printf("일을 입력하세요 : ");
		int day = sc.nextInt();
		
		int days = day-1;
		
		switch(month) {
		case 2 : days += 31; break;
		case 3 : days += 31+28; break;
		case 4 : days += 31+28+31; break;
		case 5 : days += 31+28+31+30; break;
		case 6 : days += 31+28+31+30+31; break;
		case 7 : days += 31+28+31+30+31+30; break;
		case 8 : days += 31+28+31+30+31+30+31; break;
		case 9 : days += 31+28+31+30+31+30+31+31; break;
		case 10 : days += 31+28+31+30+31+30+31+31+30; break;
		case 11 : days += 31+28+31+30+31+30+31+31+30+31; break;
		case 12 : days += 31+28+31+30+31+30+31+31+30+31+30; break;
		}
		
		int dayOfTheWeek = days%7;
		
		switch (dayOfTheWeek) {
		case 0: System.out.println(month + "월 " + day + "일은 금요일 입니다."); break;
		case 1: System.out.println(month + "월 " + day + "일은 토요일 입니다."); break;
		case 2: System.out.println(month + "월 " + day + "일은 일요일 입니다."); break;
		case 3: System.out.println(month + "월 " + day + "일은 월요일 입니다."); break;
		case 4: System.out.println(month + "월 " + day + "일은 화요일 입니다."); break;
		case 5: System.out.println(month + "월 " + day + "일은 수요일 입니다."); break;
		case 6: System.out.println(month + "월 " + day + "일은 목요일 입니다."); break;
		}
		

		sc.close();

	}
}

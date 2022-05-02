package days05;

import java.util.Scanner;

public class ControlOpIf10 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("월을 입력하세요 : ");
		int month = sc.nextInt();
		System.out.printf("일을 입력하세요 : ");
		int day = sc.nextInt();
		
		int days = day-1;
		
		if (month == 2) days += 31;
		if (month == 3) days += 31+28;
		if (month == 4) days += 31+28+31;
		if (month == 5) days += 31+28+31+30;
		if (month == 6) days += 31+28+31+30+31;
		if (month == 7) days += 31+28+31+30+31+30;
		if (month == 8) days += 31+28+31+30+31+30+31;
		if (month == 9) days += 31+28+31+30+31+30+31+31;
		if (month == 10) days += 31+28+31+30+31+30+31+31+30;
		if (month == 11) days += 31+28+31+30+31+30+31+31+30+31;
		if (month == 12) days += 31+28+31+30+31+30+31+31+30+31+30;

		int dayOfTheWeek = days%7;
		
		if (dayOfTheWeek==0) {System.out.println(month + "월 " + day + "일은 금요일 입니다."); }
		else if (dayOfTheWeek==1) {System.out.println(month + "월 " + day + "일은 토요일 입니다."); }
		else if (dayOfTheWeek==2) {System.out.println(month + "월 " + day + "일은 일요일 입니다."); }
		else if (dayOfTheWeek==3) {System.out.println(month + "월 " + day + "일은 월요일 입니다."); }
		else if (dayOfTheWeek==4) {System.out.println(month + "월 " + day + "일은 화요일 입니다."); }
		else if (dayOfTheWeek==5) {System.out.println(month + "월 " + day + "일은 수요일 입니다."); }
		else if (dayOfTheWeek==6) {System.out.println(month + "월 " + day + "일은 목요일 입니다."); }
	
		sc.close();
	
	}
}

package days05;

import java.util.Scanner;

public class ControlObIf11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month, date, totalDays, dayOftheWeek;
		int[] monthList = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 };
		String[] day = { "금요일", "토요일", "일요일", "월요일", "화요일", "수요일", "목요일" };
		
		System.out.print("월을 입력하세요 : ");
		month = sc.nextInt();
		System.out.print("일을 입력하세요 : ");
		date = sc.nextInt();
		
		--date;
		totalDays = date;
		
		if (month > 1) {
			for (int i=0; i<month-1; i++) {
				totalDays += monthList[i];	
			} 
			System.out.print("1월 1일 부터 " + totalDays + "일 지난 ");
		}
		dayOftheWeek = totalDays % 7;
		System.out.println(day[dayOftheWeek] +"입니다.");
		
		sc.close();
		
	}

}

package days06;

import java.util.Scanner;

public class ControlOpFor08 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] day = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};		
		int a=0;
		
		System.out.print("연도 입력 : ");
		int y = sc.nextInt();
		System.out.print("월 입력 : ");
		int m = sc.nextInt();
		System.out.print("일 입력 : ");
		int d = sc.nextInt();
		
		//입력받은 년도의 전년도까지 지나온 모든 일수를 계산
		int days = 365*(y-1);
		for (int i=1; i<y; i++) {
			if(i%4==0 && i%100!=0 || i%400==0) {
				days++;				// 윤년일 경우에 days에 1씩 더해준다. 
			}
		}	
		
		switch(m) {
		case 12 : days = days+30;
		case 11 : days = days+31;
		case 10 : days = days+30;
		case 9 : days = days+31;
		case 8 : days = days+31;
		case 7 : days = days+30;
		case 6 : days = days+31;
		case 5 : days = days+30;
		case 4 : days = days+31;
		case 3 : for (int i=1; i<y; i++) 
			if(i%4==0 && i%100!=0 || i%400==0)  days+=29; 
			else days += 28;
		case 2 : days = days+31;
		}
		
		days += d;
		a = days%7;
		System.out.printf("%d년 %d월 %d일은 %s입니다.", y,m,d,day[a]);
		
		
		sc.close();
	}
}

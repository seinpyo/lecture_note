package days08;

import java.util.Scanner;

public class ControlOpWhile07 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] last = {31,28,31,30,31,30,31,31,30,31,30,31};
		int a=0;
		System.out.print("연도 입력 : ");
		int y = sc.nextInt();
		System.out.print("월 입력 : ");
		int m = sc.nextInt();
		
		while(true) {
			
			int days = 365*(y-1);
			for (int i=1; i<y; i++) 
				if(i%4==0 && i%100!=0 || i%400==0) 
					days++;	 
	
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
				if(i%4==0 && i%100!=0 || i%400==0) days+=29;
				else days += 28;
			case 2 : days = days+31;
			}
			
			if(y%4==0 && y%100!=0 || y%400==0) last[1] = 29;
				
			days += 1; // 입력된 월의 1일이 무슨 요일인지 알기위해 
			a = days%7;
			
			System.out.println();
			System.out.printf("\t\t   %d년 %d월\n\n", y, m);
			System.out.println("===================================================");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			System.out.println("===================================================\n");
			for (int i=0; i<a; i++) {
				System.out.print("  \t");
			}
			for (int i=1; i<=last[m-1]; i++) {
				System.out.printf("%2d\t",i);
				if((i+a)%7==0) System.out.println("\n");
			}
			
			
			System.out.println("\n[1.이전달]\t[2.다음달]\t[3.종료]\n");
			int i=sc.nextInt();
			if(i==1) { 
				if (m==1) { --y; m=12;}
				 else { --m;}
			} else if(i==2) {
				if(m==12) {++y; m=1;}
				else { ++m;}
			} else break;
		}
		sc.close();
	}
}
package days09;

import java.util.Scanner;

public class Array07 {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

		int a=0;
		System.out.print("연도 입력 : ");
		int y = sc.nextInt();
		System.out.print("월 입력 : ");
		int [] mdays = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if((y%4==0) && (y%100!=0) || (y%400==0)) mdays[2]=29;
		int m = sc.nextInt();
		
		while(true) {
			
			int days = 365*(y-1);
			for (int i=1; i<y; i++) 
				if(i%4==0 && i%100!=0 || i%400==0) 
					days++;	 
			for(int i=1; i<m; i++) 
				days = days + mdays[i];	//배열을 이용한 월 날짜 수 계산

				
			days += 1; 
			a = days%7;
			
			System.out.println();
			System.out.printf("\t\t   %d년 %d월\n\n", y, m);
			System.out.println("===================================================");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			System.out.println("===================================================\n");
			for (int i=0; i<a; i++) {
				System.out.print("  \t");
			}
			for (int i=1; i<=mdays[m]; i++) {
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

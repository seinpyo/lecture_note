package days11;

import java.util.Scanner;

public class Method09 {

	public static void main(String[] args) {
		
		//입력된 연도가 윤년인지 평년인지 출력하기
		
		Scanner sc = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		int year = sc.nextInt();
		boolean a = yoon(year);	//윤년이면 true, 평년이면 false를 리턴하는 메소드
		prn(year, a); //출력용 메소드
		
		sc.close();
	}
	
	public static boolean yoon (int year) {
		if ((year%4==0 && year%100!=0 || year%400==0)) return true;
		else return false;
	}
	
	public static void prn (int year, boolean a) {
		
		if(a==true) System.out.printf("%d년은 윤년입니다.", year);		
		if(a==false) System.out.printf("%d년은 평년입니다.", year);
		
	}
}

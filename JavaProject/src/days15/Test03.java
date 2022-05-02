package days15;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		int c = (int) (Math.random()*39);
		System.out.println(c);
		int year = intputYear();
		boolean a = yoon(year);
		prn(a);

		
	}
	public static void prn(boolean a) {
		if(a) System.out.println("윤년");
		else System.out.println("평년");
	}
	
	public static boolean yoon(int y) {
	if ((y%4==0) && (y%100 !=0) || (y%400 ==0)) return true;
	else return false;
	}
	
	public static int intputYear() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("년도를 입력하세요");
		int y = sc.nextInt();
		return y;
	}
	
}

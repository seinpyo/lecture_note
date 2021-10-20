package days03;

import java.util.*;

public class Variable03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("삼각형의 밑변을 입력하세요 : "); // 삼각형의 밑변을 입력하세요 : 21
		int base = sc.nextInt();
		System.out.print("삼각형의 높이를 입력하세요 : "); // 삼각형의 높이를 입력하세요 : 13
		int altitude = sc.nextInt();
		double area = (double)base*altitude*0.5;
		System.out.printf("입력한 삼각형의 넓이는 %.1f입니다.", area); //입력한 삼각형의 넓이는 136.5입니다.
		sc.close();
	}
}

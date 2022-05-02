package days04;

import java.util.Scanner;

public class Variable07 {
	public static void main(String[] args) {
		// 사과 개수, 한 상자에 담길 사과의 개수를 입력받는다. 
		// 입력 조건으로 포장했을 때, 포장된 박스 개수, 남은 사과 개수 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("사과의 개수를 입력하세요 : ");
		int apple = sc.nextInt();
		System.out.print("한장자에 담길 사과의 개수를 입력하세요 : ");
		int perBox = sc.nextInt();
		
		System.out.println
		("포장된 상자 수는 " + (apple/perBox) + "개, " + "남은 사과 수는 " + (apple%perBox) + "개 입니다." );
		

	}
}

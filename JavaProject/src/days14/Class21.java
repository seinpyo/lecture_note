package days14;

import java.util.Random;

//static 메서드

public class Class21 {
	public static void main(String[] args) {
		// 클래스 내부에서 사용 시
		abc();

	}

	public static void abc() {
		
		//Random() - Import 필요
		Random rd = new Random();
		System.out.println(rd.nextInt());	//음수 등장
				
		
		//math.random()	//음수발생 x
		System.out.println("Math클래스의 난수 발생 스태틱메서드 값 : " + Math.random());
		System.out.println("0~50까지 난수 발생 : " + (int) (Math.random()*50)); // 원하는 최대값을 곱해준다
		
		System.out.println();
		
		//abs 
		int num = -10;
		System.out.printf("num = %d, num 변수의 절대값 = %d\n", num, Math.abs(num));
		
		//sqrt 
		num = 9;
		System.out.printf("num 변수의 제곱근 = %.2f\n", Math.sqrt(num));
		System.out.println();
		
		
		// Integer
		String strNum1 = "123";
		String strNum2 = "56";
		System.out.println(strNum1 + strNum2);
		System.out.println(Integer.parseInt(strNum1) + Integer.parseInt(strNum2));
		System.out.println();
		
		//String
		int intNum1 = 123;
		int intNum2 = 456;
		System.out.println(intNum1 + intNum2);
		System.out.println(String.valueOf(intNum1) + String.valueOf(intNum2));
		System.out.println();
		
		//Double
		String strNum3 = "10.75";
		String strNum4 = "6.2";
		System.out.println(strNum3 + strNum4);
		System.out.println(Double.parseDouble(strNum3) + Double.parseDouble(strNum4));
		
		
		System.out.println('A'-'B');
		
	}
}

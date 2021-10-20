package days03;

public class Variable01 {
	public static void main(String[] args) {
		System.out.println(35 + " + " + 38 + " = " + (35+38));  // 35 + 38 = 73
		System.out.println(35 + " - " + 38 + " = " + (35-38));  // 35 - 38 = -3
		System.out.println(35 + " × " + 38 + " = " + (35*38));  // 35 × 38 = 1330
		System.out.println(35 + " ÷ " + 38 + " = " + (35/38));  // 35 ÷ 38 = 0
		System.out.println(35 + " % " + 38 + " = " + (35%38));  // 35 % 38 = 35

//		 변수 : 프그램 실행 중 발생 또는 입력되는 데이터를 저장할 목적으로 만들어서 사용하는 임시 저장장소. 
//		 생성 명령 실행 시 생성되고, 프로그램 종료 시 소멸
		
//		 변수의 이름을 만드는 규칙
//		 1. 영문과 숫자, 일부 특수문자(_) 사용가능
//		 2. 첫글자는 반드시 영문으로 사용 
//		 3. 중간에 공백이 있을 수 없다
//		 4. 너무 짧지 않계, 되도록 의미를 부여하여 이름을 생성한다.
//		 5. 변수 이름이 너무 짧으면, 변수의 개수가 많아졌을 때 서로의 용도를 구분하기 어렵다.
//		 6. 변수의 이름이 너무 길면, 사용할 때마다 긴 이름을 타이핑해야하는 불편함이 존재.
//		 7. 두가지 의미의 단어가 조합되어 변수 이름이 만들어 진다면 첫 단어는 소문자로,
//			  두번째 단어 첫글자는 대문자로 생성
//				ex) 덧셈 결과를 저장할 변수 이름 : plusResult
//		 8. 변수는 자료형(정수, 실수, 문자)에 따라 만드는 명령이 달라집니다.
//				int : 정수, double : 실수, String : 문자 등
		
		int x; //정수형 변수
		double y; // 실수형 변수
		String z; // 문자형 변수
		
		int a; // b라는 이름의 변수를 생성(정수를 저장하기 위한 변수)
		int b; // b라는 이름의 변수를 생성(정수를 저장하기 위한 변수)
		int plusResult, minusResult, multiplyResult;  // 한번에 여러 변수를 생성
		double divideResult;  // divideResult라는 이름의 변수 생성(실수를 저장하기 위한 변수)

		// a = 10.25; // 실수 -> 정수 소수점 아래 데이터 손실에 의한 에러 
		divideResult = 100;	// 데이터 손실이 없으므로 에러 X
		
		boolean b1; // 참(true) or 거짓(false) 중 하나를 저장하는 자료형(변수) 
		b1 = true;
		
		// boolean 자료를 printf로 출력할때는 %b를 사용
		System.out.printf("변수 b1의 값 : %b\n", b1);	// 변수 b1의 값 : true
		System.out.println("변수 b1의 값 : " + b1);	// 상동
		
		
//		 int = 정수형 자료형 4Byte형 정수
//		 long =  정수형 자료형 8Byte형 정수
//		 float = 실수형 자료형 4Byte형 실수 
//		 double = 실수형 자료형 8Byte형 실수
//		 char = 문자(글자) 자료형 'a', 'b' 2Byte - String과 다릅니다.
		
		char c = 'A';
		System.out.printf("변수 c의 값 : %c\n", c);	// 변수 c의 값 : A
		System.out.println("변수 c의 값 : " + c);		// 상동
		
//		 String - 문자열 자료형 : 현재는 자료형이라고 부르지만 엄밀히 자료형은 아니며 이후 객체 단원에서 자세히 학습
//		 문자열 : "a", "Abc", "aBCD", "" ...
		
		String s;
		s = "ABCD";
		System.out.printf("변수 s의 값 : %s\n", s);	// 변수 s의 값 : ABCD
		System.out.println("변수 s의 값 : " + s);		// 상동
		
//		 2진수 1자리 숫자 0 or 1 
//		 2진수 1자리 숫자를 저장할 수 있는 공간 : 1bit
//		 2진수 2bit 00 01 10 11 (10진수의 0~3)
//		 3bit - 000 001 010 011 100 101 110 111 8개 (10진수의 0~7)
//		 4bit - 0000~1111 총 16개 (10진수 0~15)
//		 5bit - 32개, 6bit 64개, 7bit 128개
//		 8bit - 256개 (10진수의 0~255) = 1Byte
//		 문자의 종류 : 약 150개 
//		 예전 시스템은 글자 하나를 저장하기 위해 8bit(1Byte)를 사용했다
//		 15bit - 32768개, 16 bit - 66536개 
//		 한글의 초성중성종성을 모두 나타내려면 약 44000개의 자리가 필요하므로 16bit(2byte)를 사용 
		
//		 예전 시스템의 int - 2byte(-32,768 ~ 32,767)
//		 현재 시스템의 int - 4byte(-2,147,483,648~2,147,483,647)
		
		// double - 8byte 0.00002 => 0.2 * 10^-4 -> 2와 -4를 저장
		// (10^-308 ~ 10^308) 
		
		a = 15;
		b = 11;
		c = '+';
		plusResult = a+b;
		minusResult = a-b;
		multiplyResult = a*b;
		divideResult = a/b;
		System.out.printf("%d %c %d = %d\n",a, c, b, plusResult);	// 15 + 11 = 26
		c = '-';
		System.out.printf("%d %c %d = %d\n",a, c, b, minusResult);	// 15 - 11 = 4
		c = '×' ;
		System.out.printf("%d %c %d = %d\n",a, c, b, multiplyResult);	// 15 × 11 = 165
		c = '÷';
		System.out.printf("%d %c %d = %.2f\n",a, c, b, divideResult); // 15 ÷ 11 = 1.00
		// 정수와 정수의 나눗셈은 결과도 정수이다.
		
		divideResult = (double)a/b; // 현재 위치에서만 잠시 a를 double형으로 형변환(캐스팅) 하여 연산 결과를 바르게 한다. 
		System.out.printf("%d %c %d = %f\n",a, c, b, divideResult); // 15 ÷ 11 = 1.363636
		
		// 같은 결과가 나오도록 println으로 작성하기
		
		c = '+';
		System.out.println(a + " " + c + " " + b + " = " + plusResult);		// 15 + 11 = 26
		c = '-';
		System.out.println(a + " " + c + " " + b + " = " + minusResult);	// 15 - 11 = 4
		c = '×';
		System.out.println(a + " " + c + " " + b + " = " + multiplyResult);	// 15 × 11 = 165
		c = '÷';
		System.out.println(a + " " + c + " " + b + " = " + divideResult); 	// 15 ÷ 11 = 1.3636363636363635

		// " " 없이 a + b + c = pluseResult 를 작성하게 되면 
		
		System.out.println(a + c + b + " = " + plusResult);		// 273 = 26
		System.out.println(c*1);	// 247 (= c의 아스키코드 값) 
		// 로 c에 현재 저장된 값, 즉 '÷'의 아스키코드값 247과 a(15)가 산술 연산된다. 
		
		// 사이에 " "를 붙임으로서 int와 char을 분리하여 출력될 수 있도록 한 것
		
		
		
		
	}
}





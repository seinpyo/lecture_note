package days04;

public class Variable08 {

	public static void main(String[] args) {
		//소단원 제목 아스키코드
		
		// char형 변수의 값 대입 : 하나의 글자를 다른 글자와 구분하기 위해 작은 따옴표 사용
		// ex) '', ' ', 'A' ...
		// String형은 큰 따옴표로 표현("","  ", "A", "ABCD" ... )
		char ch = 'A';
		System.out.printf("ch -> %c\n", ch);
		
		// char형 데이터는 컴퓨터 저장장치에 저장될 때, 이진수코드로 저장된다
		// 문자를 저장하기위한 코드체계에 의해 조합된 코드 = ASCⅡ 코드
		// 이를 십진수로 변환하면 정수로도 출력할 수 있다. 
		// ->정수와 문자간의 호환성
		
		int intchar = ch;
		System.out.printf("ch -> 정수형 변수에 저장 %d\n", intchar);
		System.out.printf("ch -> 정수형 변수로 캐스팅 %d\n", (int)ch);
		ch = 'B';
		System.out.printf("'B' -> 정수값으로 캐스팅 %d\n", (int)ch);
		System.out.printf("'B' -> 정수값으로 캐스팅 %d\n", (int)'B');
		System.out.printf("'C' -> 정수값으로 캐스팅 %d\n", (int)'C');
		System.out.printf("'Z' -> 정수값으로 캐스팅 %d\n", (int)'Z');
		// 65~90 대문자
		System.out.printf("'a' -> 정수값으로 캐스팅 %d\n", (int)'a');
		System.out.printf("'z' -> 정수값으로 캐스팅 %d\n", (int)'z');
		// 97~122 소문자
		
		System.out.printf("'0' -> %d, '9' -> %d\n", (int)'0', (int)'9');
		// 48~57 0~9까지의 숫자
		
		//대문자 B값에 32를 더하여 소문자 b로 변경
		System.out.printf("%c + 32 -> %c\n", ch, ch+32);
		// 소문자 B값에 32를 빼서 대문자 b로 변경
		ch = 'b';
		System.out.printf("%c - 32 -> %c\n", ch, ch-32);
		
		// 아라비아 기호 '8'에서 아라비아 기호 '0'을 빼면, 정수 8이 결과로 나온다
		// -> 56 - 48 = 8
		System.out.printf("'8'-'0' -> %d\n", '8'-'0');
		
		
		// 실수형 변수의 초기화
		// 자바에서 모든 실수들은 기본적으로 double타입으로 인식된다 
		// float 타입으로 값을 저장하기 위해서는 float형 변수를 선언하고 
		// float형 데이터를 저장
		// float 변수에 double형 데이터 입력 -> 에러
		// float f1 = 1.123;  -> 에러 (실수 1.123은 double로 인식되기 때문에)
		float f2 = 1.123f; // 똔ㄴ float f2 = 1.123F;
		// float 변수에 캐스팅 연슨을 적용한 double형 데이터 입력 -> ok
		float f3 = (float)1.123;
		// 용량이 큰 자료형(double)에 작은 자료형(float) 데이터 대입 -> ok
		double f4 = f2; //캐스팅 연산자도 필요 x
		
		// 출력형식은 double와같은 %f
		System.out.printf("%.1f\t%.1f\n",f2,f4);
		
		
		// 정수들의 값의 대입
		int a = 100;
		byte b1 = (byte) a;
		byte b2 = 123;
		// 정수 기본형이 int이므로 실수형 처럼 캐스팅 연산자가 필요할듯하지만 
		// 정수 데이터에 한하여 생략하고 사용이 가능하다.
		a = b2; // 용량이 작은 자료형을 큰 자료형에 대입은 정상 실행
		// 반대의 경우는 캐스팅 연산이 필요하다.
		
	}
}

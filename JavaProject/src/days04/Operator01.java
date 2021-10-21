package days04;

// 연산자 
// 산술연산자-사(오)칙 연산자 : + - / * %
// 관계연산자-비교연산자 : > < >= <= == !=
// 논리연산자 : %%(And), ||(Or), !(Not)

public class Operator01 {
	public static void main(String[] args) {
		// 산술연산자
		
		int n1 = 10, n2 = 7, result1;
		double result2;
		result1 = n1 + n2;
		System.out.println(n1 + " + " + n2 + " = " + result1);
		result1 = n1 - n2;
		System.out.println(n1 + " - " + n2 + " = " + result1);
		result1 = n1 * n2;
		System.out.println(n1 + " x " + n2 + " = " + result1);
		result2 = n1 / (double) n2;
		System.out.println(n1 + " ÷ " + n2 + " = " + result2);
		double result3 = (int)(result2*100)/100.0;	// 반올림 x, 버림됨
		System.out.println(n1 + " ÷ " + n2 + " = " + result3);
		
		// 자료형과 산술연산
		byte b1 = 10;
		byte b2 = 5;
		// 정수와 정수(byte 또는 short 포함)의 산술 연산이 일어나면 결과는 무조건 int
		// byte b3 = b1 + b2;  -> Err
		byte b3 = (byte)(b1 + b2);  
		// 연산 결과를 형변환 하여 byte나 short로 저장할 수 있다.
		
		// 캐스팅 연산은 서로 호환이 가능한 자료끼리만 사용이 가능합니다.
		// 올바른 예 (실수->정수)
		double d1 = 1.23456;
		int a = (int)d1; // a에 1이 저장
		double d2 = (double)a; // d2에 1.0이 저장
		
		// 잘못된 예 (String->int)
		//String str = "123456";
		//int a1 = (int)str;  ->  Err
		//int a2 = 123456;
		//String str2 = (String)a2;  ->  Err
		
		// 호환이 되지 않는 자료간의 형변환은 별도의 도구(메소드)가 필요
		
		// String -> int
		String str = "123456";
		int b = Integer.parseInt(str);  
		System.out.println(str);		// 123456
		
		// int -> String 
		int c = 123456;
		String str4 = String.valueOf(c);	
		System.out.println(c);			 	// 123456
		
		// double -> String
		double d3 = 123.1234;
		//String s3 = (String)d3; -> Err
		String s3 = String.valueOf(d3);		
		System.out.println(d3);		// 123.1234
		
		// String -> double
		String s4 = "123.1234";
		//double d4 = (double)s4; -> Err
		double d4 = Double.parseDouble(s4);	
		System.out.println(d4);	 // 123.1234
		
		// String -> char
		String s5 = "ABCDEFG";
		// char c5 = (char)s5; -> Err
		 char c5 = s5.charAt(0);	// charAt(n) -> n번째 숫자를 출력한다(0부터 시작)
		 System.out.println(c5);	// A
		 
		 // char -> String
		 char c6 = 'A';
		 //Stirng s6 = (char)c6; -> Err
		 String s6 = String.valueOf(c6);
		 System.out.println(s6);	// A
		
	}
}

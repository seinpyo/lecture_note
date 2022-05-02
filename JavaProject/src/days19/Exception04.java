package days19;

import java.text.ParseException;

//예외 상황 고의 발생
//종류별 예외 처리

public class Exception04 {
	public static void main(String[] args) {
	
		try {
			ArithmeticException a = new ArithmeticException("ArithmeticException 고의 발생");
			throw a; 
			
		}catch (ArithmeticException e) {
			System.out.printf("ArithmeticException - ");
			System.out.println("에러메시지 : " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.printf("RuntimeException - ");
			System.out.println("에러메시지 : " + e.getMessage());
		}catch(Exception e) {
			System.out.printf("Exception - ");
			System.out.println("에러메시지 : " + e.getMessage());
		}

		System.out.println();
		try {
			RuntimeException b = new RuntimeException("RuntimeException 고의 발생");
			throw b; 
			
		}catch (ArithmeticException e) {
			System.out.printf("ArithmeticException - ");
			System.out.println("에러메시지 : " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.printf("RuntimeException - ");
			System.out.println("에러메시지 : " + e.getMessage());
		}catch(Exception e) {
			System.out.printf("Exception - ");
			System.out.println("에러메시지 : " + e.getMessage());
		}
		
		System.out.println();
		
		try {
			ParseException a = new ParseException("ParseException 고의 발생", 0);
			throw a;
		}catch (ArithmeticException e) {
			System.out.printf("ArithmeticException - ");
			System.out.println("에러메시지 : " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.printf("RuntimeException - ");
			System.out.println("에러메시지 : " + e.getMessage());
		}
		catch(Exception e) {
			System.out.printf("Exception - ");
			System.out.println("에러메시지 : " + e.getMessage());
		}
		
	}

}

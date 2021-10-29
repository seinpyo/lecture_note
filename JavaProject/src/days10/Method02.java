package days10;

public class Method02 {
	public static void main(String[] args) {
		
		myPrint(100);
		// 100 : 전달 인수 -> 괄호 안에 전달된 인수는 메소드가 실행될 때
		// 메소드 정의 영역 괄호 안에 선언된 n 변수에 저장된다.
		myPrint(200);
		myPrintWith2Int(100,200);
	}
	
	public static void myPrint(int n) {
		System.out.println("전달 받은 int의 값 n -> " + n);
	}
	
	// 아래 메서드는 다수의 매겨변수를 전달 ㅂ다는 매소드의 형태 - 객 매개변수 별로 전달받을 변수를 선언
	// 동일한 타입이라도 자료형의 생략은 허용되지 않는다.
	public static void myPrintWith2Int(int n, int m) {
		System.out.println("전달 받은 n + m -> " + (n+m));
	}
	
	// 전달 인수는 반드시 매개 변수의 자료형과 일치해야한다.
	// 다수개의 값을 전달 할 때는 자료형과 순서도 일치해야한다.
	
}

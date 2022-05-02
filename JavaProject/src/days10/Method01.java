package days10;

public class Method01 {
	public static void main(String[] args) {
		
		// 메서드를 통해 반복되는 코드를 출력하기
		
		System.out.println("프로그램 시작");
		myPrint();
		System.out.println("프로그램 실행중");
		myPrint();
		System.out.println("프로그램 실행중");
		myPrint();
		System.out.println("프로그램 종료");
		
	}
	
	public static void myPrint() {
		System.out.printf("내가만든 ");
		System.out.println("Print 메서드 실행!");
	}
	
}

package days18;

interface InterA {
//	int n1;  -> err : final 변수가 초기화 되지 않음
	int n1 = 0;	// final static은 생략 가능, 반드시 초기화 필요.
//	InterA(){} : 생성자 생성 불가
//	public void print() {}  -> err : 일반 메서드 선언 불가
	
	public static final int num =10;
	public abstract void test();
}

class SubA implements InterA{
	@Override
	public void test() {System.out.println("SubA의 test 메소드 실행");}
}

public class Extend11_Interface01 {
	public static void main(String[] args) {
		
		InterA a1 = new SubA();
		a1.test();
		
		
	}
}

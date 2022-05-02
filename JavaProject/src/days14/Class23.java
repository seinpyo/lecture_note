package days14;

class MemberCall {
	//인스턴스 변수 : 객체가 생성될 때 iv 변수가 생성 -> 10으로 초기화
	int iv = 10;
	
	//스태틱 변수 : 프로그램이 시작할 때 sv가 생성 -> 20으로 초기화
	static int sv = 20;
	
	//인스턴스 변수 : 객체가 생성될 때 iv2가 생성 
	//-> 이미 만들어져서 20을 저장하고 있는 sv값으로 초기화 -> OK
	int iv2 = sv;
	
	//스태틱 변수값을 인스턴스 변수 값으로는 초기화 할 수 없다
	//stativ int sv2 = iv;  // err 
	
	// 임시방편으로 객체를 생성한 후 변수를 사용하는 예
	static int sv2 = new MemberCall().iv;
	
	// 인스턴스 메서드 : iv, sv 자유롭게 호출 가능
	void instanceMethod1() {
		System.out.println(sv);
		System.out.println(iv);
	}
	
	// 스태틱 메서드 : 기본적으로 sv만 호출 가능 
	static void staticMethod() {
		System.out.println(sv);
		System.out.println(new MemberCall().iv );	
		
		//instanceMethod1(); 	-> Err : 스태틱 메서드는 인스턴스 메서드를 호출할 수 없다
		new MemberCall().instanceMethod1(); // 이런 방법으로는 가능
	}
	
	
	void instanceMethod2() {
		staticMethod();
		instanceMethod1();
	}	//인스턴스 메소드는 스태틱/인스턴스 메소드 모두를 호출 가능하다

}

public class Class23 {
	public static void main(String[] args) {
		
	}
}

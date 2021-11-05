package days15;

//상속 관계에서의 객체 생성 과정

class SuperB {
	int superNum;
	public SuperB() {
		System.out.println("부모 클래스의 생성자 실행");
	}
}

class SubB extends SuperB {
	int subNum;
	
/*	  자식 클래스의 디폴트 생성자의 형태
 SubB() {
		super();	//생략가능
	} 
*/   
	SubB() {
		System.out.println("자식 클래스의 디폴트 생성자 실행");
	} 
	
	public SubB(int num) {
		this();
		System.out.println("자식클래스의 오버로딩된 생성자 실행 this() O");
	}
	
	public SubB(int subNum, int num) {
		System.out.println("자식클래스의 오버로딩된 생성자 실행 this() X");
	}
	
}

public class Extends04 {
	public static void main(String[] args) {
		SubB b1 = new SubB();	// super();
		System.out.println();
		SubB b2 = new SubB(5);	// this(); -> super();
		System.out.println();
		SubB b3 = new SubB(5,3);
		
	}

}

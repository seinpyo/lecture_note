package days15;

class SuperC {
	
	public SuperC() {
		System.out.println("부모클래스의 디폴트 생성자");
	} 
	public SuperC(int num) {
		System.out.println("부모클래스의 매개변수가 있는 생성자");
	}
}

class SubC extends SuperC{
	public SubC() {
		super(10);
	}
	public SubC(int n) {
		super();
	}
	
}
public class Extends05 {
	public static void main(String[] args) {
		
		SubC c1 = new SubC();
		SubC c2 = new SubC(10);

	}

}

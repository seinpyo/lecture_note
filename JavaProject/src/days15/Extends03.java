package days15;

class SuperA {
	private int n1;	
	public int n2;
	int n3;		//디폴트 접근제어자 (같은 패키지내에서 접근 가능)
	protected int n4;	//같은 패키지 혹은 외부패키지의 자식클래스에서 접근가능
	public int getN1() { return n1; }
	
	
}

class SubA extends SuperA{

	
	public void printInfo() {
//		System.out.println(this.n1); //err
		System.out.println(n2); 	//ok
		System.out.println(n3);	//ok
		System.out.println(n4);
		System.out.println(this.getN1()); //ok
		
	}
	
}
public class Extends03 {
	public static void main(String[] args) {

	}

}

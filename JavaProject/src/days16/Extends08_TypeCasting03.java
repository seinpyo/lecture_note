package days16;

class SuperG {}
class SubG1 extends SuperG {}
class SubG2 extends SuperG {}
class SubG3 extends SuperG {}

public class Extends08_TypeCasting03 {
	public static void main(String[] args) {
		SuperG s = new SuperG();
		SubG1 s1 = new SubG1();
		SubG2 s2 = new SubG2();
		SubG3 s3 = new SubG3();
		
		if (s instanceof SubG1)
			System.out.println("SubG1 클래스타입");
		else if (s instanceof SubG2)
			System.out.println("SubG2 클래스타입");
		else if (s instanceof SubG3)
			System.out.println("SubG3 클래스타입");
		else if (s instanceof SuperG)
			System.out.println("SuperG 클래스타입");
		
		if (s1 instanceof SubG1)
			System.out.println("SubG1 클래스타입");
		else if (s1 instanceof SuperG)
			System.out.println("SuperG 클래스타입");
		
	}

}

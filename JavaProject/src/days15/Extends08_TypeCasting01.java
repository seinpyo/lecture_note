package days15;

class NormalA {int num;}
class NormalB {int num;}

public class Extends08_TypeCasting01 {
	public static void main(String[] args) {
		
		short s = 10;
		int i = s; // 자동 형변환
		int j = 10; 
		//s = j; //err
		s = (short) j; //ok
		
		NormalA a1 = new NormalA();
		//NormalB b1 = a1; //err
		//NormalB b1 = new NormalA() //err
		NormalB b2 = new NormalB();
		//NormalA a2 = b1; //err
	}

}

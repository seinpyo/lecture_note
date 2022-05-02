package days12;

class Dclass{
	
	
	Dclass() {
		System.out.println("Dclass의 디폴트 생성자 호출");
	}
	Dclass (int a) {
		System.out.println("Dclass의 int타입 매개변수를 전달받는 생성자 호출");
	}
	Dclass(double b) {
		System.out.println("Dclass의 double타입 매개변수를 전달받는 생성자 호출");
	}

}

public class Class11 {
	public static void main(String[] args) {

		Dclass d1 = new Dclass();
		Dclass d2 = new Dclass(10);
		Dclass d3 = new Dclass(10.23);
		
	}

}

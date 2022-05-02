package days13;

//static

class StaticA {
	int num;	//인스턴스 변수
	static int number = 100;	//static 변수 
	private static int no = 1000;
	
	public static int getNo() {
		return no;
	}
	public static void setNo(int no) {
		StaticA.no = no;
	}
}

public class Class18 {
	public static void main(String[] args) {
		
		StaticA a = new StaticA();
		a.num = 100;
		System.out.println("a 객체의 동적 멤버변수 값 : " + a.num);
		
		StaticA a2 = new StaticA();
		a2.num = 200;
		System.out.println("a2 객체의 동적 멤버변수 값 : " + a2.num);
		StaticA a3 = new StaticA();
		a3.num = 300;
		System.out.println("a3 객체의 동적 멤버변수 값 : " + a3.num);
		System.out.println(StaticA.number);	// 인스턴스 변수의 호출방법

//		StaticA.no = 100; 		//err
		StaticA.setNo(100); 	//ok
//		System.out.println(StaticA.no); 		//err 
		System.out.println(StaticA.getNo()); 	//100
	}

}

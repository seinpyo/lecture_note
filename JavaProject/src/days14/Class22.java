package days14;

//static & 인스턴스 

class MyMath{
	int a, b;
	static int c = 0;
	MyMath() { c++; }
	
	//인스턴스 메서드들은 인스턴스 변수에 자유롭게 접근이 가능하다
	int add() {return a+b;} 
	int subtract() {return a-b;} 
	int multiply() {return a*b;} 
	double divide() {return (double)a/b;} 
	
	//인스턴스 메서드들은 스태틱 변수에도 자유롭게 접근이 가능하다
	void init() { a = c*20;  b= c*30; }
	
	//스태틱 메서드들은 인스턴스 변수에 접근이 불가능하다.
	static int add(int e, int d) {
		//return a+b+c+d;
		return c+e+d;
	}
	
	//스태틱 메서드들은 스태틱 변수에만 자유롭게 접근이 가능하다.
	static int subtract(int e, int d) {return e-d+c;}
	static int multiply(int e, int d) {return e*d+c;}
	static double divide(double e, double d) {return e/d+c;}
	
}

public class Class22 {
	public static void main(String[] args) {
		
		MyMath mm = new MyMath();
		mm.init();
		//멤버변수, 매개변수, 스태틱변수로 연산
		System.out.println(mm.add());		
		System.out.println(mm.subtract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
		
		//매개변수와 스태틱변수로 연산
		System.out.println(MyMath.add(10,30));	
		System.out.println(MyMath.subtract(10,30));
		System.out.println(MyMath.multiply(10,30));
		System.out.println(MyMath.divide(10,30));

	}
}

package days15;

class MyMath {
	private int a, b;
	static int c=0;
	MyMath() {c++;}
	int add() {return a+b;}
	void init() {a = c*100; b=c*200;}
	static int add(int e, int d) { 
		int a = new MyMath().a;
		int b = new MyMath().b;
		return a+ b+e+d+c;}
	
}
public class Test02 {

	public static void main(String[] args) {
		int sum = cals("sum",98,78,45,12,23);
		System.out.println();
		int ave = cals("avg",98,78,45,12,23);
		System.out.println(sum +" "+ ave);
		

		MyMath a1 = new MyMath();
		System.out.println(a1.add());
		a1.init();
		System.out.println(a1.add(3,4));
		
	}
	
	static int cals(String op, int ...a) {
		int total =0;
		double avg = 0.0;
		for(int i = 0; i < a.length; i++) { total +=  a[i]; }
		if (op.equals("sum")) {return total;}
		else { return total/3; }
	}
	

}

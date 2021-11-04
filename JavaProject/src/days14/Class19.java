package days14;

class StaticB {
	int num;
	static int count = 0;
	
	StaticB() { 
		count++; 
		num = count;
		}
	
}

public class Class19 {
	public static void main(String[] args) {
		System.out.printf("count = %d\n", StaticB.count);
		
		StaticB b1 = new StaticB();
		System.out.printf("b1.num = %d, count = %d\n", b1.num, StaticB.count);

		StaticB b2 = new StaticB();
		System.out.printf("b2.num = %d, count = %d\n", b2.num, StaticB.count);
		
		StaticB b3 = new StaticB();
		System.out.printf("b3.num = %d, count = %d\n", b3.num, StaticB.count);	}

}

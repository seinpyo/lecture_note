package days14;

class StaticD {
	//private으로 지정된 static멤버는 클래스 내부에서만 사용이 가능한 멤버
	
	private static int count;
	
	//static 멤버는 static 메서드와 인스턴스 메서드 둘에서 모두 접근이 가능하므로 
	//private 으로 지정된 static 멤버를 이용하고자한다면 public 으로 지정된 멤버메서드(static, 인스턴스)로 이용해야한다.
	
	public static void setCount(int count) { StaticD.count = count; }
	public static int getCount() { return count; }
	
	// 단, 인스턴스 메서드는 객체 생성 후 이용이 가능하다.
	public void setCount1(int count) { StaticD.count = count; }
	public int getCount1() { return count; }
	
}

public class Class24 {
	public static void main(String[] args) {
		
		System.out.printf("StaticD.count = %d\n", StaticD.getCount());
		StaticD.setCount(15);
		System.out.printf("StaticD.count = %d\n", StaticD.getCount());
		
		System.out.println();
		
		//인스턴스 메서드는 객체 생성 후 사용
		StaticD d1 = new StaticD();
		System.out.printf("StaticD.count = %d\n", d1.getCount1());
		d1.setCount1(20);
		System.out.printf("StaticD.count = %d\n", d1.getCount1());
		
		

	}

}

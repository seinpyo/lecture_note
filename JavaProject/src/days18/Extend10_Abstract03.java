package days18;

abstract class AbstractA {
	public abstract void test1();
	public abstract void test2();
	public abstract void test3();
	public abstract void test4();
	public abstract void test5();
	public abstract void test6();
	public abstract void test7();
}

class Abstract_Adapter extends AbstractA {

	public void test1() {}
	public void test2() {}
	public void test3() {}
	public void test4() {}
	public void test5() {}
	public void test6() {}
	public void test7() {}
	
}

class Abstract_Sub1 extends Abstract_Adapter {
	public void test1() {System.out.println("test1 오버라이딩!");}
}

public class Extend10_Abstract03 {
	public static void main(String[] args) {
		
		AbstractA a = new Abstract_Sub1();
		a.test1();
		
	}

}

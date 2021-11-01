package days11;

class First {
	//속성(멤버필드, 멤버변수, 필드) : 클래스에 속한 정보(변수)들.
	int n1;
	int n2;
	
	First() { }
	First(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	
	public static int add(int n1, int n2) {
		return n1+n2;
	}
	
}

public class Class01 {
	public static void main(String[] args) {
		
		First a1 = new First(10, 20);
		First a2 = new First();
		System.out.println(a1.n1);
		System.out.println(a1.n2);
		a2.n1=30;
		a2.n2=40;
		System.out.println(a2.n1);
		System.out.println(a2.n2);
	}
}

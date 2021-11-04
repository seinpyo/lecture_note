package days14;

// 싱글턴 패턴 

class SingletonEx {
	int n1;
	int n2;
	
	private SingletonEx() { }
	private static SingletonEx itc = new SingletonEx();
	public static SingletonEx getInstance() { return itc; }
}

class MultitonEx {
	
}

public class Class26 {
	public static void main(String[] args) {
//		SingtonEx s1 = new SingtonEx();
//		SingtonEx s2 = new SingtonEx();
		// 싱글턴 방식 : 위의 s1과 s2의 레퍼런스 변수가 같은 주소를 갖게 하는 방식
		// 현재는 다른 주소를 가지고 있음 (new 연산자에 의해 서로 다른 공간이 생성됨)

		SingletonEx s1 = SingletonEx.getInstance();
		SingletonEx s2 = SingletonEx.getInstance();
		SingletonEx s3 = SingletonEx.getInstance();
		System.out.println(s1);	// 참조변수의 주소값 출력
		System.out.println(s2);
		System.out.println(s3);
		System.out.println("----------------------------");
		MultitonEx m1 = new MultitonEx();
		MultitonEx m2 = new MultitonEx();
		System.out.println(m1);
		System.out.println(m2);
		
		s1.n1 = 150;
		System.out.println(s2.n1);
		s2.n2 = 200;
		System.out.println(s3.n1 + " " + s3.n2);
	}

}

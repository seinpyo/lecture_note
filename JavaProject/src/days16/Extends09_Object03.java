package days16;

//equals

public class Extends09_Object03 {
	public static void main(String[] args) {
		
		//기본 자료형들의 값 비교는 비교연산자(==)를 사용
		int n1 = 10;
		int n2 = 10;
		if(n1==n2) System.out.println("n1과 n2는 서로 같습니다.");
		else System.out.println("n1과 n2는 서로 다릅니다.");

		String s1 = "Hello";		
		String s2 = "Hello";
		
		System.out.println(s1);
		if(s1 == s2) System.out.println("s1과 s2는 서로 같습니다.");
		else System.out.println("s1과 s2는 서로 다릅니다.");
		if(s1.equals(s2)) System.out.println("s1과 s2는 서로 같습니다.");
		else System.out.println("s1과 s2는 서로 다릅니다.");
		
		
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		
		if(s3 == s4) System.out.println("s3과 s4는 서로 같습니다.");
		else System.out.println("s3과 s4는 서로 다릅니다.");
		if(s3.equals(s4)) System.out.println("s3과 s4는 서로 같습니다.");
		else System.out.println("s3과 s4는 서로 다릅니다.");
		
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		if (p1.equals(p2)) System.out.println("p1과 p2는 서로 같습니다.");
		else System.out.println("p1과 p2는 서로 다릅니다.");
	}

}

package days16;

class Human {
	private String name; 
	private int age;
	public Human (String name, int age) {
		this.name = name; this.age = age;
	}
	public String toString() {		//toString 오버라이딩
		String info = "name = " + this.name + ", " ;
		info += "age = " + this.age;
		return info;
	}
	
	public boolean equals(Object obj) {	//equals 오버라이딩
		// 매개변수로 Object 클래스를 받았기 때문에 Human 클래스의 매개변수에 접근 불가 
		// Human 클래스가 아닌 다른 값이 왔을 때 return false(메서드 종료)
		if (!(obj instanceof Human)) return false;
		Human target = (Human) obj;	
		//강제 형변환 (obj에 Human클래스의 주소값이 있기 때문에 가능) 
		boolean result = ((this.name.equals(target.name))&&(this.age==target.age));
		return result;
	}
}
public class Extends09_Object04 {
	public static void main(String[] args) {
		
		Human s1 = new Human ("홍길동", 21);
		Human s2 = new Human ("홍길동", 21);
		Human s3 = new Human ("김길동", 21);
		System.out.println("Human1의 정보 : " + s1);
		System.out.println("Human2의 정보 : " + s2);
		System.out.println("Human3의 정보 : " + s3);
		
		//레퍼런스 변수들 간의 비교 
		if (s1 == s2) System.out.println("비교연산결과 : s1 == s2");
		else System.out.println("비교연산결과 : s1 != s2");

		if (s1.equals(s2)) System.out.println("equals()결과 : s1 == s2");
		else System.out.println("equals()결과 : s1 != s2"); 
		//equals가 오버라이딩 되지 않았으므로 주소값을 비교한다
		
	}

}

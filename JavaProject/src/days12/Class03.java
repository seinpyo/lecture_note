package days12;

class Animal {
	
	//Field
	String name;
	int age;
	
	//Method
	public void output () {					// 멤버변수 출력을 위한 메서드
		System.out.printf("나의 이름은 %s, 나이는 %d살입니다.\n", name, age);
	}
	
	public void input(String n, int a) {	// 멤버변수 입력을 위한 메서드
		
		name = n;
		age = a;
		
	}
	
	String getName() {		//패키지내에서만 사용한다면 public 생략 가능
		return name;
	}
	
	int getAge() {
		return age;
	}
	
}

public class Class03 {
	
	int a;	//메인 메서드 위에도 멤버 변수 선언 가능
	
	public static void main(String[] args) {
		
		Animal a1 = new Animal();
		Animal a2 = new Animal();	// 객체 생성
		a1.input("앙꼬", 10);
		a2.input("흑연", 6);
		a1.output();
		a2.output();
		
		String n = a1.getName();
		int a = a1.getAge();
		System.out.println("이름 : "+ n +" 나이 : " +a);
		
		//위 세 줄을 한 줄로
		System.out.println("이름 : "+ a2.getName() +" 나이 : " + a2.getAge());	
		
	}
	
	public void prn() {
		System.out.printf("멤버 변수 값 %d입니다.", a);	//멤버 변수 출력 가능
	}
	
}

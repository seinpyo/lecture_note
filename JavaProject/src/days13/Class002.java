package days13;

class Person{
	String name;
	int age; 
	String phone;
	
	public void input (String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
	public void output () {
		System.out.printf("이름 : %s, 나이 : %d, 전화번호 : %s\n", name, age, phone);
	}

}

public class Class002 {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		
//		p1.name = "홍길동";
//		p1.age = 30;
//		p1.phone = "010-2222-3333";
//		
//		p2.name = "고길동";
//		p2.age = 40;
//		p2.phone = "010-6543-2123";
		
		p1.input("홍길동", 30, "010-2222-3333");
		p1.input("고길동", 40, "010-6543-2123");
		
		System.out.printf("이름 : %s, 나이 : %d, 전화번호 : %s\n", p1.name, p1.age, p1.phone);
		System.out.printf("이름 : %s, 나이 : %d, 전화번호 : %s\n", p2.name, p2.age, p2.phone);
		
		System.out.println();
		p1.output();
		p2.output();
	}
}

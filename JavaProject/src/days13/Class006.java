package days13;

//생성자

class Cat {
	private String name; 
	private int age;
	private String phone;
	
	//생성자를 생성 
	Cat() { System.out.println("Cat클래스의 생성자 호출"); 
	name = "흑연";
	age = 10;
	phone = "010-2525-2525";
	}	
	
	Cat(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
	void prn() {
		System.out.printf("이름 : %s, 나이 : %d, 전화번호 : %s\n", name, age, phone);
	}
	
	void init(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
}


public class Class006 {
	public static void main(String[] args) {
		Cat c1 = new Cat();
		c1.prn();
		
		System.out.println();
		
		Cat c2 = new Cat("야옹이", 11, "010-1234-1234");
		Cat c3 = new Cat("태평이", 4, "010-4321-4321");
		c2.prn();
		c3.prn();

	}
	
}

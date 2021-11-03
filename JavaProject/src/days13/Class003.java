package days13;

class Animal{
	String name;
	int age; 
	String phone;

	public void input (String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
	public void output () {
		System.out.printf("이름 : %s, 나이 : %d, 전화번호 : %s\n", this.name, age, this.phone);
	}
	
	public Animal copy() {
		Animal temp = new Animal();
		temp.name = this.name;
		temp.age = this.age;
		temp.phone = this.phone;
		return temp;
	}
	
	public void copy1 (Animal a) {
		this.name = a.name;
		this.age = a.age;
		this.phone = a.phone;
	}
	
}

public class Class003 {
	public static void main(String[] args) {
		
		Animal a1 = new Animal();
		Animal a2 = new Animal();
		
		a1.input("홍길동", 30, "010-2222-3333");
		a2.input("고길동", 40, "010-6543-2123");
		
		a1.output();
		a2.output();
		
		//Animal a3 = a1;	//참조값의 복사이므로 완벽한 객체 생성과 목사가 이루어지지 않는다.
		Animal a3 = a1.copy();
		a1.output();
		a1.name = "홍길남";
		a1.output();
		a3.output();
		
		System.out.println();
		Animal a4 = new Animal();
		a4.copy1(a2);
		a2.output();
		a4.output();
		System.out.println();
		a2.age = 200;
		a2.output();
		a4.output();
		
		
	}

}

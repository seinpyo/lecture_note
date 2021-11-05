package days15;

class Person {
	String name; 
	int age;
}

class PersonA extends Person{
	int studentnum;
}

class PersonB extends Person{
	int empnum;
}


public class Extends01 {
	public static void main(String[] args) {

		PersonA a = new PersonA();
		PersonB b = new PersonB();
		a.name = "홍길동";
		b.age = 26;
		System.out.println(a.name);
		System.out.println(b.age);
		
	}
}

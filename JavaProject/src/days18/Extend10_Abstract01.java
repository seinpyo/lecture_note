package days18;

//추상 클래스 
class Animal {
	public void sound() { System.out.println("을음소리");}
}

class Dog extends Animal { //sound메소드 오버라이딩 O
	public void sound() {System.out.println("멍멍");}
}

class Cat extends Animal {}	//sound메소드 오버라이딩 X

public class Extend10_Abstract01 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		System.out.println("강아지 소리");
		dog.sound();
		System.out.println("고양이 소리");
		cat.sound();
	}
}

package days15;

class Animal {
	public void crying() {
		System.out.println("소리를 냅니다.");
	}
}

class Dog extends Animal {
	public void sound() {
		super.crying();
		System.out.println("멍멍");
	}
	public void crying() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal {
	public void sound() {
		System.out.println("야옹");
	}
	
	public void crying() {
		System.out.println("야옹");
	}
}
public class Extends07 {
	public static void main(String[] args) {
		
		Cat c = new Cat();
		Dog d = new Dog();
		c.crying();
		d.crying();
		c.sound();
		d.sound();

	}

}

package days18;

abstract class AbstractAnimal {
	public abstract void sound(); //정의만 존재
}

class DogA extends AbstractAnimal{
	
	@Override
	public void sound() {System.out.println("멍멍");}
}

class CatA extends AbstractAnimal {
	
	@Override
	public void sound() {System.out.println("냐옹");}
}
public class Extend10_Abstract02 {
	public static void main(String[] args) {
		DogA dog = new DogA();
		CatA cat = new CatA();
		System.out.println("강아지 소리");
		dog.sound();
		System.out.println("고양이 소리");
		cat.sound();
	}
}

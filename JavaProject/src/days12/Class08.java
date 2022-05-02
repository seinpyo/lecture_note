package days12;

class Aclass{
	private int age;
	
	Aclass() {
		System.out.println("Aclass의 생성자 호출!");
		setAge(100);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}

public class Class08 {
	public static void main(String[] args) {
		
		Aclass a = new Aclass();
		System.out.println(a.getAge());
		// Aclass() 는 ()로 호출되는 메서드임 
		// -> 이때 호출되는 것이 생성자
		

	}

}

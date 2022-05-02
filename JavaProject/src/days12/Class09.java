package days12;

class Bclass {
	
	private int age;
	Bclass () { } 	// 디폴트 생성자
	//이것만 있으면 생성자를 정의하지 않은 것과 같은 동작을 한다.
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
public class Class09 {
	public static void main(String[] args) {
		
		Bclass b = new Bclass();

	}

}

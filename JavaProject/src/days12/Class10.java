package days12;

class Cclass {
	
	private int age;
	
	Cclass () {}
	Cclass(int a) {
		age = a;
	}

	public int getAge() { return age; }

	public void setAge(int age) { this.age = age; }
}

public class Class10 {
	public static void main(String[] args) {
		
		Cclass c1 = new Cclass(20);	
		Cclass c2 = new Cclass(30);
		Cclass c3 = new Cclass();
		
	}
}

package days15;

// extends의 활용

class Car {		//부모 클래스의 선언
	int engine;
	int volume;
	int door;
	
}

class K7 extends Car{ 	//자식 클래스의 선언
	public void printInfo() {		//자식 클래스에서 부모클래스의 멤버변수 사용
		System.out.printf("엔진 : %d\n", this.engine);
		System.out.printf("배기량 : %d\n", this.volume);
		System.out.printf("도어 : %d\n", this.door);
	}
}


public class Extends02 {
	public static void main(String[] args) {
		
		K7 k = new K7();
		k.engine = 6; k.volume = 3000; k.door = 4;
		k.printInfo();

	}

}

package days13;

// recap - class

class Human {
	
	String name;
	int age;
	String phone;
	
}
public class Class001 {
	public static void main(String[] args) {
		
		Human h1 = new Human();
		Human h2 = new Human();
		
		h1.name = "홍길동";
		h1.age = 30;
		h1.phone = "010-2222-3333";
		
		h2.name = "고길동";
		h2.age = 40;
		h2.phone = "010-6543-2123";
		
		Human[] h = new Human[10]; // 객체 배열 
		// h[0]에 name, age가 모두 포함됨
		
		Human h3; // 참조변수 선언
		h3 = new Human(); // 힙에 새로운 인스턴스 생성 후 주소(참조값) 저장 
		Human h4 = new Human();	// 한 줄로 줄이기
		h3.name = "서길동";
		h4.name = "남궁길동";
		h3.age = 20;
		h4.age = 50;
		h3.phone = "010-1234-1234";
		h4.phone = "010-1114-1114";
		
		System.out.printf("이름 : %s, 나이 : %d, 전화번호 : %s", h1.name, h1.age, h1.phone);
		
		Human h5 = new Human();
		System.out.println();
		
		
	}

}

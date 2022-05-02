package days13;

//각각 호출되는 생성자에서 scores 변수에 3개짜리 배열의 주소를 저장하는 명령을 공통으로 넣기
// 매개변수가 없는 생성자는 모든 변수를 임의의 값으로, 이름만 전달되는 생성자는 점수만 임의로
// 이름과 점수가 전달되는 생성자는 전달값으로 변수에 대입하라

class Std {
	
	private int bun;
	private String name;
	private int[] scores;
	
	Std() {
		scores = new int[3];
		bun = 1;
		name = "아무개";
		scores[0] = 30;
		scores[1] = 40;
		scores[2] = 50;
		
		
	}
	Std(String name) {
		scores = new int[3];
		bun = 2;
		this.name = name;
		scores[0] = 30;
		scores[1] = 40;
		scores[2] = 50;
		
	}
	Std(String name, int a, int b, int c) {
		bun = 3;
		scores = new int[3];
		this.name = name;
		scores[0] = a;
		scores[1] = b;
		scores[2] = c;
	
	}
	
	Std(Std a) {
		Std s1 = new Std();
		scores = new int[3];
		bun = 4;
		this.name = a.name;
		scores[0] = a.scores[0];
		scores[1] = a.scores[1];
		scores[2] = a.scores[2];
		
	}
	
	void prn() {
		System.out.println();
		System.out.printf("%d번 %s ", bun, name);
		System.out.printf("국어점수 : %d, 영어점수 : %d, 수학점수 : %d", this.scores[0], this.scores[1], this.scores[2]);
	}
	
}
public class Class007 {
	public static void main(String[] args) {

		Std s1 = new Std();
		Std s2 = new Std("홍길동");
		Std s3 = new Std("고길동", 98, 97, 86);
		Std s4 = new Std(s3);
		s1.prn();
		s2.prn();
		s3.prn();
		s4.prn();
		
		
	}

}

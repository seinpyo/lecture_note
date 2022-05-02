package days14;

//static 변수를 이용하여 번호를 출력하는 성적표 만들기

class Student{
	private int bun;
	private String name;
	private int[] scores;
	static int count = 0;
	
	Student(){
		scores = new int[3];
		count++;
		bun = count;
	}
	
	Student(String name) {
		this();
		this.name = name;
	}
	
	Student(String name, int kor, int eng, int mat){
		this(name);
		scores[0] = kor;
		scores[1] = eng;
		scores[2] = mat;
	}
	
	Student(Student s) {
		this(s.name, s.scores[0], s.scores[1], s.scores[2]);
	
	}
	
	void prn() {
		System.out.println();
		System.out.printf("%d번 %s ", bun, name);
		System.out.printf("국어점수 : %d, 영어점수 : %d, 수학점수 : %d", this.scores[0], this.scores[1], this.scores[2]);
	}
}


public class Class20 {

	public static void main(String[] args) {
		
		Student s1 = new Student("홍길동", 98,69,87);
		Student s2 = new Student("고길동", 86,64,81);
		Student s3 = new Student("서길동", 58,67,72);
		Student s4 = new Student(s3);
		
		s1.prn();
		s2.prn();
		s3.prn();
		s4.prn();
	}

}

package days13;

class Student {
	private int bunho;
	private String name;
	private int[] scores;			//성적 저장용 배열
	private String[] subjects = {"국어", "영어", "수학"};		
	private int tot;				//총점 저장
	private double avg;				//평균 저장
	private char grade;				//학점 저장
	
	Student() {
		scores = new int[subjects.length];
	}
	
	Student(String name) {
		this();
		this.name = name;
	}
	
	Student(String name, int a, int b, int c) {
		this(name);
		scores[0] = a;
		scores[1] = b;
		scores[2] = c;
		tot = a+b+c;
		avg = tot/3.0;
		switch((int)avg/10) {
		case 10: case 9: grade = 'A'; break;
		case 8: grade = 'B'; break;
		case 7: grade = 'C'; break;
		case 6: grade = 'D'; break;
		default : grade = 'F';
		}
	}
	
	Student copy1() {
		Student temp = new Student();
		temp.bunho = this.bunho;
		temp.name = this.name;
		for(int i=0; i<3; i++) {
			temp.scores[i] = this.scores[i];
		}
		return temp;
		
	}
	
	void copy2(Student b) {
		this.bunho = b.bunho;
		this.name = b.name;
		for(int i=0; i<3; i++) {
			this.scores[i] = b.scores[i];
		}
	}
	
	void prnInfo() {
		System.out.println("\t\t########성적표########");
		System.out.println("======================================================");
		System.out.println("이름 \t 국어 \t 영어 \t 수학 \t 총점 \t 평균 \t 학점");
	}
	
	void prn() {
		System.out.printf("%s \t %d \t %d \t %d \t %d \t %.1f \t %c\n", name, scores[0], scores[1], scores[2], tot, avg, grade);	
		
	}
	
}

//디폴트 생성자에서 배열 저장소를 할당하기

public class Class17 {
	public static void main(String[] args) {
		
		Student s1 = new Student("홍길서", 88, 99, 66);
		Student s2 = new Student("홍길동", 98, 87, 89);
		Student s3 = new Student("홍길남", 100, 100, 100);
		s1.prnInfo();
		s1.prn();
		
		

	}

}

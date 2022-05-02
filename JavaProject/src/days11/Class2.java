package days11;

class Student {
	
	int no;
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	double ave;

	
	Student() {}
	Student(int no, String name, int kor, int eng, int mat) {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	
	}
	

	public static double avg (int tot) {
		return tot/3.0;
	}
	
	
	public static void information() {
		System.out.println("\t\t###성적표###");
		System.out.println("==============================================");
		System.out.println("이름 \t 국어 \t 영어 \t 수학 \t 총점 \t 평균");
	}
	
	
	public static void prn (Student a) {
		System.out.printf("%s \t %d \t %d \t %d \t %d \t %.1f\n", a.name, a.kor, a.eng, a.mat, a.tot, a.ave);	
		
	}

	
}


public class Class2 {
	public static void main(String[] args) {
		
		Student s1 = new Student(1, "홍길동", 89, 87, 93);
		Student s2 = new Student(2, "고길동", 87, 25, 65);
		s1.tot = s1.kor+s1.eng+s1.mat;
		s2.tot = s2.kor+s2.eng+s2.mat;
		s1.ave = Student.avg(s1.tot);
		s2.ave = Student.avg(s2.tot);
		Student.information();
		Student.prn(s1);
		Student.prn(s2);
		
	}
}

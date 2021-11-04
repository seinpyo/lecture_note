package days14;
// 객체 배열
class Std {
	int bun;
	String name;
	int [] scores;
	static int count=0;
	
	Std() {
		scores = new int[3];
		bun = ++count;
		name = "std-" + bun;
	}
	
	Std(int a, int b, int c){
		this();
		scores[0] = a; scores[1] = b; scores[2] = c;
	}
}
public class Class27 {
	public static void main(String[] args) {
		Std[] std = new Std[5];	// 배열을 만드는 명령
		//std[0].bun = 1;	//err : std[0] = null (배열만 만들고 객체를 안만들음)
		
		//다섯개의 참조값(주소)를 저장할 수 있는 참조변수들의 배열을 생성해야 함 
		Std std0 = new Std(); //배열의 요소마다 new Std 를 실행한다.
		std[0] = new Std(70, 80, 90);
		std[1] = new Std(56, 47, 89);
		std[2] = new Std(86, 54, 62);
		std[3] = new Std(90, 82, 99);
		std[4] = new Std(38, 76, 100);
		
		for(int i=0; i<std.length; i++)
			std[i] = new Std();
	}

}

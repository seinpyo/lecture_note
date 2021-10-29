package days10;

public class Method03 {
	//매개 변수의 역할과 생명 주기
	
	public static void updateValue(int num) {
		num = 100;
		System.out.printf("updateValue의 num -> %d\n", num);
	}
	public static void main(String[] args) {
		
		int num = 10;
		System.out.printf("main의 num -> %d\n", num);
		updateValue(num);
		System.out.printf("main의 num -> %d\n", num);
	}

}

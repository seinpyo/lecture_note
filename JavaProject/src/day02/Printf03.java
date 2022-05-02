package day02;

public class Printf03 {
	public static void main(String[] args) {
		System.out.printf("\t\t\t ###성적표###\n");
		System.out.printf("--------------------------------------------------------------\n");
		System.out.printf("%3s\t%10s\t%3s\t%3s\t%s\t%s\t%5s\n","번호","이름","국어","영어","수학","총점","평균");
		System.out.printf("--------------------------------------------------------------\n");
		System.out.printf("%3d\t%10s\t%3d\t%3d\t%3d\t%3d\t%5.1f\n", 1, "홍길동", 9, 89, 72, 84+89+72, ((84+89+72)/3.0));
		System.out.printf("%3d\t%10s\t%3d\t%3d\t%3d\t%3d\t%5.1f\n", 2, "고길동", 32, 76, 100, 32+76+100, (32+76+100)/3.0);
		System.out.printf("%3d\t%10s\t%3d\t%3d\t%3d\t%3d\t%5.1f\n", 3, "최길동", 97, 88, 91, 97+88+91, (97+88+91)/3.0);
	}

}

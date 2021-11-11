package days19;

public class Exception01 {
	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {
			int k = (int) (Math.random() * 10);
			try {
				int result = 100 / k;
				System.out.println(result);
			} catch (ArithmeticException e) {
				System.out.println("0으로 나누었습니다");
			}
		}
	}
}


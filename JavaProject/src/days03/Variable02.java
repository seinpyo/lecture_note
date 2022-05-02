package days03;


import java.util.Scanner;

public class Variable02 {
	public static void main(String[] args) {
		int num1, num2;
		int result1;		// 덧셈, 뺄셈, 곱셈의 결과를 저장할 변수
		double result2;		// 나눗셈의 결과를 저장할 변수
		
		Scanner sc = new Scanner(System.in); // 화면 입력을 위한 준비코드
		System.out.println("첫번째 정수를 입력하세요");
		// 화면 입력을 위해서는 위 코드가 동작보다 반드시 위쪽에 작성
		num1 = sc.nextInt();
		// 컴파일러가 sc.nextInt() 명령을 만나면 커서를 깜빡이며 
		// 입력이 있을 때 까지 무한정 대기
		
		System.out.println("입력한 정수는 " + num1 + "입니다.");
		// 입력한 정수는 5입니다.
		
		System.out.println("두번째 정수를 입력하세요.");
		num2 = sc.nextInt();
		System.out.println("입력한 정수는 " + num2 + "입니다.");
		// 입력한 정수는 4입니다.
		
		result1 = num1 + num2;
		System.out.printf("%d + %d = %d\n", num1, num2, result1);	// 5 + 4 = 9
		result1 = num1 - num2;
		System.out.printf("%d - %d = %d\n", num1, num2, result1);	// 5 - 4 = 1
		result1 = num1 * num2;
		System.out.printf("%d x %d = %d\n", num1, num2, result1);	// 5 x 4 = 20
		result2 = (double) num1 / num2;
		System.out.printf("%d ÷ %d = %.1f\n", num1, num2, result2);	// 5 ÷ 4 = 1.3
		
		
		sc.close();
		
	}
}

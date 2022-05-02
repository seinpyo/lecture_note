package days19;

import java.util.*;

public class Exception07 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		while(true) {
//			try {
//				System.out.print("정수를 입력하세요 : ");
//				int num = sc.nextInt();
//				System.out.printf("입력한 정수는 %d입니다.\n", num);
//				break;
//			} catch (InputMismatchException e) {
//				sc.next();
//				System.out.println("잘못입력하셨습니다.\n");
//			}
		while(true) {
			try {
				System.out.print("정수를 입력하세요 : ");
				int num = Integer.parseInt(sc.nextLine());
				System.out.printf("입력한 정수는 %d입니다.\n", num);
				break;
			} catch (NumberFormatException e) {
				System.out.println("잘못입력하셨습니다.\n");
			}
		}
	}
}
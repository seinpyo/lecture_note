package days22;

import java.io.IOException;

public class IO01 {

	public static void main(String[] args) throws IOException {
//		
//		System.out.printf("글자나 숫자를 하나 입력하세요 : ");
//		int num = System.in.read();
//		System.out.printf("입력된 정수 : %d\n", num);
//		System.out.printf("입력된 문자 : %c\n\n", (char) num);

		int input;
		System.in.read();
		System.in.read();	
		System.out.print("키보드 입력을 실행하세요 : ");
		input = System.in.read();
		System.out.printf("\n입력된 값 : %d\n", input);
		System.out.printf("입력된 문자 : %c\n", (char)input);
	
	}

}

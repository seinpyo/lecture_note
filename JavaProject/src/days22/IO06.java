package days22;

import java.io.*;

public class IO06 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input; 
		System.out.print("정수를 입력하세요 : ");
		input = br.readLine();	//문자열 입력 받음
		int num = Integer.parseInt(input); //문자열을 정수전환
		System.out.printf("입력된 정수 : %d\n", num);
		System.out.print("실수를 입력하세요 : ");
		input = br.readLine();	
		Double d = Double.parseDouble(input);
		System.out.printf("입력된 실수 : %.2f\n", d);
		System.out.print("문자를 입력하세요 : ");
		char c = (char) br.read();
		System.out.printf("입력된 문자 : %c\n", c);
		br.close();
	}

}

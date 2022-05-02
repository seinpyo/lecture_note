package days22;

import java.io.IOException;

public class IO02 {
	public static void main(String[] args) throws IOException {
	
		byte[] input = new byte[20];
		System.out.printf("키보드 입력을 실행하세요 : ");
		int size = System.in.read(input);
		System.out.printf("\n읽어온 바이트의 크기는 %d입니다. \n", size);
		for(int i=0; i<input.length; i++) {
			System.out.printf("%c", (char) input[i]);
			
		}
	}
}

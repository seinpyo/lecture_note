package days22;

import java.io.IOException;
import java.io.InputStreamReader;

public class IO04 {
	public static void main(String[] args) throws IOException {
		
		InputStreamReader reader = new InputStreamReader(System.in);

		char[] message = new char[30];
		//아스키코드가 아닌 문자형으로 저장됨 
		
		System.out.print("메세지를 입력하세요 : ");
		int size = reader.read(message);
		System.out.printf("입력된 메시지는 %d 글자 입니다.\n", size);
		System.out.println(message);
		for(int i=0; i<message.length; i++) {
			System.out.printf("%c", message[i]);
		}
		
	}

}

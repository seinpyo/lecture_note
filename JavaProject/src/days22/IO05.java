package days22;

import java.io.*;

public class IO05 {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);
		
		System.out.print("메시지를 입력하세요 : ");
		String message = br.readLine(); //입력변수로 String 사용
		System.out.printf("입력된 메세지는 %d글자 입니다.\n", message.length());
		//String 타입이므로 length()사용
		System.out.println(message);

		br.close();
	}

}

package days23;

import java.io.*;

public class IO12 {
	public static void main(String[] args) throws IOException {
		
		File dir = new File("C:\\Users\\JAVA01\\git\\repository\\JavaProject\\temp");
		if(!dir.exists()) dir.mkdirs();
		
		File file_binary = new File(dir, "binary_data_using_buffer.dat");
		File file_text = new File(dir, "text_data_using_buffer.txt");
		
		//파일에 이진 데이터를 출력할 수 있는 객체 생성
		BufferedOutputStream bos_binary = new BufferedOutputStream(new FileOutputStream(file_binary));
		
		//파일에 문자 데이터를 출력할 수 있는 객체 생성
		BufferedWriter bw_text = new BufferedWriter(new FileWriter(file_text));
		
		//버퍼에 내용을출력
		//버퍼에 출력된 데이터는 해당 스트림이 close되거나 해당 스트림 객체에 대해서 flush메소드가 호출되면
		//실제 스트림을 통해 출력
		bos_binary.write(225);
		bos_binary.write(22);
		//flush 메소드는 버퍼에 쌓여있는 데이터를 출력하는 메소드(버퍼를 비우라는 명령을 실행)
		bos_binary.flush();
		
		bw_text.write("Hello ");
		bw_text.write("World");
		bw_text.flush();
		
//		bos_binary.close();
		bw_text.close();
		
		
	}

}
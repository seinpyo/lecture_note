package days23;

import java.io.*;

public class IO13 {
	public static void main(String[] args) throws IOException {
		File dir = new File("C:\\Users\\JAVA01\\git\\repository\\JavaProject\\temp");
		if(!dir.exists()) dir.mkdirs();
		
		File file_binary = new File(dir, "binary_data_using_buffer.dat");
		File file_text = new File(dir, "text_data_using_buffer.txt");
		
		//파일로 부터 이진 데이터를 읽어 올 수 있는 스트림 객체 생성
		BufferedInputStream bis_bynary = new BufferedInputStream(new FileInputStream(file_binary));
		//파일로 부터 텍스트 데이터를 읽어 올 수 있는 스트림 객체 생성
		BufferedReader br_text = new BufferedReader(new FileReader(file_text));
		
		int input;
		while((input = bis_bynary.read())!=-1) System.out.printf("%d ", input);
		System.out.println();
		while((input = br_text.read())!=-1) System.out.printf("%c", input);
		
		bis_bynary.close();
		br_text.close();
	}

}

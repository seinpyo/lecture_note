package days22;

import java.io.*;

public class IO08 {
	public static void main(String[] args) throws IOException {
	
		File dir = new File("C:\\StudybyMyself\\JavaProject\\temp");
		if (!dir.exists()) dir.mkdirs();
		File file_binary = new File(dir, "binary_data.dat");
		File file_text = new File(dir, "text_data.txt");
		
		FileOutputStream fos_binary = new FileOutputStream(file_binary);
		FileWriter fos_text = new FileWriter(file_text);
		
		//파일에 내용을 출력
		fos_binary.write(11);
		fos_binary.write(22);
		fos_text.write("Hello");
		fos_text.write("World");
		fos_binary.close();
		fos_text.close();
		
	}
}

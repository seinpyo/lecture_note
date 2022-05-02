package days23;

import java.io.*;

public class IO11 {
	public static void main(String[] args) throws IOException {
		
		File dir = new File("C:\\Users\\JAVA01\\git\\repository\\JavaProject\\temp");
		if(!dir.exists()) dir.mkdirs();
		
		File file_text = new File(dir, "abc.txt");
		FileReader fr_text = new FileReader(file_text);
		
		int data_text;
		while((data_text = fr_text.read())!= -1) 
			System.out.print((char)data_text);
		fr_text.close();	
		
	}

}

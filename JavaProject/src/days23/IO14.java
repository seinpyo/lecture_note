package days23;

import java.io.*;

public class IO14 {
	public static void main(String[] args) throws IOException {
		
		String CopyPath = "C:\\Users\\JAVA01\\git\\repository\\JavaProject\\copy";
		String OriginalPath = "C:\\Users\\JAVA01\\git\\repository\\JavaProject\\temp";
		String Filename = "eclipse-inst-jre-win64.exe";
		File originDir = new File(OriginalPath);
		File fileOriginal = new File(originDir, Filename);
		
		File copyDir = new File(CopyPath);
		if(!copyDir.exists()) copyDir.mkdirs();
		File fileCopy =new File(copyDir, Filename);

		
		//파일로 부터 데이터를 읽어 올 수 있는 스트림 객체 생성
		BufferedInputStream inputBinary = new BufferedInputStream(new FileInputStream(fileOriginal));
		
		//읽어온 데이터 출력을 위한 스트림 객체
		BufferedOutputStream outputBinary 
		= new BufferedOutputStream(new FileOutputStream(fileCopy));
	
		int input;
		while((input = inputBinary.read())!=-1) outputBinary.write(input) ;
	
		byte[] data = new byte[1024];
		int size;
		while((size = inputBinary.read(data))!= -1) outputBinary.write(data, 0, size);
		
		outputBinary.flush();
		inputBinary.close();
		
	}

}

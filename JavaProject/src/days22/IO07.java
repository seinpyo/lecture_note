package days22;

import java.io.File;
import java.io.IOException;

public class IO07 {
	public static void main(String[] args) throws IOException {
		File d = new File("C:\\StudybyMyself\\JavaProject\\temp");
		System.out.println("C:\\StudybyMyself\\JavaProject\\temp");
		
		if(d.exists()) {
			System.out.println("temp 디렉토리 발견");
		} else {
			System.out.println("temp 디렉토리를 새로 생성합니다.");
			d.mkdirs();
		}
		
		
		File f = new File(d, "msg.text");
		
		if(!f.exists()) f.createNewFile();
		
		System.out.printf("파일명 : %s\n", f.getName());
		System.out.printf("파일 전체 경로 : %s\n", f.getAbsolutePath());
		System.out.printf("파일의 크기 : %d\n", f.length());

	}

}

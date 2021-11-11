package days19;

import java.io.*;

public class Exception08 {

	static int cnt = 0;

	public static void main(String[] args) {

		File f1 = createFile("");
		File f2 = createFile("abc.txt");
		File f3 = createFile("");
	}

	private static File createFile(String fileName) {

		File f = null;
		try {
			if (fileName == null || fileName.equals(""))
				throw new IOException("파일 이름이 유효하지 않습니다.");
		} catch (IOException e) {
			fileName = "제목없음" + ++cnt + ".txt";
		} catch (Exception e) {
			System.out.printf("Exception 발생 -> ");
			e.printStackTrace();
		} finally {
			f = new File(fileName);
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println(fileName + "생성에 실패하였습니다.");
			}
		}
		return null;
	}

}

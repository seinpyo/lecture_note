package days23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class IO09 {

	public static void main(String[] args) throws IOException {
		
		//경로 확인 및 생성의 이유로 File 객체는 아래와 같이 두번 생성하여 완성한다
		
		//1. 경로 확인 (경로를 설정하고 없다면 만듦)
		File dir = new File("C:\\Users\\JAVA01\\git\\repository\\JavaProject\\temp");
		if(!dir.exists()) dir.mkdirs();
		
		File file_binary = new File(dir, "binary_data.dat");
		File file_text = new File(dir, "text_data.txt");
		
		//파일로 부터 이진 데이터를 읽어올 수 있는 스트림 객체를 생성
		FileInputStream fis_bynary = new FileInputStream(file_binary);
		FileReader fr_text = new FileReader(file_text);
		//파일의 존재와 오픈의 오류는 디스크 상의 문제이므로 명령으로 해결할 수 없습니다.
		//따라서 파일 입출력 (또는 화면입출력)은 항상 예외처리필요 
	
		//이진 데이터를 읽어와서 출력
		int data_binary;
		data_binary = fis_bynary.read();
		System.out.println(data_binary);
		data_binary = fis_bynary.read();
		System.out.println(data_binary);
		
		//text데이터는 한글자씩 읽어온다.(반복실행문)
		//인ㅂ력 데이터의 저장형식은 반드시 int타입으로 문자값을 전달 받아야한다.
		//파일끝에 도달하면 -1 값이 읽혀지고 char은 부호가 없는 자료형이므로 -값을 처리할 수 없어
		//파일의 끝으로 인식되지 않기 때문에 char형으로 읽어낸다면 무조건 양수로만 취급하여
		//반복을 빠져나올 수 없다.
		int data_text;
		while((data_text = fr_text.read())!= -1) 
			System.out.print((char)data_text);
		fr_text.close();	
	}

}

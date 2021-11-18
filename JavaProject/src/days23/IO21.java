package days23;

//IO 시험

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IO21 {
	public static void main(String[] args) {
	
		//특정 날짜를 입력받아 그 날짜 파일만을 출력하기
		//날짜 입력 양식을 정해서 잘못된 입력은 다시 입력 받게 설정
		
		System.out.print("출력할 날짜를 입력하세요(2020-01-01)");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date inputDate;
		Date iDate;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//날짜를 형식대로 입력받기
		while(true) {
			
			try {
				Scanner sc = new Scanner(System.in);
				String s = sc.nextLine();
				inputDate = sdf.parse(s);
				break; 
				// 윗줄에서 exception 발생시 실행 x
				// 정확히 입력한 경우에면 break; 실행
			} catch (ParseException e) {
				System.out.println("다시 입력해주세요 (입력 예 : YYYY-MM-DD)");
			}
		}
		
		//읽어올 파일 경로 설정
		
		File dir = new File("C:\\Users\\JAVA01\\git\\repository\\JavaProject\\temp");
		//폴더에서 모든 파일 목록을 불러온다
		String[] f = dir.list();
		for(String fn : f) System.out.println(fn);
		//파일 명들을 이용한 반복실행문을 실행하여 입력한 파일만을 대상으로 내용을 읽은 후 화면 출력
		
		for (int i=0; i<f.length; i++) {
			//파일 이름과 입력한 날짜와 비교해서 같은 것 만 출력하시오
			//f[i]의 일부와 inputDate와 비교
		}

	}

}

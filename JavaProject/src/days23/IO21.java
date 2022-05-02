package days23;

import java.io.BufferedInputStream;

//IO 시험

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import days23.CalculatorResult;

public class IO21 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
	
		//특정 날짜를 입력받아 그 날짜 파일만을 출력하기
		//날짜 입력 양식을 정해서 잘못된 입력은 다시 입력 받게 설정
		
		System.out.println("출력할 날짜를 입력하세요(2020_01_01)");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
		Date inputDate;
		Date iDate;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		//날짜를 형식대로 입력받기
		while(true) {
			try {
				String s = sc.nextLine();
				inputDate = sdf.parse(s);
				break; 
				// 윗줄에서 exception 발생시 실행 x
				// 정확히 입력한 경우에면 break; 실행
			} catch (ParseException e) {
				System.out.println("다시 입력해주세요 (입력 예 : YYYY_MM_DD)");
			} catch (Exception e) {
				System.out.println("다시 입력해주세요 (입력 예 : YYYY_MM_DD)");
			}
		}
		
		//읽어올 파일 경로 설정
		
		String input = sdf.format(inputDate);
//		System.out.println(input);
		File dir = new File("C:\\StudybyMyself\\JavaProject\\temp");
		//폴더에서 모든 파일 목록을 불러온다
		String[] f = dir.list();
		
		for (int i=0; i<f.length; i++) {
			//파일 이름과 입력한 날짜와 비교해서 같은 것 만 출력하시오
			//f[i]의 일부와 inputDate와 비교
			if(f[i].contains(input)) {
				
				System.out.println(f[i]);
				File file = new File(dir, f[i]);
				ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
				
				ArrayList<CalculatorResult> list = (ArrayList<CalculatorResult>)ois.readObject();
				
				for(int j = 0; j<list.size(); j++) System.out.printf("%d. %s \n", j+1, list.get(j));
				ois.close();
				System.out.println();
			}
		}
	}
}

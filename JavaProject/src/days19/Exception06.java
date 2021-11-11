package days19;

import java.text.*;
import java.util.*;

public class Exception06 {
	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner sc = new Scanner(System.in);
		
		Date inDate = null;
		System.out.println("날짜를 예와 같이 입력해주세요");
		System.out.println("(입력 예 : 2015-12-31)");
		
		while(true) {
	
			try {
				String s = sc.nextLine();
				inDate = sdf.parse(s);
				break; // 윗줄에서 exception 발생시 실행 x
				// 정확히 입력한 경우에면 break; 실행
			} catch (ParseException e) {
				System.out.println("다시 입력해주세요 (입력 예 : YYYY-MM-DD)");
			}
		}
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(sdf2.format(inDate));
	}
}

package days17;

import java.util.Calendar;

public class CalendayClass02 {
	
	static String[] weekday = {"","일", "월","화","수","목","금","토"};
	
	public static void main(String[] args) {
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		//date1 달력 객체의 오늘 날짜를 2015년 8월 15일로 설정
		date1.set(2015, 7, 15);
		//set : 원하는 특정 날짜로 객체내 날짜 구성을 재설정, date2는 아직 오늘 날짜
		
		//set 메서드에 필드명과 값을 넣어주면 해당 필드값만 변경됨
		date2.set(Calendar.MONTH, 6); // -> 월만 7월로 바뀜 (월은 0~11)
		
		//위 date1과 date2에 설정된 날짜를 "000년 0월 0일 0요일" 형식으로 출력하기
		//System.out.println();안에 한번에 구성하여 출력하시오
		
		//date 1 
//		System.out.printf("%d년 %d월 %d일 %s요일",
//				date1.get(Calendar.YEAR), (date1.get(Calendar.MONTH))+1, date1.get(Calendar.DATE), 
//				weekday[date1.get(Calendar.DAY_OF_WEEK)]);
//		
//		System.out.println();
//		//date2
//		System.out.printf("%d년 %d월 %d일 %s요일",
//				date2.get(Calendar.YEAR), (date2.get(Calendar.MONTH))+1, date2.get(Calendar.DATE), 
//				weekday[date2.get(Calendar.DAY_OF_WEEK)]);
		
		prnDate(date1);
		prnDate(date2);

	}
	
	public static void prnDate(Calendar a) {
		
		System.out.printf("%d년 %d월 %d일 %s요일\n",
				a.get(Calendar.YEAR), (a.get(Calendar.MONTH))+1, a.get(Calendar.DATE), 
				weekday[a.get(Calendar.DAY_OF_WEEK)]);
	}

}

package days17;

import java.util.Calendar;

public class CalendayClass04 {

	public static void main(String[] args) {
		
		Calendar date = Calendar.getInstance();
		date.set(2021,10,30);
		System.out.println(toDate(date));
		
		System.out.println("= 1일 후 =");
		date.add(Calendar.DATE, 1);
		System.out.println(toDate(date));
		//add 메서드의 증감은 하나의 요소를 변경하지만 그로 인해 다른 필드에 영향을 줄 수 O
		//11월 30일 +1일 => 12월 1일, 2021년 12월 +1월 => 2022년 1월
		
		System.out.println("= 6달 후 =");
		date.add(Calendar.MONTH, 6);
		System.out.println(toDate(date));
		
		System.out.println("= 40일 후(roll) =");
		date.roll(Calendar.DATE, 40);
		//다른 필드에 영향을 주지 않고 해당 필드만 더하고 빼는 메서드
		// 3월 1일에 30일을 더하면 3월 31일이 되고 이후 10이 더해져 다시 10이 나옴
		// 월에는 영향을 주지 않음 
		// roll -> 해당 월에서 뱅글뱅글 돌며 숫자세기
		System.out.println(toDate(date));
		
	}
	public static String toDate(Calendar c) {
		String cDate = c.get(Calendar.YEAR) + "년 "
			+ (c.get(Calendar.MONTH)+1) + "월 "
			+ c.get(Calendar.DATE) + "일\n";
		return cDate;
	}

}

package days17;

import java.util.Calendar;

public class CalendayClass01 {

	public static void main(String[] args) {
	
		Calendar today = Calendar.getInstance(); //싱글턴패턴
		Calendar tomorrow = Calendar.getInstance(); //today와 같은 주소값을 가진다.
		
		
		System.out.println(Calendar.YEAR); 
		//get 메서드는 스태틱 파이널 변수에 해당하는 날짜요소를 얻어주는 메소드
		System.out.println("년도 :  " + today.get(Calendar.YEAR));
		System.out.println("년도 :  " + today.get(1));
		
		int i = today.get(Calendar.MONTH);
		System.out.println("월 : (0~11)" + i + "월");
		//MONTH로 얻어낸 값은 0=1월, 1=2월 ... 11=12월이므로 +1
		System.out.println("월 : (1~12)" + (i+1) + "월");
		System.out.println();
		
		
		i = today.get(Calendar.DATE);
		System.out.println("이 달의 몇 일 : " + i);
		i = today.get(Calendar.WEEK_OF_YEAR);
		System.out.println("금년의 몇 째 주 : " + i);
		i = today.get(Calendar.WEEK_OF_MONTH);
		System.out.println("이 달의 몇 째 주 : " + i);
		i = today.get(Calendar.DAY_OF_YEAR);
		System.out.println("금년의 며칠째 : " + i);
		System.out.println();
		
		i = today.get(Calendar.DAY_OF_WEEK);
		System.out.println("요일(1~7)" + i);
		i = today.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		System.out.println("이 달의 몇 째 요일 : " + i); //두번째 화요일
		System.out.println("이 달의 마지막 날 : " + today.getActualMaximum(Calendar.DATE));
		System.out.println();
		
		System.out.println("오전_오후(0:오전, 1:오후) : " + today.get(Calendar.AM_PM));
		System.out.println("시간(0~11) : " + today.get(Calendar.HOUR));
		System.out.println("시간(0~23) : " + today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~59) : " + today.get(Calendar.MINUTE));
		System.out.println("초(0~59) : " + today.get(Calendar.SECOND));
		System.out.println("1000분의 1초(0~999) : " + today.get(Calendar.MILLISECOND));
		//프로그램이 시작되어 Calenday인스턴스가 만들어진 시점
		//시:분:초:1/1000초
		
		
	}

}

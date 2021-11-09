package days17;

import java.util.*;

public class CalendayClass05 {
	public static void main(String[] args) {

		int year, month;
		int input = 0;
		Scanner sc = new Scanner(System.in);
		System.out.printf("년도 입력 : ");
		year = sc.nextInt();
		System.out.printf("월 입력 : ");
		month = sc.nextInt();

		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();

		sDay.set(year, month - 1, 1); // 입력한 년, 월, 1일로 시작일 설정
		eDay.set(year, month, 1); // 입력한 월의 다음 달의 1일
		eDay.add(Calendar.DATE, -1); // -1일을 계산해서 이달 말일로 설정

		while (input != 3) {

			// sDay 1일의 요일 계산
			int START_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

			System.out.println("\n\t\t   " + sDay.get(Calendar.YEAR) + "년 " + (sDay.get(Calendar.MONTH) + 1) + "월 ");
			System.out.println("----------------------------------------------------");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			System.out.println("----------------------------------------------------");

			// 1일자 까지 빈칸
			for (int i = 1; i < START_WEEK; i++)
				System.out.print("\t");
			// 1일부터 마지막 날짜까지 출력
			for (int i = 1; i <= eDay.get(Calendar.DATE); i++) {
				System.out.printf("%2d\t", i);
				if (START_WEEK++ % 7 == 0)
					System.out.println();
			}

			System.out.println("\n----------------------------------------------------");
			System.out.println("\n[1.지난달][2.다음달][3.종료]");
			input = sc.nextInt();

			if (input == 1) {
				sDay.add(Calendar.MONTH, -1);
				eDay.add(Calendar.DATE, 1); // 원래 월의 1일자로 설정
				eDay.add(Calendar.MONTH, -1); // 이전달 1일로 이동
				eDay.add(Calendar.DATE, -1); // 전전달 말일로 이동
				// 10월 31일에서 MONTH -1 하게되면 9월 31일은 존재하지 않으므로
				// 에러가 발생할 수 있다. 그것을 방지하기 위해 위와 같은 방법을 사용

			} else if (input == 2) {
				sDay.add(Calendar.MONTH, 1);
				eDay.add(Calendar.DATE, 1); // 원래 월의 1일자로 설정
				eDay.add(Calendar.MONTH, 2); // 다다음달 1일로 이동
				eDay.add(Calendar.DATE, -1); // 다음달 말일로 이동

			}

		}

	}

}

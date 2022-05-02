package days18;

import java.text.DecimalFormat;

public class FormatterClass03 {
	public static void main(String[] args) {
		
		DecimalFormat df = new DecimalFormat("0000");
		DecimalFormat df1 = new DecimalFormat("0000.00");
		DecimalFormat df2 = new DecimalFormat("0.00");
		double number = 123.123456;
		System.out.printf("%19s: %f -> %s\n", "0000", number, df.format(number));
		System.out.printf("%19s: %f -> %s\n", "0000.00", number, df1.format(number));
		System.out.printf("%19s: %f -> %s\n", "0.00", number, df2.format(number));
		//자리가 모자라면 포맷을 무시하고 채워넣는다.
		
		System.out.println();
		
		number = 123456.71289;
		df = new DecimalFormat("0.0000");
		System.out.printf("%19s: %f -> %s\n", "0.000", number, df.format(number));

		number = 123456789;
		df = new DecimalFormat("0,000");
		System.out.printf("%19s: %f -> %s\n", "0,000", number, df.format(number));
		
		number = 89.0;
		df = new DecimalFormat("0,000");
		System.out.printf("%19s: %f -> %s\n", "0,000", number, df.format(number));
		
		
		df = new DecimalFormat("#,###");
		System.out.printf("%19s: %f -> %s\n", "#,###", number, df.format(number));
		number = 123456.0;
		System.out.printf("%19s: %f -> %s\n", "#,###", number, df.format(number));
		
		number = 123456.7128;
		df = new DecimalFormat("#,###.###");
		System.out.printf("%19s: %f -> %s\n", "#,###.###", number, df.format(number));
		number = 123456.7;
		System.out.printf("%19s: %f -> %s\n", "#,###.###", number, df.format(number));
		
		number = 1234;
		df = new DecimalFormat("₩#,###.###원"); //단어 또는 기호 표시
		System.out.printf("%19s: %f -> %s\n", "₩#,###.###원", number, df.format(number));
		
		number = -1234.2;
		df = new DecimalFormat("#,###.### +; #,###.##-");
		//;을 기준으로 왼쪽은 양수 양식, 오른쪽은 음수 양식
		System.out.printf("%19s: %f -> %s\n", "#,###.### +; #,###.##-", number, df.format(number));
		
		number = 0.8539;
		df = new DecimalFormat("#.#%");	// 자동으로 100을 곱해서 %로 표시
		System.out.printf("%19s: %f -> %s\n", "#.#%", number, df.format(number));
		
		number = 123.172839;
		//소수점 첫째자리까지 표시
		System.out.println("123.172839 -> " + (int)(number*10)/10.0); //버림
		System.out.printf("123.172839 -> %.1f\n", number);
		df = new DecimalFormat("0.0");
		System.out.println("123.172839 -> " + df.format(number)); //반올림
		
	}
}

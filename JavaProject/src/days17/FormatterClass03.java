package days17;

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

	}
}

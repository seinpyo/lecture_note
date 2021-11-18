package days23;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

class CalculatorResult implements Serializable {
	private int leftValue;
	private int rightValue;
	private String operator;
	private double result;
	
	public CalculatorResult(int leftValue, int rightValue, String operator, double result) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
		this.operator = operator;
		this.result = result;
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return this.leftValue + " " + this.operator + " " + this.rightValue + " " 
				+ " = " + df.format(this.result);
	}
}

public class IO19 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		CalculatorResult a = new CalculatorResult(20, 30, "x", 6000.0);
//		System.out.println(a);	//20 x 30  = 6,000.00
		
		int leftValue, rightValue;
		String operator;
		double result = 0.0;
		
		ArrayList<CalculatorResult> history = new ArrayList<CalculatorResult>();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//String을 입력 받는것이 가능한 BufferedReader
		
		while(true) {
			System.out.printf("좌항을 입력하세요.");
			leftValue = Integer.parseInt(in.readLine());
			
			System.out.printf("연산 기호를 입력하세요.");
			operator = in.readLine();
			operator = operator.trim();
			//trim메소드는 문자열 앞뒤에 있는 공백을 제거(문자열 사이의 공백은 제거되지 않음.)
			
			System.out.printf("우항을 입력하세요.");
			rightValue = Integer.parseInt(in.readLine());
			
			//입력된 연산 부호에 따른 연산
			if(operator.equals("+")) result = leftValue + rightValue;
			else if(operator.equals("-")) result = leftValue - rightValue;
			else if(operator.equals("x")) result = leftValue * rightValue;
			else if(operator.equals("/")) result = leftValue / (double)rightValue;
			else if(operator.equals("%")) result = leftValue % rightValue;
			
			CalculatorResult temp = new CalculatorResult(leftValue, rightValue, operator, result);
			System.out.println(temp);
			
			//객체를 리스트에 넣고 계속할지 다시 입력받을지 
			history.add(temp);
			System.out.println("종료?(y/n)");
			char isExit = in.readLine().trim().charAt(0);
			if(isExit == 'y' || isExit == 'Y') break;
			}
			
			File dir = new File("C:\\Users\\JAVA01\\git\\repository\\JavaProject\\temp");
			if(!dir.exists()) dir.mkdirs();
			
			//현재 날짜,시간으로 파일 제목만들기
			Calendar c = Calendar.getInstance();
			Date now = c.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
			String fileName = sdf.format(now) + ".dat";
			
			File file = new File(dir, fileName);
			ObjectOutputStream oos 
			= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			oos.writeObject(history);
			oos.close();
			
	}

}

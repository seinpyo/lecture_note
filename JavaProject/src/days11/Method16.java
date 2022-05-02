package days11;

public class Method16 {
	public static void main(String[] args) {
		
		// cals 생성 (전달된 문자열에 따라서 입력된 숫자들의 평균 또는 합계를 출력하는 메서드)
		
		cals("합계", 98,78,45,12,23,87,69,59);
		System.out.println();
		cals("평균", 98,78,45,12,23,87,69,57,64,25);

	}

	public static void cals (String str, int ... a) {
		int sum = 0;
		for(int i=0; i<a.length; i++) sum+=a[i];
		if (str == "합계") System.out.println("입력된 정수의 총합은 : " +  sum);
		else {	
			double avg = (double)sum/a.length;
			System.out.printf("입력된 정수의 평균은 : %.1f", avg);
		}
	}
}

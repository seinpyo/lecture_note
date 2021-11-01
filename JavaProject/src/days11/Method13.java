package days11;

public class Method13 {
	public static void main(String[] args) {
		
		//메서드 오버로딩
		
		int max_result = max(78,51,67);
		prn(max_result);
		max_result = max(56,87);
		prn(max_result);
		double max_resultD = max(123.45, 456.56);
		prn(max_resultD);
		
	}

	public static double max(double d, double e) {
		return Math.max(d, e);
	}

	public static int max(int i, int j) {
		return Math.max(i, j);
	}

	public static int max(int i, int j, int k) {
		return  (i>j)? i : (j>k)? j : k;
	}

	public static void prn(int result) {
		System.out.printf("가장 큰 값은 %d입니다\n", result);
		
	}
	
	public static void prn(double result) {
		System.out.printf("가장 큰 값은 %.2f입니다.\n", result);
	}
}

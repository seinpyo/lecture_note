package days11;

public class Method12 {

	public static void main(String[] args) {
		
		int[] a = {56, 87, 96, 59, 25, 48, 13, 33, 65};
		int tot = 0;
		double ave;
		tot = sum(a); //배열의 합계
		ave = average(a);
		prn(a, tot, ave);

	}
	
	
	public static void prn(int[] a, int tot, double ave) {
		System.out.print("a[] = ");
		for(int k : a) System.out.print(k + " ");
		System.out.printf("\n배열의 총합 : %d", tot);
		System.out.printf("\n배열의 평균 : %.2f ", ave);
		
	}

	public static int sum(int[] arr) {
		int s=0;
		for(int i=0; i<arr.length; i++) {
			s += arr[i];
		}
		return s;
		
	}

	public static double average(int[] arr) {
		int tot = sum(arr);	// 사용자가 정의한 메서드들은 자유롭게 호출 가능
		return tot/arr.length;
	}
	
}

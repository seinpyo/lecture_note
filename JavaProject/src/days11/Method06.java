package days11;

public class Method06 {
	public static void main(String[] args) {
		
		int[] a = {56,54,87,89,25,36,57,98,59,87};
		
		// sum(a); 가 정상 실행되어서 배열 내 정수의 합계가 출력되도록
		// sum 함수를 제작하시오.
		
		sum(a);
		
		
	}
	
	public static void sum(int[] arr) {
		int s = 0;
		for(int i=0; i<arr.length; i++) {
			s += arr[i];
		}
		
		System.out.println(s);
		
	}
	
}

package days09;

public class Array02 {
	public static void main(String[] args) {
		
		int [] a1 = null;
		a1 = new int[5]; // new int 에 의해 5개의 정수가 0으로 초기화된다.
		
		int [] a2 = new int[5]; 
		
		System.out.println(a1[0] + " " + a1[1] + " " +a1[2] + " " + a1[3]);
		System.out.println(a2[0] + " " + a2[1] + " " +a2[2] + " " + a2[3]);
			

		int [] a3 = new int[] {1,2,3,4,5};
		System.out.println(a3[0] + " " + a3[1] + " " +a3[2] + " " + a3[3] + " " + a3[4] + " " );
		int [] a4 = {1,2,3,4,5};
		System.out.println(a4[0] + " " + a4[1] + " " +a4[2] + " " + a4[3] + " " + a4[4] + " ");
		a4[0] = 100;
		System.out.println(a3[0] + " " + a4[0]);
		
		int[] a5, a6;
		a5 = new int[3];
		a6 = new int[3];
		
		int a7[], a8[], a9;
		a7 = new int[3];
		a8 = new int[3];
		a9 = 10;
		
	}
}
package days09;

public class Array03 {
	public static void main(String[] args) {
	
		int [] a = new int[100];
		
		for(int i=0; i<100; i++) a[i] = i + 1;
		for (int i=0; i<100; i++) {
			System.out.printf("a[%d] = %d ", i, a[i]);
			if (i!=0 && i%10 == 0) System.out.println("");
		}
	}
}

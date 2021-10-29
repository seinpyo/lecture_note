package days10;

public class Array10 {
	public static void main(String[] args) {
		
		int a[] = new int[10];
		int b[] = new int[10];
		int c[] = new int[10];
		
		//3의 배수가 들어가는 배열
		System.out.print("a 배열 : ");
		for (int i = 0; i < a.length; i++) {
			a[i] = 3 * (i+1);
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
		
		//5의 배수가 들어가는 배열
		System.out.print("b 배열 : ");
		for (int i = 0; i < b.length; i++) {
			b[i] = 5 * (i+1);
			System.out.print(b[i]+" ");
		}
		
		System.out.println();
		
		//a배열과 b배열의 같은 인덱스의 합이 저장되는 c배열
		System.out.print("c 배열 : ");
		for (int i = 0; i < c.length; i++) {
			c[i] = a[i] + b[i];
			System.out.print(c[i]+" ");
		}
	}
}

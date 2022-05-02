package days10;

public class Array14 {
	public static void main(String[] args) {
		
		// 1차원 배열의 복사
		
		int[] a = {1,2,3,4,5};
		int[] b;
		
		b = a;
		
		for(int k : a) System.out.printf("%d ", k);
		System.out.println();
		for(int k : b) System.out.printf("%d ", k);
		System.out.println();
		
		a[2] = 100;
		
		for(int k : a) System.out.printf("%d ", k);
		System.out.println();
		for(int k : b) System.out.printf("%d ", k);
		
		// 위 경우는 a배열의 주소값을 b에 그대로 전달했기 때문에
		// a배열의 요소를 변경하면 b배열도 함께 변경된다 (배열명만 다르지 사실상 하나의 배열)
		
		// 1. b에게 새로운 주소값을 주기

		System.out.println();
		b = new int[5];
		for (int i=0; i<a.length; i++) b[i] = a[i];
		a[4] = 300;
		for(int k : a) System.out.printf("%d ", k);
		System.out.println();
		for(int k : b) System.out.printf("%d ", k);
		
		// 2.clone() 메소드 활용
		
		System.out.println();
		int[] c = a.clone();	//힙 영역에 배열의 복사본을 만들고 그 주소를 전달한다.
		a[1] = 200;
		for(int k : a) System.out.printf("%d ", k);
		System.out.println();
		for(int k : c) System.out.printf("%d ", k);
		
	
		// 2차원 배열의 복사 (clone메소드)
		
		System.out.println();
		int[][] d = {{1,2,3},{4,5,6}};
		int[][] e = d.clone();
		d[1][0] = 500;
		for(int i=0; i<e.length; i++) {
			for(int j=0; j<e[i].length; j++) {
				System.out.printf("%d ", e[i][j]);
			}
			System.out.println();
		}

		// 
		
		System.out.println();
		int[][] f = new int[d.length][d[0].length];
		for(int i=0; i<f.length; i++) {
			for(int j=0; j<f[i].length; j++) f[i][j] = d[i][j];
		}
		
		d[0][1] = 600;
		
		for(int i=0; i<d.length; i++) {
			for(int j=0; j<d[i].length; j++) {
				System.out.printf("%d ", d[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------------");
		for(int i=0; i<f.length; i++) {
			for(int j=0; j<f[i].length; j++) {
				System.out.printf("%d ", f[i][j]);
			}
		System.out.println();
		}
		
	}
}

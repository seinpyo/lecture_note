package days10;

public class Array11 {

	public static void main(String[] args) {
		
		// 2차원 배열의 생성
		
		int[][] arr = new int[3][2];
		
		// 출력 (arr1[i] i번째 행의 값을 출력한다 
		int[][] arr1 = {{1,2},{3,4},{5,6}};
		for(int k : arr1[1]) System.out.print(k+" ");
		
		System.out.println();
		// 2차원 배열을 생성하면서 초기화하기
		int [][] arr3 = new int[][] {{1,2,3},{4,5,6}};
		System.out.print(arr3[0][2] + " ");
		System.out.print(arr3[1][1]);
		
		System.out.println();
		int [][] arr4 = new int[][] {{1,2},{4,5},{6,7}};
		System.out.print(arr4[0][1] + " ");
		System.out.print(arr4[1][1]);
		
		// 2차원 배열 생성 후 2중 반복 실행문에 의한 값 저장 & 출력
		
		System.out.println();
		int k = 1;
		int[][] a = new int[5][5];
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				a[i][j] = k++;
			}
		}
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.printf("%d\t", a[i][j]);
			}
			System.out.println();
		}
		
		// 향상된 for문을 이용한 2차원 배열 출력
		
		System.out.println();
		for(int[] k1 : a) {
			for(int k2 : k1) {
				System.out.printf("%d\t", k2);
			}
			System.out.println();
		}

	}
}


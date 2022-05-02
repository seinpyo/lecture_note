package days10;

public class Array12 {
	public static void main(String[] args) {
		
		// 2차원 배열은 각 행에 속한 열의 요소가 서로 다를 수 있다.
		// 2차원 배열 변수 선언
		
		int[][] a; // 배열을 위한 참조 변수만 생성한 상태
		
		// 각 1차원 배열들의 주소를 저장할 참조변수들의 배열을 만들어 주소를 전달 
		// 실제 데이터 저장 배열들은 아직 생성 전
		
		a = new int[3][];
		
		// 3개의 참조 변수에 3개의 1차원 배열을 생성하여 주소를 전달
		
		a[0] = new int[3];
		a[1] = new int[5];
		a[2] = new int[2];
		
		int num=1;
		for (int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				a[i][j] = num++;			
			}
		}
		
		for(int[] k : a) {
			for(int k1 : k) {
				System.out.printf("%d\t",k1);
			}
			System.out.println();
		}
		
	}
}


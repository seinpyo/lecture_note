package days16;

class ArrayMethod {
	public static void input(int[][] a) {
		int cnt = 1;
		int row = 0;
		for (int i = 0; i < a.length; i++) {
			if (i < 5) {
				a[i] = new int[++row];
				for (int j = 0; j < a[i].length; j++) {
					a[i][j] = cnt++;
				}
			} else {
				a[i] = new int[--row];
				for (int j = 0; j < a[i].length; j++) {
					a[i][j] = cnt++;
				}
			}

		}

	}

	public static void prn(int[][] a) {

		for (int[] k : a) {
			for (int k1 : k) {
				System.out.printf("%d\t", k1);
			}
			System.out.println();
		}

	}

}

public class ArrayMethodTest {

	public static void main(String[] args) {
		int[][] a = new int[9][];
		ArrayMethod.input(a);
		ArrayMethod.prn(a);

	}

}

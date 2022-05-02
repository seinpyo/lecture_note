package days09;
public class Array05 {

	public static void main(String[] args) {
		
		int[] a = {56, 87, 96, 87, 45, 89, 69, 36, 13, 98};
		int max = a[0];
		int min = a[0];
 
		for(int i=1; i<a.length; i++) {
			if (max<a[i]) max = a[i];
			if (min>a[i]) min = a[i];
		}
		
		System.out.print("배열을 오름차순으로 정렬합니다 : ");

		for (int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				int tmp=0;
				if (a[i] > a[j]) { 
					tmp = a[i]; 
					a[i] = a[j];
					a[j] = tmp;
					}
			}

		}
		for(int k : a) System.out.print (k + " ");
		System.out.print("\n배열을 내림차순으로 정렬합니다 : ");
		
		for (int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				int tmp=0;
				if (a[i] < a[j]) { 
					tmp = a[i]; 
					a[i] = a[j];
					a[j] = tmp;
					}
			}

		}
		
		for(int k : a) System.out.print (k + " ");
		System.out.println("\n배열에서 가장 큰 값은 " + max + "입니다.");
		System.out.println("배열에서 가장 작은 값은 " + min + "입니다.");

	}

}
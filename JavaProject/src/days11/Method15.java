package days11;

public class Method15 {
	public static void main(String[] args) {
		
		sort("asc", 78, 25, 56, 32, 45, 78, 98);
		System.out.println();
		sort("desc", 87, 76, 12, 8, 78, 25, 56, 32, 45, 78, 98);
	}
	
	public static void sort(String op, int ... a) {
		// ...으로 처리할 데이터들을 다른 형의 참조변수보다 더 뒤에 입력해야한다.
		
		if(op.equals("asc")) {
			for(int i=0; i<a.length; i++) {
				for(int j=i+1; j<a.length; j++) {
					if(a[i]>a[j]) {
						int temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}
				}
			}
			System.out.print("asc : ");
			for(int k : a) System.out.print(k + " ");
		} else {
			for(int i=0; i<a.length; i++) {
				for(int j=i+1; j<a.length; j++) {
					if(a[i]<a[j]) {
						int temp = a[j];
						a[j] = a[i];
						a[i] = temp;
					}
					
				}
				
			}
			System.out.print("desc : ");
			for(int k : a) System.out.print(k + " ");		
		}
		
	}

}

package days10;

public class Method04 {
	public static void main(String[] args) {

		System.out.println("프로그램 시작");
		int[] a = {111,222,333};
		System.out.println("\nmain에서 출력");
		for(int i=0; i<a.length; i++) System.out.printf("a[%d] = %d\t",i,a[i]);
		
		updateValue(a);
		
		System.out.println(); // 전달인수로 참조값을 전달
		System.out.println("\nmain에서 출력");
		for(int i=0; i<a.length; i++) System.out.printf("a[%d] = %d\t",i,a[i]);
	}
	
	// int[] b => 전달인수로 주소가 전달되므로 매개변수도 주소를 저장할 참조변수가 와야함
		public static void updateValue(int[] arr) {
			
			System.out.println();
			arr[0] = 100; arr[1] = 200; arr[2] = 300; 
			System.out.println("\nupdateValue에서 출력");
			for(int i=0; i<arr.length; i++) System.out.printf("a[%d] = %d\t",i,arr[i]);
	}
}

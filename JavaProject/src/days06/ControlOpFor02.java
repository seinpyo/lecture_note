package days06;

public class ControlOpFor02 {
	public static void main(String[] args) {
		System.out.println("정수 출력-----------------------");
		int i = 0;
		for(i=1; i<=100; i++) {
			System.out.printf("%d ", i);
		}
		System.out.printf("\n반복 실행 후 i의 값 : %d\n", i);
		
		System.out.println("\n1부터 100 사이의 짝수 출력 #1---------------------");
		for(i=1;i<=100;i++) {
			if(i%2==0) System.out.printf("%d ", i);
		}
		System.out.printf("\n반복 실행 후 i의 값 : %d\n", i);
		
		System.out.println("\n1부터 100 사이의 짝수 출력 #2---------------------");
		for(i=2;i<=100;i+=2) System.out.printf("%d ", i);		
		System.out.printf("\n반복 실행 후 i의 값 : %d\n", i);
		
		System.out.println("\n1부터 100 사이의 홀수 출력 #1---------------------");
		for(i=1;i<=100;i++) {
			if(i%2==1) System.out.printf("%d ", i);
		}
		System.out.printf("\n반복 실행 후 i의 값 : %d\n", i);
		
		System.out.println("\n1부터 100 사이의 홀수 출력 #2---------------------");
		for(i=1;i<=100;i+=2) System.out.printf("%d ", i);
		System.out.printf("\n반복 실행 후 i의 값 : %d\n", i);
		
	}
}

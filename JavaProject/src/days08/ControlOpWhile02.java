package days08;

public class ControlOpWhile02 {
	public static void main(String[] args) {
		
		//1~100 짝수 출력하기 
		
		int i=2;
		while(i<=100) {		
			if((i)%2==0) System.out.printf("%d ", i);
			i++;
			if ((i-2)%20==0) System.out.println();
		}
	}
}

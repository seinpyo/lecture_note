package days06;

import java.util.Scanner;

public class ControlOpFor04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int x = sc.nextInt();
		for(int i=1; i<=9; i++) {
			int mul = x*i;
			System.out.printf("%d x %d = %d\n", x, i, mul);
//			System.out.println(x + " x " + i + " = " + (x*i));				
		}		
		sc.close();
	}
}

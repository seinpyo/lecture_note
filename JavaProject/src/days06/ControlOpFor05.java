package days06;

import java.util.Scanner;

public class ControlOpFor05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int x = sc.nextInt();
		int y = sc.nextInt();
		if (x>y) {
			for (int i=y; i<=x; i++) {System.out.print(i + " ");} 
			} else {
				for (int i=x; i<=y; i++) {
					System.out.print(i + " ");
			}
		}
		sc.close();
	}
}

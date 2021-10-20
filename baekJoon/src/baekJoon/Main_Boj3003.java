package baekJoon;

import java.util.Scanner;

public class Main_Boj3003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[6];
		
		for(int i=0;i<arr.length;++i) {
			int x = sc.nextInt();
			
			switch(i) {
			case 0 :
				System.out.println(1-x);
				break;
			case 1 :
				System.out.println(1-x);
				break;
			case 2 :
				System.out.println(2-x);
				break;
			case 3 :
				System.out.println(2-x);
				break;
			case 4 :
				System.out.println(2-x);
				break;
			case 5 :
				System.out.println(8-x);
				break;
			}
		}
		
		sc.close();
		
	}
}

package days09;

import java.util.*;

public class Array06 {
	public static void main(String[] args) {
		int[] a = new int[6];
		Random rd = new Random();
		int set = 0;
		

		System.out.println("이번주 로또 번호는 ?! ");
		
		while(set<5) {
		for(int i=0; i<a.length; i++) {
			a[i] = rd.nextInt();
			if (a[i] < 0) a[i] *= -1;
			a[i] = a[i] % 45 + 1;
			
			int j;
			for(j=0; j<i; j++) 
				if(a[i]==a[j]) break;
			
			if(i!=j) i--;

		}

		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i]>a[j]) {
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				}
			}
		}
		System.out.print(set+1 + "set : ");
		for(int k : a) System.out.print(k + " ");
		System.out.println();

		set++;
		}
	}
}

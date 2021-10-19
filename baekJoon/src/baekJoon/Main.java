package baekJoon;

//2845¹ø 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
       int b = sc.nextInt();
       int c = a*b;
       
       for(int i=0;i<5;i++) {
    	   int[] arr = new int[5];
    	   arr[i] = sc.nextInt();
    	   System.out.println(arr[i]-c); 	   
       }
      sc.close();
    }
}
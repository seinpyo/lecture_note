package days05;

import java.util.Scanner;

public class ControlOpIf04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int a = sc.nextInt();
		
		// 90이상 A, 80~89 B, 70~79 C, 60~69 D, 60미만 F를 출력하라 
		
		if(a>=90) {System.out.println("A");}
		else if (a>=80 && a<90) {System.out.println("B");}
		else if (a>=70 && a<80) {System.out.println("C");}
		else if (a>=60 && a<70) {System.out.println("D");}
		else {System.out.println("F");}
		
		if(a>=90) {System.out.println("A");}
		else if (a>=80) {System.out.println("B");}
		else if (a>=70) {System.out.println("C");}
		else if (a>=60) {System.out.println("D");}
		else {System.out.println("F");}
		
	
		if(a<60) {System.out.println("F");}
		else if (a>=60) {System.out.println("D");}
		else if (a>=70) {System.out.println("B");}
		else if (a>=80) {System.out.println("C");}
		else {System.out.println("A");}
		
		if(a<60) {System.out.println("F");}
		else if (a<70) {System.out.println("D");}
		else if (a<80) {System.out.println("B");}
		else if (a<90) {System.out.println("C");}
		else {System.out.println("A");}
		
		sc.close();
	}

}

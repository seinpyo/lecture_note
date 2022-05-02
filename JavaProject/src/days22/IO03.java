package days22;

import java.io.IOException;

public class IO03 {
	public static void main(String[] args) throws IOException {
		
		byte[] firstNumber = new byte[10];
		byte[] SecondNumber = new byte[10];
		System.out.printf("첫번째 정수를 입력하세요 : ");
		int size1 = System.in.read(firstNumber);
		System.out.printf("두번째 정수를 입력하세요 : ");
		int size2 = System.in.read(SecondNumber);
		
		System.out.println();
		
		int i, m, n1=0, n2=0; 
		for(i=size1-3, m=1; i>=0; i--, m*=10) {
			n1 += (firstNumber[i] - '0' ) * m;
			//입력된 수의 아스키코드에서 0의 아스키코드 값을 빼서
			//실제 정수값을 구한 뒤 10의 size승을 곱해 자릿수를 만든다
			System.out.printf("firstNumber[%d] - %d \t", i, firstNumber[i]-'0');
			System.out.printf("%d X %d => %d \t", firstNumber[i]-'0', m, (firstNumber[i]-'0')*m);
			System.out.println((n1));
		}
		
		System.out.println();
		
		for(i=size2-3, m=1; i>=0; i--, m*=10) {
			n2 += (SecondNumber[i] - '0' ) * m;
			//입력된 수의 아스키코드에서 0의 아스키코드 값을 빼서
			//실제 정수값을 구한 뒤 10의 size승을 곱해 자릿수를 만든다
			System.out.printf("SecondNumber[%d] - %d \t", i, SecondNumber[i]-'0');
			System.out.printf("%d X %d => %d \t", SecondNumber[i]-'0', m, (SecondNumber[i]-'0')*m);
			System.out.println((n2));
		
		}
		
		System.out.printf("\nfirstNumber + SecondNumber = %d + %d = %d", n1, n2, n1+n2);
		
	}

}

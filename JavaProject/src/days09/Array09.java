package days09;

import java.util.*;

public class Array09 {

	public static void main(String[] args) {
		
		//야구 게임 만들기
		
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int[] com = new int[3];
		int[] user = new int[3];
	
		
		//컴퓨터 배열을 만든다.
		for(int i=0; i<com.length; i++) {
			int num = rd.nextInt();
			if (num<0) num *= -1;
			com[i] = num%10;
			
			int j;
			for(j=0; j<i; j++) 
				if(com[i]==com[j]) break;
			if(i!=j) i--; 
			
		}			
		
			while(true) {
			//유저에게 숫자를 입력받는다.
			
	/*		방법1.
	 		System.out.println("\n숫자 세 개를 중복되지 않게, 띄어쓰기 없게 입력하세요.");
			int num = sc.nextInt();
			user[0] = num/100;
			user[1] = (num%100)/10;
			user[2] = num%10;
			
			for(int k : user) System.out.print(k + " "); */
			
	//		방법2.
			System.out.println("\n숫자 세 개를 중복되지 않게, 띄어쓰기 없이 입력하세요.");
			String num = sc.nextLine();
			user[0] = num.charAt(0) - '0';
			user[1] = num.charAt(1) - '0';
			user[2] = num.charAt(2) - '0'; 
			
			
	//		유저가 입력한 값과 컴퓨터가 가진 배열의 값을 같은지 검사한다.
			int ball=0;
			int strike=0;
			
			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					if(com[i] == user[j]) {
						if (i==j) strike++; 
						else ball++;
					}
				}
			}
			
			System.out.printf("스트라이크 : %d, 볼 : %d", strike, ball);
			if (strike==3) break;
			
		}
			
		System.out.println("\n축하합니다!");
	}

}

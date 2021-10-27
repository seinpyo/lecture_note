package days08;

import java.util.Random;

public class ControlOpWhile05 {
	public static void main(String[] args) {
		
		//난수를 발생시키기 위한 객체 생성
		Random rd = new Random();
		
		//변수에 난수를 제공받기 위해 rd.nextInt()
		int num = rd.nextInt();

		//발생된 난수가 음수라면 양수로 바꿔준다.
		if (num<0) num=num*-1;
		
		System.out.println(num);
		
		//한자리 숫자를 출력하기 위해 10으로 나눈 나머지를 출력한다.
		//(난수의 마지막 자리만 출력)
		System.out.println(num%10);
		
		int i = 0;
		while(i<10) {
			num = rd.nextInt();
			if(num<0) num *= -1;
			num %= 10;
			System.out.printf("%d ", num);
			i++;
		}
		
	}
}

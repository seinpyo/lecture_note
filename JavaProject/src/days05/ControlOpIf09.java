package days05;

import java.util.Scanner;

public class ControlOpIf09 {
	public static void main(String[] args) {
		
		//가위 바위 보 게임
		
		Scanner sc = new Scanner(System.in);
		String user;
		System.out.println("가위 바위 보 !");
		user = sc.nextLine();
		
		String com = "바위";
		// 랜덤 기능은 나중에
	
		if (user.equals(com)) {System.out.println("비겼습니다.");}
		
		else if (user.equals("가위") && com.equals("바위")) {System.out.println("졌습니다.");}
		else if (user.equals("바위") && com.equals("보")) {System.out.println("졌습니다.");}	
		else if (user.equals("보") && com.equals("가위")) {System.out.println("졌습니다.");}
		else {System.out.println("이겼습니다.");}
	
		sc.close();
	}
}

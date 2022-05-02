package days08;
import java.util.*;

public class ControlOpWhile06 {

	public static void main(String[] args) {

		// 난수를 이용해 가위바위보 게임 만들기
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		System.out.println("가위(1), 바위(2), 보(3)를 입력하세요.");
		System.out.println("종료하고 싶다면 0을 입력하세요\n");

		while (true) {

			System.out.println("가위 바위 보!");

			
			int user = sc.nextInt();
			int com = rd.nextInt();

			if (user == 0)
				break;
			if (user < 0 || user >= 4) {
				System.out.println("바르게 입력해주세요\n");
			}
			
			if(user > 0 && user < 4){
				if (com < 0)
					com *= -1;
				com %= 10;
				com = com % 3 + 1;
	
				switch (com) {
					case 1: {
						System.out.printf("com : %s vs ", "가위");
						break;
					}
					case 2: {
						System.out.printf("com : %s vs ", "바위");
						break;
					}
					case 3: {
						System.out.printf("com : %s vs ", "보");
						break;
					}
				}
	
				switch (user) {
					case 1: {
						System.out.printf("user : %s\n", "가위");
						break;
					}
					case 2: {
						System.out.printf("user : %s\n", "바위");
						break;
					}
					case 3: {
						System.out.printf("user : %s\n", "보");
						break;
					}
				}
	
				if (user == com) {
					System.out.println("##비겼습니다##");
				} else if (user == 1 && com == 2) {
					System.out.println("##졌습니다##");
				} else if (user == 2 && com == 3) {
					System.out.println("##졌습니다##");
				} else if (user == 3 && com == 1) {
					System.out.println("##졌습니다##");
				} else {
					System.out.println("##이겼습니다!##");
				}
	
				System.out.println("");
			}
		}

		System.out.println("가위 바위 보를 종료합니다.");
		sc.close();
		
	}
}
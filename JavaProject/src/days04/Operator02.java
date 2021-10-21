package days04;

public class Operator02 {
	public static void main(String[] args) {
		int n = 50;
		// 피 연산자로 쓰인 변수와 연산의 결과를 저장할 변수가 같은 연산
		n = n + 10;	//n 변수에 10을 누적
		// 1. 현재 n값(50)과 두번째 피연산지인 10이 CPU로 전달되어 연산
		// 2. 결과가 다시 n에 저장
		// -> 연산에 참여했던 50은 사라지고, 연산의 결과인 60이 n의 값이 된 것 
		System.out.println(n);
		n += 10;
		System.out.println(n);

		// 클래스 실행 단축키 ctrl+f11
		// 클래스 생성 단축키 -> 프로젝트 클릭 후 ctrl+n
		// 메소드 생성 단축키 ctrl+space
		
		System.out.println("n = n + 10 -> n : " + n);
		n -= 10;
		System.out.println("n = n - 10 -> n : " + n);
		n *= 10;
		System.out.println("n = n x 10 -> n : " + n);
		double d = 50.0;
		System.out.println("d의 최초값 : " + d);
		d /= 10.0;
		System.out.println("d = d / 10 -> d : " + d);
		n %= 10;
		System.out.println("n = n % 10 -> n : " + n);
		
		
		
		// 1씩 증가 또는 감소하는 증가/감소 연산자 ++, --
		// 특정 변수의 값을 1 증가하거나, 감소시킬 수 있는 연산자
		// 대입 연산자(=)를 사용하지 않고 값을 변경합니다.
		n = 50;
		n++;
		System.out.println("n++ -> n : " + n);
		++n;
		System.out.println("n++ -> n : " + n);
		
		// ++, -- 연산 기호가 앞 또는 뒤에 있을 때 차이가 나는 경우는 다른 연산에 섞여 있을 때
		n = 10;
		System.out.println("현재 n값 : " + n );
		// n++ 의 경우 : 현재값이 속해 있는 연산에 참여 후 1 증가
		int k = n++;
		System.out.println("k : " + k); // 10 출력
		System.out.println("n : " + n);	// 11 출력
		
		n = 10;
		// ++n의 경우 : 1 증가 후 다른 연산에 참여
		k = ++n;
		System.out.println("k : " + k); // 11 출력
		System.out.println("n : " + n);	// 11 출력
		
		
	}
	
	

}

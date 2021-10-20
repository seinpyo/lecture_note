package days03;

public class Variable06 {
	public static void main(String[] args) {
		
//		 정수형 : byte(1), short(2), int(4-기본형) -21억~21억, long(8)
//		 실수형 : float(4), double(8-기본형)
//		 문자형 : char(2-유니코드 지원)
//		 진위형 : boolean(1-ture /false의 값만 저장할 수 있음)
//		 문자열 : String(클래스, 정해진 크기가 없음)

		System.out.println(100); // 100은 정수형의 기본형인 int
		System.out.println(12.345); // 12.345는 실수형의 기본형인 double
		
		float k = 123.12f;
		
		// 변수의 다양한 선언(생성) 방법
		// 1. 변수 선언 후 값을 할당(대입)
		
		int n1;
		n1 = 10;
		
		// 2. 변수의 선언과 값의 대입을 동시에 처리
		int n2 = 20;
		
		// 3. 다수의 변수를 한 번에 선언하는 방법 (동일한 자료형만 가능)
		int n3,n4,n5;
		
		// 4. 다수의 변수를 값을 대입하며 생성하는 방법
		int n6 = 60, n7 = 70;
		
		// 5. 처음부터 모든 변수에 값을 대입할 필요는 없음
		int n8,n9 = 90, n10;
		
		// 변수의 선언 위치
		// 변수 사용 전이라면 위치에 관계없이 변수를 선언할 수 있음
		// 변수는 반드시 선언(생성) 후에 사용할 수 있다.
		int v1 = 10;
		System.out.println("프로그램 시작\nv1 변수의 값 : " + v1);
//		System.out.printf("v3 변수의 값 %d\n", v3); 
		// v3 변수는 선언되지 않았으므로 오류가 발생한다
		// "v3 cannot be resolved to a variable"
		int v3 = 30;
		System.out.printf("v3 변수의 값 : %d\n", v3);
		// v3 변수가 생성되면 코드가 정상 실행된다.
		int v4;
//		System.out.printf("v4 변수의 값 %d\n", v4); 
		// v4 변수값이 초기화되지 않았기 때문에 오류가 발생한다.
		// "The local variable v4 may not have been initialized"
		v4 = 40;
		System.out.printf("n4 변수의 값 : %d\n", 40);
		
		// 변수의 값은 여러번 대입할 수있으며, 가장 최근에 저장된 값이 사용된다.
		// 그 이전에 저장되는 값은 소멸 - 한번에 하나씩만 저장할 수 있다는 단점이 있음.
		n1 = 60;
		System.out.println("프로그램 실행중\n변경된 n1변수의 값 : " + n1);
		
		
	}
}

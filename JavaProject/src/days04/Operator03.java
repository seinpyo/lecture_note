package days04;

public class Operator03 {
	public static void main(String[] args) {
		// 관계연산자(비교연산자)
		// 좌항 기준 
		//	: >(초과), <(미만), >=(이상),<=(이하), ==(같다), !=(같지 않다.)
		// 좌항과 우항의 크기를 비교하여 true/false 값이 되는 연산
		// 관계식이 올바른 경우 true, 관계식시 틀린 경우 false를 반환
		
		int n1 = 10;
		int n2 = 5;
		boolean result;
		
		result = n1 > n2; 
		System.out.printf("%d > %d -> %b\n", n1, n2, result);
		result = n1 < n2; 
		System.out.printf("%d < %d -> %b\n", n1, n2, result);
		result = n1 >= n2; 
		System.out.printf("%d >= %d -> %b\n", n1, n2, result);
		result = n1 <= n2; 
		System.out.printf("%d <= %d -> %b\n", n1, n2, result);
		result = n1 == n2; 
		System.out.printf("%d == %d -> %b\n", n1, n2, result);
		result = n1 != n2; 
		System.out.printf("%d != %d -> %b\n", n1, n2, result);
		
		
		// 문자(char) 데이터의 비교 : 각 데이터가 갖는 아스키 코드 값으로 비교 
		char c1 = 'A', c2 = 'B';
		result = c1 > c2 ;
		System.out.printf("%c > %c -> %b\n", c1, c2, result);
		result = c1 < c2 ;
		System.out.printf("%c < %c -> %b\n", c1, c2, result);
		
		// String 데이터의 비교 
		String s1 = "1234", s2 = "987";
		// System.out.println(s1 + ">" + s2 + "->" + (s1>s2)); -> Err
		// 다른 자료형과는 다르게 String 변수는 직접 문자를 저장하지 않는다.(저장 위치 값만 저장)
		// 따라서 변수들간의 비교(s1>s2)는 저장 위치 정보의 비교이므로 연산이 불가능
		
		// String의 크기를 비교는 compareTo(),
		// 동일 여부는 equals() 메소드를 사용한다.
		
		int r = s1.compareTo(s2);
		// s1이 크면 양수를, s2가 크면 음수를 발생 & 변수 r에 저장. 같으면 0이 발생한다.
		// 앞글자(s1)에서 뒷글자(s2)의 아스키 코드값을 뺀 값(정수)를 결과로 얻는다.
		System.out.printf("%s > %s => %d\n", s1, s2, r); 
		r = s2.compareTo(s1);
		System.out.printf("%s > %s => %d\n", s2, s1, r);
		
		// s1.compareTo(s2); => s1 - s2가 주소끼리 연산되므로, 
		// 주소를 찾아가서 직접 글자를 가져다가 뺄셈을 대신해주는 도구
		// 따라서 결과는 int
		
		boolean b = s1.equals(s2); // 둘이 같으면 true, 다르면 false
		System.out.printf("%s == %s => %b\n", s1, s2, b);
		
	}

}

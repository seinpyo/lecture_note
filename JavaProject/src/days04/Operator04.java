package days04;

public class Operator04 {
	public static void main(String[] args) {
		// 논리 연산자 %%, ||, !
		// 다수개의 관계(비교)연산식 결과를 조합하여 하나의 boolean값을
		// 결과로 얻는 연산
		
		int a = 80;
		// a 변수의값이 70보다 크고 100보다 자긍면 true, 다르면 false
		boolean b;
		boolean b1 = a>70;
		boolean b2 = a<100;
		b = b1 && b2;
		// 위 새줄을 아래 한줄로 간단히 할 수 있다.
		b = (70<a) && (a<100);
		System.out.println("70 < a 이면서 a < 100 : " + b);
		
		a = 30;
		// a 변수의 값이 70보다 크거나 40보다 작으면 true, 크면 false
		b = (70<a) || (a<40);
		System.out.println("70 < a 이거나 a < 40 : " + b);
		
		
		// AND 연산자 (&&)
		// 좌항과 우항이 관계(비교)식 결과 또는 boolean값이 모두 true인 경우 true,
		// 하나라도 false인 경우 false가 결과값이 된다. 
		// 좌항의 비교연산 결과가 false인 경우 우항의 식을 비교하지 않는다.
		
		System.out.printf("F && F = %b\n", false && false); 
		System.out.printf("T && F = %b\n", true && false); 
		System.out.printf("F && T = %b\n", false && true); 
		System.out.printf("T && T = %b\n", true && true); 

		// OR 연산자 (||)
		// 좌항과 관계식 결과 또는 boolean값이 하나라됴 결과가 true인 경우 true
		// 좌항과 우항 모두 false인 경우 false
		// 좌항의 결과가 true인 경우 우항의 식을 비교하지 않는다.
		
		System.out.printf("F || F = %b\n", false || false); 
		System.out.printf("T || F = %b\n", true || false); 
		System.out.printf("F || T = %b\n", false || true); 
		System.out.printf("T || T = %b\n", true || true); 
		
		// NOT 연산자 (!)
		// 단항 연산자 (피연산자가 1개임)
		// 관계식의 결과의 반대로 결과를 냄 : true => false, false => true
		System.out.printf("Not %b = %b\n", false, !false);
		System.out.printf("Not %b = %b\n", true, !true);
		
		
		
		//예제1
		
		// 점수가 80점 이상이면서 90점 이하이면 true, 아니면 false
		int number = 80;
		boolean result = (number>=80) && (number <= 90);
		System.out.printf("result = %b\n", result);
		
		// 점수가 100이상이거나 50미만이면 true, 아니면 false
		number = 150;
		result = (number>=100) || (number < 50);
		System.out.printf("result = %b\n", result);
		
		
		//예제2
		
		int kor=35, eng=98, math=95;
		double avg = (double)(kor+eng+math)/3;
		
		// 평균이 80이상이면서 영어점수가 75점 이상이면 true 출력, 아니면 false
		result = (avg>=80) && (eng>=75);
		System.out.printf("result = %b\n", result);
		
		// 국어 50이상, 영어 60이상, 수학 70이상이면 true
		result = (kor>=50) && (eng>=60) && (math>=70);
		System.out.printf("result = %b\n", result);
	
		// 세과목 중 한 과목이라도 40 미만이라면 true
		result = (kor<40) || (eng<40) || (math<40);
		// = { result = !((kor>=40) &&(eng>=40) && (math>=40)); }
		System.out.printf("result = %b\n", result);
		
		// 평균 60 이상, 모든 과목 40 이상이라면 true
		result = (avg>=60) && (kor>=40) && (eng>=40) && (math>=40);
		System.out.printf("result = %b\n", result);
		
		// 국어 점수가 짝수면 true, 홀수라면 false
		result = kor%2 == 0;
		System.out.printf("result = %b\n", result);
		
		// 예제3
		// year 변수에 저장된 년도가 윤년이면 true, 평년이면 false;
		int year = 2020;
		int year2 = 2021;
		// 윤년의 조건 : 해당 년도의 4의 배수이면서, 100의 배수가 아니거나 400의 배수인 해
		result = (year%4==0) && !(year%100==0) || (year%100==0);
		System.out.printf("2020년은 윤년인가요? = %b\n", result);
		result = (year2%4==0) && !(year2%100==0) || (year2%100==0);
		System.out.printf("2021년은 윤년인가요? = %b\n", result);
		
	
	}

}

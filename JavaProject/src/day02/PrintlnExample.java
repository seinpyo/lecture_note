package day02;

public class PrintlnExample {
	public static void main(String[] args) {
		//printl.n()은 print/f("\n")와 같은 동작함.
				//printl.n은 \n이 없어도 모든 출력 후 줄바꿈을 한 번 실행.
				//System.out.println("\n"); -> 두번 줄바꿈.
				
				//print.f와 같이 format 양식 글자(%d, %f 등)을 사용하지 못한다.
				//print.f보다 출력이 간편한 장점
				System.out.println(10);
				System.out.println(12.123);
				System.out.println("Java Programming"); 
				
				System.out.println(10 + ", " + 12.123 + ", " + "Java Programming");
				// '+' 연산자는 문자와 다른 형식의 데이터가 연산되면, 이어붙이기
				// 숫자들끼리 '+'로 연결되면 산술 덧셈 연산이 된다
				
				// 문자와 숫자가 구별되는 점 
				// 1. 따옴표안에 쓰였는지 아닌지
				// 2. 123은 백이십삼 "123"은 일이삼
				// 3. 987은 1234보다 작지만, "987"은 "1234"보다 크다고 표현함 
				//		- 문자들간의 비교는 첫글자부터 하나씩 같은 위치의 글자와 비교
				//		- 첫글자에서 크기가 결정되면 그 다음은 비교하지 않는다.
				//		- 첫글짜가 같은 경우 두번째 글자를 비교
				//		- 두번째 글자도 같다면 세번째 비교 ...
				//		- 사전에서 찾았을 때 먼저 나오는 글자를 작다, 뒤에 나오는 글자를 크다고 평가
				//		- (a:작다~z:크다, ㄱ:작다~ㅎ:크다) air > apple
				
				System.out.println("10" + "5");
				System.out.println("10" + 5);
				System.out.println(10 + "5");
				System.out.println(10 + 5); 	//산술연산
				System.out.println("Hello" + " World~!");
				System.out.println(10 + " + " + 5 + " = " + 10 + 5); // 앞에서 부터 연산되어 = 뒤에 10이 붙고 5도 그냥 따라 붙는다
				System.out.println(10 + " + " + 5 + " = " + (10+5));
				System.out.println("10 + 5" + " = " + (10+5));
				System.out.println("10 + 5 = " + (10+5));
				System.out.println("10 + 5 = 1" + 5);
				System.out.println("10 + 5 = 15");
				
				System.out.printf("\n----------------------------------연습----------------------------------\n\n");
				
				System.out.println("\t\t\t ###성적표###");
				System.out.println("--------------------------------------------------------------");
				System.out.println("번호\t성명\t\t국어\t영어\t수학\t총점\t평균");
				System.out.println("--------------------------------------------------------------\n");
				System.out.println(1 + "\t" + "홍길동"+ "\t\t" + "9" + "\t"  + "89" + "\t" + "72" + "\t" + (84+89+72) + "\t" + ((84+89+72)/3.0));
				System.out.println(2 + "\t" + "고길동"+ "\t\t" + "91" + "\t"  + "100" + "\t" + "62" + "\t" + (91+100+62) + "\t" + ((91+100+62)/3.0));
				System.out.println(3 + "\t" + "이길동"+ "\t\t" + "66" + "\t"  + "63" + "\t" + "90" + "\t" + (66+63+90) + "\t" + ((66+63+90)/3.0));

	}

}

package day02;

public class PrintfExample {

	public static void main(String[] args) {
		//이스케이프 문자 - & : 아직 출력의 내용으로 결정되지 않은 데이터의 출력자리를 마련
				// 출력 자리를 마련해둔다.
				// %d:정수, %f:실수, %s:문자열 등
				// 그 자리에 출력될 내용은 ""가 끝난 후 ','로 구분하고 작성 
				System.out.printf("56 * 69 = %d\n", 1234);
				
				//간단한 연산을 출력 내용에 포함할 수 있다.
				System.out.printf("56 * 69 = %d\n", 56*69); 
				
				// % 이스케이프 문자는 갯수에 상관 없이 필요한 만큼 구성하여 사용 가능
				System.out.printf("%d × %d = %d\n", 23, 87, 23*87);
				
				//소수점이 있는 실수의 출력
				System.out.printf("%d ÷ %d = %f\n", 27, 13, 27/13.0);
				// 27/13으로 작성하면 에러가 발생함
				// %f는 소수점 6자리까지 표시 (비는 자리는 0으로 표시) -> 4/2.0 = 2.000000
				System.out.printf("%d ÷ %d = %.2f\n", 27, 13, 27/13.0);
				// %f앞에 .n 형식으로 소수점 몇째자리까지 표시할지 지정할 수 있다.
				
				// 문자열 속 문자열의 출력
				System.out.printf("%s 꽃이 피었습니다.\n", "무궁화");
				
				// 사칙 연산의 결과 출력 : %연산 - 나눗셈의 나머지 계산 연산자
				System.out.printf("%d %% %d = %d\n\n", 19, 5, 19%5);
				
				// %와 d,f,s 사이에 숫자 옵션을 넣어서 표시할 자릿수를 조절한다
				
				// 정수의 자릿수 조절
				// %와 d 사이에 숫자를 쓰지 않은 경우 : 표시될 데이터의 자리수만큼 확보한 후 출력
				System.out.printf("정수%d정수\n", 123);
				// %와 d사이에 숫자를 쓴 경우 : 쓴 숫자만큼 자리 확보 후 출력 데이터를 출력
				// 만약 자리가 모자라다면 자동으로 자리를 추가, 자리가 남으면 공백을 채워 출력 (우측 정렬이 기본)
				System.out.printf("정수%3d정수\n", 12345);
				System.out.printf("정수%10d정수\n", 12345);
				// 출력될 자리 확보 후 왼쪽 정렬
				System.out.printf("정수%-10d정수\n\n", 12345);
				
				// 문자의 자리수 조절
				// 숫자를 안 쓴 경우 : 출력 데이터만큼 자리 확보
				System.out.printf("문자:%s꽃이 피었습니다.\n", "무궁화");
				// 숫자를 썼지만 자리가 모자른 경우 : 필요한 만큼 자동 추가 확보
				System.out.printf("문자:%2s꽃이 피었습니다.\n", "무궁화");
				//숫자를 쓰고 자리가 남는 경우 : 공백으로 채움
				System.out.printf("문자:%10s꽃이 피었습니다.\n", "무궁화");
				//왼쪽 정렬
				System.out.printf("문자:%-10s꽃이 피었습니다.\n\n", "무궁화");
				
				// 실수의 자릿수 조절 
				// 숫자를 안쓴 경우 : 소수점 윗자리는 필요한 만큼 확보, 아래자리는 6자리 확보
				System.out.printf("실수%f실수\n", 123.123);
				// 숫자를 쓴 경우 
				// %10.2f : 총 10자리 확보 후 소수점 아래 숫자 2자리로 할당. 따라서 소숫점 윗자리 숫자는 7자리가 할당
				// 소수점 윗자리는 모자라면 추가 확보, 남으면 공백으로 채운다.
				// 소수점 아래는 지정한 자리만큼 표시한 후 넘치는 부분은 자르고, 모자라면 0으로 채운다.
				System.out.printf("실수%10.2f실수\n", 123.1234);
				System.out.printf("실수%10.4f실수\n", 123.12);
				System.out.printf("실수%3.1f실수\n", 123.123);
				// 왼쪽 정렬
				System.out.printf("실수%-10.2f실수\n\n", 123.123);
				
				System.out.printf("\n----------------------------------연습----------------------------------\n\n");
				
				System.out.printf("\t\t\t ###성적표###\n");
				System.out.printf("--------------------------------------------------------------\n");
				System.out.printf("%3s\t%10s\t%3s\t%3s\t%s\t%s\t%5s\n","번호","이름","국어","영어","수학","총점","평균");
				System.out.printf("--------------------------------------------------------------\n");
				System.out.printf("%3d\t%10s\t%3d\t%3d\t%3d\t%3d\t%5.1f\n", 1, "홍길동", 9, 89, 72, 84+89+72, ((84+89+72)/3.0));
				System.out.printf("%3d\t%10s\t%3d\t%3d\t%3d\t%3d\t%5.1f\n", 2, "고길동", 32, 76, 100, 32+76+100, (32+76+100)/3.0);
				System.out.printf("%3d\t%10s\t%3d\t%3d\t%3d\t%3d\t%5.1f\n", 3, "최길동", 97, 88, 91, 97+88+91, (97+88+91)/3.0);

	}

}

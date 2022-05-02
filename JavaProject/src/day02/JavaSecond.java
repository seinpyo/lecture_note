package day02;
//클래스 이름은 영문과 숫자가 조합되어서 만들어질 수도 있다
//반드시 첫글자가 영문일 것.
//이름 중간에 언더바를 제외한 공백 또는 특수기호가 들어갈 수 없다.
public class JavaSecond {
	public static void main(String[] args) {
		System.out.printf("겁나 쉬운 자바 프로그래밍~!\n");
		System.out.printf("겁나 쉬운 자바 프로그래밍~!\n");
		System.out.printf("겁나 쉬운 자바 프로그래밍~!\n");
		/*
		 \t : tab (한번 탭하면 8byte 씩)
		 \' : 작은 따옴표 출력
		 \" : 큰 따옴표 출력
		 %% : % 출력
		 \\ : \ 출력
		 \b : 백스페이스 - 커서 왼쪽으로 이동하면서 앞글자를 한글자씩 삭제 (이클립스 콘솔창에서는 정상 작동하지 않는다.)
		 */
		System.out.printf("\n");
		System.out.println("---------------------------------------------");
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		System.out.println("---------------------------------------------");
		System.out.println("1\t89\t87\t56\t254\t81.5");
		System.out.println("2\t87\t89\t54\t234\t83.5");
		System.out.println("3\t56\t58\t58\t244\t85.5");
		System.out.println("---------------------------------------------");
		//앞에 글자가 있건 없건 그냥 8byte씩 떨어진 공간에 출력한다는 것
		System.out.printf("\n");
		
		System.out.printf("겁나 쉬운 \"자바\" 프로그래밍\n");
		System.out.printf("겁나 쉬운 \'자바\' 프로그래밍\n");
		System.out.printf("겁나 쉬운 '자바' 프로그래밍\n");	//얘는 안써도 출력 결과 같음
		
		System.out.printf("\n");
		
		System.out.printf("대통령은 조약을 \"체결-비준\"하고, \n");
		System.out.printf("외교사절을 \"신입-접수\" 또는 \"파견\"하며, \n");
		System.out.printf("\'선전포고\'와 \'강화\'를 한다\n\n");
		System.out.printf("대통령의 임기가 만료되는 때에는 \n");
		System.out.printf("임기만료 70%% 내지 40%% 전에 후임자를 선거한다. \n\n");
		
	}
}

package days11;

public class Method14 {
	public static void main(String[] args) {
		
		// 전달 인수의 갯수가 일정치 않아 오버로딩으로는 해결할 수 없는 경우
		
		int c = max(50,60, 80, 60, 54, 60);
		System.out.println("입력 값 중 가장 큰 값은 " + c + " 입니다.");
		c = max(50,60, 80, 60, 54, 60, 56, 87, 69);
		System.out.println("입력 값 중 가장 큰 값은 " + c + " 입니다.");
		
	}
	
	public static int max(int ... a) {		// 참조변수 a를 이름으로 한 배열이 생성됨.
		int max = 0;
		
		for(int i=0; i<a.length; i++) {	 	//배열의 크기는 전달되는 전달 인수의 갯수로 ...
			if (a[i] > max) max = a[i];
		}
		
		return max;
	}

}

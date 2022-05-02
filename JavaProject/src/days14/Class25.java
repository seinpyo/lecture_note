package days14;

class StaticF {
	
	private int number;
	private static int num = 1;
	
	//초기화 블럭

	{ number = 100;
	System.out.println("인스턴스 변수 초기화용 블럭1");}
	
	//static 초기화 블럭
	static { System.out.println("StaticF의 static 초기화 블럭 실행");
		num = 55;
	} 
	
	//일반 초기화 블럭에서는 스태틱 멤버에 접근이 자유롭다 
	static int cnt = 0;
	int serialNo;
	{
		++cnt;
		serialNo = cnt;
		System.out.println("인스턴스 변수 초기화용 초기화 블럭2");
		
	}
}


public class Class25 {

	public static void main(String[] args) {
		StaticF f = new StaticF();

	}

}

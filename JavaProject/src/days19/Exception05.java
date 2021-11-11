package days19;

public class Exception05 {
	public static void main(String[] args)  {
		try {
			method01();
		} catch (Exception e) {
			System.out.println("에러메시지 : " + e.getMessage());
		}
	}
	
	public static void method01() throws Exception {
		method02();
	}
	public static void method02() throws Exception {
		throw new Exception(); // 강제 예외 발생
	}
	
}

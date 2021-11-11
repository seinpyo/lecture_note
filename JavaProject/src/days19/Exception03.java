package days19;

//종류별 예외처리 

public class Exception03 {
	public static void main(String[] args) {
		
		System.out.println(1);
		System.out.println(2);

		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		} catch( ArithmeticException e ) {
			e.printStackTrace(); //java.lang.ArithmeticException: / by Zero
			System.out.println("예외 메시지 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception");
		}
		System.out.println(6);
	}

}

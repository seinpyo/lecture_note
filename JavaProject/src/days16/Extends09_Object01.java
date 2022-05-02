package days16;

//Object 클래스

class UserClass /*extends Object */ {
	
}

public class Extends09_Object01 {
	public static void main(String[] args) {
	
		UserClass obj = new UserClass();
		System.out.println(obj.getClass()); 
		//해당 객체의 클래스명을 리턴해주는 Object 클래스의 메소드 
		//Object에서 상속받았기 때문에 사용 가능
		
		//hashCode 메소드는 해당 객체의 해쉬코드값을
		//리턴해주는 메서드 (JVM에 의해 관리되고 있는 번호)
		System.out.println(obj.hashCode());
		
		//toString 메서드는 해당 객체의 정보를 문자열로 리턴
		System.out.println(obj.toString());
		System.out.println(obj);	
		//toString()을 명시하지 않아도 결과 동일
	}

}

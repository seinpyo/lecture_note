package days15;

//상속과 형변환 

class SuperF {
	int superNum;
	void abc() {System.out.println("Super Method");}
}

class SubF extends SuperF {
	int subNum;
	void abc() {System.out.println("Sub Method");}
}

public class Extends08_TypeCasting02 {
	public static void main(String[] args) {
		
		SuperF super1 = new SuperF();
		SubF sub1 = new SubF();
		
		// 부모 클래스에 자식의 인스턴스 주소를 넣는 것 : ok
		super1 = sub1;
		super1 = new SubF();
		
		//역은 성립하지 않는다.
		//sub1 = ()super1; //err
		//sub1 = new SuperF(); //err
		
		//강제형변환 필요
		SubF sub3 = (SubF) super1;	//ok
		SuperF super4 = new SubF();
		SubF sub4 = (SubF)super4;
		
		
		//instanceof
		
		SuperF super5 =new SubF(); //부모 클래스에 자식 참조주소 저장
		if( super5 instanceof SubF) {
			SubF sub5 = (SubF) super5;
			System.out.println("형변환 성공");
		} else { System.out.println("형변환 실패"); }
	
		SuperF super6 =new SuperF(); //부모 클래스에 자식 참조주소 저장
		if( super6 instanceof SubF) {
			SubF sub6 = (SubF) super6;
			System.out.println("형변환 성공");
		} else { System.out.println("형변환 실패"); }
		
		SuperF super2 = new SubF();
		super2.superNum = 100;
		//super2.subNum = 100; //err
		
		SubF sub2 = new SubF();
		super2 = sub2;
		super2.superNum = 200; 
		//	super2.subNum = 300; //err
		
		SuperF super7 = new SuperF();
		SuperF super8 = new SubF();
		super7.abc();
		super8.abc();
		
		//단 메서드가 오버라이딩 되어있다면, 부모 클래스의 레퍼런스로 실행한 메서드는 
		//자식 클래스에서 오버라이딩 된 메서드가 우선 실행된다.
		
		
	}

}

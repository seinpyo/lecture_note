package days17;

public class WrapperClass01 {
	public static void main(String[] args) {
		
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		//참조변수들의 비교 
		if(i1 == i2) System.out.println("i1과 i2의 값이 같습니다.");
		else System.out.println("i1과 i2의 값이 다릅니다.");
		System.out.println("i1 == i2 ? " + (i1 == i2));
		
		//실제 인스턴스에 저장된 값들의 비교 
		if(i1.equals(i2)) System.out.println("i1과 i2의 값이 같습니다.(equals)");
		else System.out.println("i1과 i2의 값이 다릅니다.(equals)");
		System.out.println("i1.equals(i2) = " + i1.equals(i2));
		
		System.out.println("i1.compareTo(i2) = " + i1.compareTo(i2));
		//실제 인스턴스에 저장된 값들의 비교 - 뺄셈연산으로 앞에 숫자가 크면 양수
		//뒤에 숫자가 크면 음수반환, 같으면 0반환
		
		//Object 부모 클래스의 오버라이딩 
		System.out.println("i1.toString() = " + i1.toString());
		System.out.println("i2 = " + i2);
		//toString()의 리턴값은 String이다.
		
		//표현 가능한 가장 큰값와 작은수(스태틱변수)
		System.out.println("MAX_VALUE = "+Integer.MAX_VALUE);
		System.out.println("MIN_VALUE = "+Integer.MIN_VALUE);
		
		//비트 바이트로 표현한 저장크기
		System.out.println("SIZE = " + Integer.SIZE + "bits");
		System.out.println("BYTES = " + Integer.BYTES + "bytes");
		//자료형
		System.out.println("TYPE = " + Integer.TYPE);
		
		//int와 Integer의 호환성
		int i = 10;
		Integer inti = (Integer) i; //Integer inti = Integer.valueOf(i);
		
		int i3 = inti+10;
		System.out.println(i3);
		
		Integer inti2 = new Integer(20);
		System.out.println("inti2 = " + inti2);
		int i4 = (int)inti2; //참조형을 기본형으로도 형변환 가능(생략가능)
		System.out.println("i4 = " + i4);
		
		Integer inti3 = inti2 + i3;
		System.out.println("inti2 + i3 = " + inti3);
	}

}

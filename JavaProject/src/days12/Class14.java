package days12;

class ThisA {
	
	private int num;
	public void init(int num) {
		this.num = num;			//전달인수로 들어온 num을 멤버변수 num에 대입
	}
	
	public void prn() {
		System.out.println("멤버변수 num : " + this.num);
	}
	
	
}

public class Class14 {
	public static void main(String[] args) {
			
		ThisA t1 = new ThisA();
		t1.init(100);
		t1.prn();
		
	}

}

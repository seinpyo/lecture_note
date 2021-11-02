package days12;

class ThisB {
	//Field
	private int num;
	
	//Method
	public void setNum(int num) {
		this.num = num;
	}
	
	public void prn() {
		System.out.printf("num = %d\n", num);
	}

	public void copy(ThisB temp) {
		this.num = temp.num; 
		
	}
	
	public ThisB copy2() {
		ThisB temp = new ThisB();
		temp.num = this.num;
		return temp;
	}

}

public class Class15 {
	public static void main(String[] args) {
		
		ThisB b1 = new ThisB();
		ThisB b2 = new ThisB();
		
		b1.setNum(100);
		b2.setNum(200);
		b1.prn();
		b2.prn();
		
		System.out.println();
		ThisB b3 = b1;	
		b3.setNum(300);
		b1.prn();
		b3.prn();
		
		
		//객체 복사 방법 #1
		System.out.println();
		ThisB b4 = new ThisB();
		b4.copy(b2);
		b2.setNum(500);
		b2.prn();
		b4.prn();
		
		
		//객체 복사 방법 #2
		System.out.println();
		
		ThisB b5 = b3.copy2();
		b3.setNum(400);
		b3.prn();
		b5.prn();
		
		
	}

}


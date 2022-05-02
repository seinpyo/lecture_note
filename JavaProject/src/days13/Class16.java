package days13;

//this와 생성자의 활용

class ThisB{
	
	private int num1;
	private int num2;
	private int num3;
	
	ThisB(int n) { 
		num1 = n; 
		System.out.println("ThisB클래스의 생성자1 생성");
		}
	ThisB(int n1, int n2) { 
		//num1 = n1; 
		//ThisB(n1); -> 생성자는 임의 호출 불가
		this(n1); 	//생성자 중 int 한개만을 매개변수로 가지는 생성자를 호출 
		num2 = n2; 
		System.out.println("ThisB클래스의 생성자2 생성");
		}
	
	ThisB(int n1, int n2, int n3) {
		this(n1, n2);
		num3 = n3;
		System.out.println("ThisB클래스의 생성자3 생성");
	}
	
}

public class Class16 {
	public static void main(String[] args) {
		
		ThisB t1 = new ThisB(10);
		System.out.println();
		ThisB t2 = new ThisB(10, 20);
		System.out.println();
		ThisB t3 = new ThisB(10, 20, 30);

	}

}

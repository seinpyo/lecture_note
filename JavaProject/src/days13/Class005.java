package days13;

class Complex{
	// 복소수  ex) 5+3i -> i : 루트-1(허수 : 제곱해서 -1이 되는 수)

	int real;
	int image;
	
	public void init(int real, int image) {
		this.real = real;
		this.image = image;
		
	}
	
	public void prn() {
		System.out.printf("%d + %di\n", real, image);
	}
	
	public Complex add(Complex a) {	//c3 = c2.add(c2); this;
		Complex temp = new Complex();
		temp.real = this.real + a.real;
		temp.image = this.image + a.image;
		return temp;
	}
	
	public Complex subtract(Complex a) {
		Complex temp = new Complex();
		temp.real = this.real - a.real;
		temp.image = this.image - a.image;
		return temp;
	}
}

public class Class005 {
	public static void main(String[] args) {
	
		Complex c1 = new Complex();
		c1.init(6,8);
		Complex c2 = new Complex();
		c2.init(8,9);
		
		c1.prn(); // x + yi 형태로 출력
		c2.prn();
		
		System.out.println("\nadd메소드");
		
		Complex c3 = new Complex();
		c3 = c1.add(c2);
		c1.prn(); 
		c2.prn();
		c3.prn();
		
		System.out.println("\nsubtract메소드");
		
		c2.init(2,3);
		c3 = c1.subtract(c2);
		c1.prn(); 
		c2.prn();
		c3.prn();
		
	}
}

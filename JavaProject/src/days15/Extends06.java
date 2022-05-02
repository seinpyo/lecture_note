package days15;

class SuperD{
	public SuperD() {	
		this(1);
		System.out.println("SuperD()");
	}
	
	public SuperD(int arg) {
		this(1.1);
		System.out.println("SuperD(int)");
	}
	
	public SuperD(double arg) {
		this("");
		System.out.println("SuperD(double)");
	}
	
	public SuperD(String arg) {
		System.out.println("SuperD(String)");
	}
}	

class SubD extends SuperD{
	public SubD() {	
		this(1);
		System.out.println("SubD()");
	}
	public SubD(int arg) {
		this(1.1);
		System.out.println("SubD(int)");
	}
	
	public SubD(double arg) {
		this("");
		System.out.println("SubD(double)");
	}
	
	public SubD(String arg) {
		System.out.println("SubD(String)");
	}
}

public class Extends06 {
	public static void main(String[] args) {
	
		SubD d1 = new SubD("a");
		System.out.println();
		SubD d2 = new SubD(1.1);
		System.out.println();
		SubD d3 = new SubD(1);
		System.out.println();
		SubD d4 = new SubD();
		

	}

}

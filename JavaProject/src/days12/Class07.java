package days12;

class GetSetTest {
	
	//getter & setter
	
	private int intVar;
	private double doubleVar;
	private String StringVar;
	
	public int getIntVar() {
		return intVar;
	}
	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}
	public double getDoubleVar() {
		return doubleVar;
	}
	public void setDoubleVar(double doubleVar) {
		this.doubleVar = doubleVar;
	}
	public String getStringVar() {
		return StringVar;
	}
	public void setStringVar(String stringVar) {
		StringVar = stringVar;
	}
	
}


public class Class07 {

	public static void main(String[] args) {
		
		GetSetTest gs = new GetSetTest();
		gs.setIntVar(123);
		System.out.println("멤버변수 int var : " + gs.getIntVar());

	}

}

package days18;

//interface의 상속

interface InterC_Super1 {
	void interC_Super1Test();
}

interface InterC_Super2 {
	void interC_Super2Test();
}

interface InterC_Sub extends InterC_Super1, InterC_Super2{
	void interC_SubTest();
}

class SubC1 implements InterC_Super1, InterC_Super2 {

	@Override
	public void interC_Super2Test() {}
	@Override
	public void interC_Super1Test() {}
	
}

class SubC2 implements InterC_Sub{

	@Override
	public void interC_Super1Test() {}
	@Override
	public void interC_Super2Test() {}
	@Override
	public void interC_SubTest() {}
	
}

public class Extend11_Interface03 {
	public static void main(String[] args) {
		SubC2 c1 = new SubC2();
		InterC_Super1 s1 = new SubC2();
		InterC_Super2 s2 = new SubC2();
		InterC_Sub s3 = new SubC2();
		
		s1.interC_Super1Test();
		s2.interC_Super2Test();
		//s1.interC_Super2Test(); //err
		//s2.interC_Super1Test(); //err
		s3.interC_Super1Test();
		s3.interC_Super2Test();
		s3.interC_SubTest();
		
	}
}

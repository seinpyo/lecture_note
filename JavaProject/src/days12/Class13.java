package days12;

//멤버 메서드의 오버로딩

class Sum {
	private int a;
	private int b;
	Sum(int c, int d) {
		a = c;
		b = d;
	}
	
//	public int add () {
//		return a+b;
//	}
//	
//	public int add (int c) {
//		return a+b+c;
//	}
//	
//	public int add (int c, int d) {
//		return a+b+c+d;
//	}
//	public int add (int c, int d, int e) {
//		return a+b+c+e;
//	}
//	
//	// 무한히 늘어나도록 만들 순 없음 
	
	public int add(int ... c) {
		int tot = 0;
		for(int i=0; i<c.length; i++) {
			tot += c[i];
		}
		return a+b+tot;
	}
	
}

public class Class13 {
	public static void main(String[] args) {
		Sum s = new Sum(25,36);
		System.out.println("s.add()의 결과 : " + s.add());
		System.out.println("s.add(23)의 결과 : " + s.add(23));
		System.out.println("s.add(23)의 결과 : " + s.add(59,65));
		System.out.println("s.add(23)의 결과 : " + s.add(59,65,85));
		System.out.println("s.add(23)의 결과 : " + s.add(58,98,78,36,59)); 
	}

}

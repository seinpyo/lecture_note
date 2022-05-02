package days16;

class UserClassB { } // toString을 오버라이딩 하지 않은 클래스

class Point {		//toString을 오버라이딩 한 클래스
	private int x;
	private int y;
	public Point(int x, int y) {this.x=x; this.y=y;}
	public String toString() {
		return "(x = " + this.x + ", y = " + this.y + ")";
	}
	
}
public class Extends09_Object02 {
	public static void main(String[] args) {
	
		UserClassB obj = new UserClassB();
		System.out.println("오버라이딩 되지 않은 toString() => " + obj.toString());
		Point p = new Point(30,20);
		System.out.println("오버라이딩 된 toString() => " + p.toString());
		String msg = "Point => " + p;
		System.out.println(msg);
	}

}

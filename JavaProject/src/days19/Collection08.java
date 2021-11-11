package days19;

import java.util.*;

class Point {
	private int x;
	private int y;
	public Point(int x, int y) {this.x = x; this.y=y; }
	public String toString() {return "x:" + x + ", y:" + y;}
	public boolean equals(Object obj) {
		if(!(obj instanceof Point)) return false;
		Point target = (Point) obj;
		boolean result = ((this.x==(target.x))&&(this.y==target.y));
		return result;
	}
}
public class Collection08 {

	public static void main(String[] args) {
	
		ArrayList<Point> list = new ArrayList<Point>();
		Point p1 = new Point(10, 10);
		list.add(p1);
		list.add(new Point(20, 30));
		list.add(new Point(30, 30));
		
		for (Point p : list) System.out.println(p);
		
		int index = list.indexOf(new Point(30,30));
		System.out.printf("(30,30)의 위치 : %d\n", index);
		boolean con = list.contains(new Point(30,30));
		System.out.printf("(30,30)의 저장 유무 : %b\n", con);
		
	}

}

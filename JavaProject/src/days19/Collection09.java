package days19;

import java.util.*;

class Rect {
	private int x;
	private int y;
	public Rect(int x, int y) { this.x = x; this.y = y;}
	public String toString() {return "x:" + this.x + ", y:" + this.y; }
	public boolean equals(Object obj) {
		if(!(obj instanceof Rect)) return false;
		Rect target = (Rect) obj;
		boolean flag = ((this.x==target.x)&&(this.y==target.y));
		return flag;
	}
	public int hashCode() {
		System.out.println("Rect 클래스의 hashCode 실행");
		return this.x + this.y;
	}
	

}

public class Collection09 {
	public static void main(String[] args) {
		HashMap<Rect, Integer> map = new HashMap<>();
		map.put(new Rect(10,10), 10);
		map.put(new Rect(20,20), 20);
		map.put(new Rect(30,30), 30);
		for(Rect k : map.keySet()) System.out.printf("(%s) -> %d\n", k, map.get(k));
		
		System.out.printf("\n(30, 30)의 유무 : %b\n", map.containsKey(new Rect(30,30)));
		//false
		
		
		
	}

}

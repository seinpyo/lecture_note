package days18;

//LinkedList

import java.util.LinkedList;

public class Collection03 {

	public static void main(String[] args) {
		
		LinkedList<Integer> a = new LinkedList<>();
		a.add(10); a.add(20); a.add(30); a.add(40); a.add(50);
		for(int i=0; i<a.size(); i++) System.out.printf("a.get(%d) -> %d\n", i, a.get(i));
	}
}

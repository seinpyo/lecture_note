package days18;

//중복 허용

import java.util.*;

public class Collection04 {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<>();
		v.add(1); v.add(2); v.add(2);
		System.out.println(v.size());	//3
		
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1); a.add(2); a.add(2);
		System.out.println(a.size());	//3
		
		LinkedList<Integer> l = new LinkedList<>();
		l.add(1); l.add(2); l.add(2);	
		System.out.println(l.size());	//3
		
		HashSet<Integer> h = new HashSet<>();
		h.add(1); h.add(2); h.add(2);	
		System.out.println(h.size());	//2
		
		HashSet<Integer> lotto = new HashSet();
		while(lotto.size()<6) {
			lotto.add((int)(Math.random()*45) + 1);
		}
		
		List<Integer>list = new LinkedList<Integer>(lotto);
		Collections.sort(list);
		for(Integer i : list) {
			System.out.print(i + " ");
		}
			
		Iterator<Integer> iter = lotto.iterator();
		Iterator<Integer> iter2 = list.iterator();
		
		System.out.println("\niter1");
		while(iter.hasNext()) {
			System.out.printf("%d ", iter.next());
		}
		
		System.out.println();
		
		System.out.println("iter2");
		while(iter2.hasNext()) {
			System.out.printf("%d ", iter2.next());
		}
		
		
//		for(Integer k : lotto) System.out.printf("d% ", k);
		System.out.println("\nlist for문 출력");
		for(Integer j : list) System.out.printf("%d ", j);
		
		
		
	}
}

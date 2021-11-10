package days18;

import java.util.ArrayList;

public class Collection02 {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		//다양한 타입을 저장할 수 있는 컬랙션 클래스의 객체 
		a.add(10);
		a.add(1.1);
		a.add("Hello");
		Integer i0 = (Integer)a.get(0);
//		Integer i1 = (Integer)a.get(1); //err
		Double i2 = (Double)a.get(1);
//		String i3 = a.get(2); //err
		String i4 = (String) a.get(2);
		
		System.out.printf("i0 -> %d\n", i0);
		System.out.printf("i0 -> %.1f\n", i2);
		System.out.printf("i0 -> %s\n", i4);
		
		//제네릭 이용
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(100);
		Integer i = list.get(0);
		System.out.println(i);
		
	}

}

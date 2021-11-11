package days19;

import java.util.*;

public class Collection05 {
	public static void main(String[] args) {
	
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		HashMap<Integer, String> hm = new HashMap<>();
		
		HashMap<Integer,ArrayList<String>> kk = new HashMap<>();
		
		HashMap<Integer,Object> pp = new HashMap<>();
		
		ht.put("One", 1);
		ht.put("Two", 2);
		ht.put("Three", 3);
		
		hm.put(1, "One");
		hm.put(2, "Two");
		hm.put(3, "Three");

		System.out.printf("\"One\" = %d\n", ht.get("One"));
		System.out.printf("1 = %s\n", hm.get(1));
		
		Enumeration<String> e1 = ht.keys();	//키들의 접근 권한을 저장
		while (e1.hasMoreElements()) {//키값이 더이상 없을 때까지 반복
			
			String key = e1.nextElement(); //키값을 key변수에 넣고 
			int value = ht.get(key);	//key값으로 검색한 value를 추출
			System.out.printf("key(%s) = Value(%d)\n", key, value);
		}
		
		System.out.println();
		
		for(Integer k : hm.keySet()) { // hm.keySet() : key값만 모아서 리스트로 생성
			String v = hm.get(k);
			System.out.printf("key(%d) = Value(%s)\n", k, v);
		}

	}

}


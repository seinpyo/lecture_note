package days18;

import java.util.ArrayList;
import java.util.Vector;

public class Collection01 {
	public static void main(String[] args) {
		
		Vector v= new Vector();
		ArrayList a = new ArrayList ();
		
		v.add(10);
		v.add(20);
		v.add(30);

		a.add(10);
		a.add(20);
		a.add(30);
		
		for(int i=0; i<v.size(); i++) System.out.printf("v[%d] = %d\t\t", i, v.get(i));
		System.out.println();
		for(int i=0; i<a.size(); i++) System.out.printf("a[%d] = %d\t\t", i, a.get(i));
		System.out.println();
		
		a.set(2, 100);	//인덱스 매개변수를 추가하여 데이터 삽입가능
		//set은 기존값을 지우고 대입한다.
		for(int i=0; i<a.size(); i++) System.out.printf("a[%d] = %d\t\t", i, a.get(i));
		System.out.println();
		
		a.add(2, 300); //add는 기존값들을 뒤로 밀고 중간에 삽입한다.
		for(int i=0; i<a.size(); i++) System.out.printf("a[%d] = %d\t\t", i, a.get(i));
		System.out.println();
	}
}

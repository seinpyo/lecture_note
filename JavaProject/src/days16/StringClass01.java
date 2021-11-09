

package days16;

import java.util.Date;

public class StringClass01 {

	public static void main(String[] args) {
		
		//0.
		//가용한 HEAP 공간에 "Hello"를 저장하고 그 주소를 s에 전달
		String s = "Hello";
		//이미 저장된 "Hello"가 있다면 그 주소를 전달한다.
		System.out.println("0. " + s);
		//단점 : 같은 문자열 Hello를 다른 변수에 저장하여도 새로운 공간이 할당되지X
		
		//1. 
		//new에 의해 새로운 HEAP 공간에 "Hello"를 저장, 그 주소를 s에 전달
		s = new String("Hello");
		System.out.println("1. " + s);
		// String 클래스는 Object클래스의 상속을 받고 이미 toString과 equals가 오버라이딩 되어있음
		
		//2. 
		//한글자만을 데이터로 갖는 char형 배열
		char[] c = {'H','e','l','l','o'};
		String s2 = new String(c);	// 배열 주소를 초기값으로 문자열 구성
		System.out.println("2. " + s2);
		
		//3. 
		String n = "0123456789";
		char c1 = n.charAt(0);
		char c2 = n.charAt(5);
		System.out.println("3. " + c1 + " " + c2);
		
		
		//4. 
		String a1 = new String("ABCD");
		String a2 = new String("CCD");
		String a3 = new String("ABCD");
		
		System.out.println("4. a1.compareTo(a2)? " + a1.compareTo(a2));
		System.out.println("4. a2.compareTo(a3)? " + a2.compareTo(a3));
		System.out.println("4. a1.compareTo(a3)? " + a1.compareTo(a3));
		
		//첫글자부터 차례로 같은 자리의 글자와 비교 (아스키코드)
		//크기를 결정하는 방법은 비교되는 두글자들의 뺄셈을 연산하여 
		//결과가 음수이면 괄호안의 변수가, 양수 이면 this 변수가 더 크다 
		// ex) a.compareTo(b) = -1 : b가 더 크다 
		// 앞쪽부터 비교해 같은 글자는 지나치는 방식으로 크기가 결정되면 
		// 뒤쪽 글자들은 비교하지 않는다
		// ex) 9981.compareTo(999) = -1 : 999가 더 크다고 판단함
	
		// 나라 이름 오름차순 정렬하기
		
		String[] k = {"korea", "japan", "canada", "china", "brazile", "kenya", "jamaica"};
		for(int i=0; i<k.length; i++) {
			for(int j=i+1; j<k.length; j++) {
				if(k[i].compareTo(k[j]) > 0) {
					String temp = k[i];
					k[i] = k[j];
					k[j] = temp;
				}
			}
		}
		
		for (String str : k) System.out.print(str + " ");
		System.out.println();
		
		
		//5. s:Hello
		s2 = s.concat(" World");
		//concate 메서드는 원본 s에 있는 문자열에 World를 이어붙이기
		//하고 업데이트해서 저장하는 것이 아니라 이어붙이기 된 새로운
		//문자열 객체를 만들어 새로운 레퍼런스 변수에 저장할 수 있게
		//리턴해준다.
		//String 클래스의 특성상 s에 있는 Hello 원본은 보호된다.
		System.out.println("5. " + s2);
		System.out.println("5. " + s);	//원본이 보호됨
		
		
		//6. 
		s = new String("abcdefg");
		boolean b = s.contains("bc");
		boolean b1 = s.contains("xy");
		//괄호 안의 문자열이 메서드 호출 객체가 갖고 있는 문자열의 일부로 포함되어 있다면
		//true를 리턴
		System.out.println("6. 문자열 " + s + "에는 \"bc\"가 포함되어 있다? " + b);
		System.out.println("6. 문자열 " + s + "에는 \"xy\"가 포함되어 있다? " + b1);
		
		
		//7. 
		s= new String("Hello.txt");
		b = s.endsWith("txt"); 
		b1 = s.startsWith("H");
		//메서드 호출 객체가 갖고 있는 문자열이 괄호 안의 문자열로 끝나면/시작하면 true
		System.out.println("7. 문자열 " + s + "는 \"txt\"로 끝난다? " + b);
		System.out.println("7. 문자열 " + s + "는 \"H\"로 시작한다? " + b1);
		
		
		//8. 
		s = new String("Hello");
		//대소문자 구분해서 비교 
		System.out.println("8. " + s + "는 \"Hello\"와 같다? " + s.equals("Hello"));
		System.out.println("8. " + s + "는 \"hello\"와 같다? " + s.equals("hello"));
		
		//대소문자 구분하지 않고 비교
		System.out.println("8. " + s + "는 \"HELLO\"와 같다? " + s.equalsIgnoreCase("HELLO"));
		System.out.println("8. " + s + "는 \"Hello\"와 같다? " + s.equalsIgnoreCase("Hello"));
		
		
		//9.
		System.out.println("9. " + s + "의 문자중 \'o\'의 위치 " + s.indexOf('o'));
		System.out.println("9. " + s + "의 문자중 \'k\'의 위치 " + s.indexOf('k'));
		//메서드 호출 객체의 문자열 중 괄호 안에 있는 문자가 몇 번째로 위치하는 지 구해준다
		//존재한다면 인덱스값, 없으면 -1
		
		System.out.println("9. " + s + " s.indexOf(\'e\', 0) " + s.indexOf('e',0));
		System.out.println("9. " + s + " s.indexOf(\'e\', 1) " + s.indexOf('e',1));
		
		System.out.println("9. " + s + " s.indexOf(\'e\', 2) " + s.indexOf('e',2));
		System.out.println("9. " + s + " s.indexOf(\'o\', 2) " + s.indexOf('o',2));
		//찾고자하는 문자가 지정된 정수(0부터 시작)번째 부터 시작해 몇번째 글자에 위치하는지
		//첫번째 사용 예 : 알파벳 e가 문자열 s의 0번째부터 몇번째 글자인지 리턴 : 1
		//두번째 사용 예 : 알파벳 e가 문자열 s의 2번째부터 찾아서 전채 글자의 몇번째 글자인지 구함 
		// ->"llo" 중 존재하지 않으므로 -1리턴
		
		
		//10. 
		s= "Hello";
		System.out.println("10. " + s + " s.replace(\'H\', \'C\')  -> " + s.replace('H','C'));
		s2 = s.replace('H', 'C');
		System.out.println("10. " + s+ " " + s2);
		System.out.println("10. " + s + " s.replace(\'ll\', \'LL\')  -> " + s.replace("ll","LL"));
		s2 = s.replace("ll", "LL");
		System.out.println("10. " + s+ " " + s2);
		//String 클래스는 보관하고 있는 문자열을 이용하여 변화를 주는 메서드들에서 변화된 내용이
		//업데이트 되어 저장되는 것이 아니고 대부분 새로운 변화된 문자열 객체로 만들어 리턴한다
		//(두번째 replace 후 CeLLo 가 아닌 HeLLo 가 나온 것을 볼 수 있다)
		//따라서 이 메서드를 통한 원본 s 문자열을 변경 시킬 수 는 없다.
		
		
		//11.
		String animal = "dog,cat,bear";
		String[] a = animal.split(",");
		System.out.print("\n12. ");
		for(String str : a) System.out.print(str + " ");
		
		
		//12.
		s = "java.lang.Object";
		s2 = s.substring(5,9);
		//원본에서 인덱스 5~8(9-1)까지 추출
		System.out.println("\n\n13. " + s2);
		s2 = s.substring(10); //원본에서 열번째 글자부터 끝까지
		System.out.println("13. " + s2);
		
		
		
		//13. 
		System.out.println("\n14. " + String.valueOf(true));
		s = String.valueOf("14. " + 100);
		System.out.println(s);
		s = String.valueOf(100.123);
		System.out.println("14. " + s);
		
		Date dd = new Date();
		s = String.valueOf(dd);
		System.out.println("14. " + s);
		
		
		
	}

}


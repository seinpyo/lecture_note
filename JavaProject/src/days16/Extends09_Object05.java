package days16;
// 상품과 구매자를 클래스로 만들고 구매, 환불 등의 동작을 메서드로 제작

import java.util.Vector;

class Product {
	
	int price;
	int bonusPoint;
	
	Product(){}
	Product(int p) {
		price = p;
		bonusPoint = price/10;
	}
}

class Computer extends Product{
	
	Computer(){ super(150); }
	//상품명 리턴 메소드
	public String toString() { return "Computer"; }
}

class Tv extends Product{
	
	Tv(){ super(100); }
	//상품명 리턴 메소드
	public String toString() { return "Tv"; }
}

class Audio extends Product{
	
	Audio(){ super(60); }
	//상품명 리턴 메소드
	public String toString() { return "Audio"; }
}


class Customer {
	int money = 1000;
	int bonusPoint = 0;
	Vector item = new Vector();	// 구매 목록
	
	//구매 메소드
	public void buy(Product p) {
		
		if (this.money>p.price) {
			money -= p.price;
			bonusPoint += p.bonusPoint;
			item.add(p);
			System.out.println(p + "을 구입하셨습니다.");
			
		} else System.out.println("잔액이 부족합니다.");
	}
	
	public void summary() {
		int sum = 0;			//지출 총액
		String itemList = "";	//구매 목록
		if (item.isEmpty()) {
			//isEmprty() : Vector 객체인 item이 비어있으면 true 리턴
			System.out.println("구입하신 제품이 없습니다.");
			return;
		}
		
		for (int i=0; i<item.size(); i++) {
			// item.size() : 저장된 요소의 개수 리턴
			Product p = (Product) item.get(i);
			sum += p.price;	//구매 금액 합산
			itemList = itemList + " " + p;
		}
		
		System.out.println("지출 총액 : " + sum + "(적립 포인트 : "+ sum/10 + ")\n 구매 목록 :" + itemList);
		
	}

	public void refund(Product p) {
		if( item.remove(p) ) {
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "을 반품하셨습니다.");
			
		} else { System.out.println("해당 상품이 존재하지 않습니다."); }
		
	}
}
public class Extends09_Object05 {
	public static void main(String[] args) {
		
		Tv t = new Tv();
		Computer c = new Computer();
		Audio a = new Audio();
		System.out.println(t);
		System.out.println(c);
		System.out.println(a);
		
		Customer costomer = new Customer();
		costomer.buy(c);
		costomer.buy(t);
		costomer.buy(a);
		
		costomer.summary();
		costomer.refund(c);
		costomer.summary();
		
	}
}

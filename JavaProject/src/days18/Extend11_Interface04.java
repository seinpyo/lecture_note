package days18;

//다중상속 실습

//repair가 가능한 unit에만 implements해줄 interface
interface Repairable { }

abstract class Unit{
	int hp;		//현재 체력
	int max_hp;	//최대 체력
	
	Unit(){}
	Unit(int p){
		max_hp = p;
		hp = (int)(p*0.8);
	}
	
	//HP 출력 메소드
	public void prnHP() { System.out.printf("hp : %d/%d\n", hp, max_hp); }
	
	//위치 출력 메소드 (abstract)
	public abstract void move(int x, int y);
	
}

class GroundUnit extends Unit {
	
	//super클래스의 생성자 형식에 맞춰 생성자 생성
	GroundUnit(int p) { super(p); }

	//추상클래스 오버라이딩 (필수)
	@Override
	public void move(int x, int y) {
		System.out.printf("x : %d, y : %d로 뛰어갑니다\n\n", x,y);
	}
}

class AirUnit extends Unit {
	
	AirUnit(int p) { super(p); }

	@Override
	public void move(int x, int y) {
		System.out.printf("x : %d, y : %d로 날아갑니다\n\n", x,y);
	}
}

class Tank extends GroundUnit implements Repairable {
	//Tank -> GroundUnit -> Unit으로 super를 타고 올라간다
	Tank() { super(150);}
	//toString 오버라이딩
	public String toString() {return "Tank"; } 
}

class Marine extends GroundUnit {
	Marine() { super(40);}
	public String toString() {return "Marine"; } 
}

class SCV extends GroundUnit implements Repairable{
	SCV() { super(40);}
	public String toString() {return "SCV"; } 
	public void repair(Repairable r) {
		if(r instanceof Unit) {	//Unit을 상속받은 타입인지 확인
			Unit u = (Unit) r;
			//Tank나 DropShip, SCV로 형변환하지 않고 
			//hp와 max_hp를 다룰 수 있는 부모클래스 Unit으로 형변환
			if(u.hp != u.max_hp) System.out.println(u + "의 수리를 시작합니다");
			else { System.out.println(u + "는 수리할 필요가 없습니다.");
			return; }
			while(u.hp != u.max_hp) {
				u.hp+=2;
				System.out.println("hp + 2, 현재 hp : " + u.hp);
			}
			System.out.println(u + "의 수리를 완료했습니다.\n");
		}
		
	}
}

class Dropship extends AirUnit implements Repairable{
	Dropship() { super(150);}
	public String toString() {return "Dropship"; } 
}


public class Extend11_Interface04 {
	public static void main(String[] args) {
		
		Tank t = new Tank();
		Dropship d = new Dropship();
		Marine m = new Marine();
		SCV s1 = new SCV();
		SCV s2 = new SCV();
		System.out.print(t + " ");
		t.prnHP();
		t.move(10, 20);
		System.out.print(d + " ");
		d.prnHP();
		d.move(10, 20);
		System.out.print(m + " ");
		m.prnHP();
		m.move(10, 20);
		System.out.print(s1 + " ");
		s1.prnHP();
		s1.move(10, 20);
		System.out.print(s2 + " ");
		s2.prnHP();
		s2.move(10, 20);
		
		s1.repair(t);
		s1.repair(d);
//		s1.repair(m);	// Repairable을 implements하지 않아 err
		s1.repair(s2);
		s1.repair(s2);
		
	}
}

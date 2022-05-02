package days23;

interface Repairable { }
class Unit{
	int hp;		//현재 체력
	int max_hp;	//최대 체력
	
	Unit(int p){
		max_hp = p;
		hp = (int)(p*0.8);
	}

	
}

class GroundUnit extends Unit {
	
	//super클래스의 생성자 형식에 맞춰 생성자 생성
	GroundUnit(int p) { super(p); }

}

class AirUnit extends Unit {
	
	AirUnit(int p) { super(p); }

}

class Tank extends GroundUnit implements Repairable {
	//Tank -> GroundUnit -> Unit으로 super를 타고 올라간다
	Tank() { super(150);}
	
}

class Marine extends GroundUnit {
	Marine() { super(40);}
	
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


public class test{
	public static void main(String[] args) {
		
		Tank t = new Tank();
		Marine m = new Marine();
		SCV s1 = new SCV();
	
		s1.repair(t);
		System.out.println(m);
		
	}
}
package days12;

//구구단 만들기

class Gugudan {
	
	int dan;
	
	Gugudan() { dan = 0; }
	Gugudan(int dan) { this.dan = dan; }
	
	public void print() {
		if (dan == 0) {
			for(int i=1; i<10; i++) {
				for(int j=2; j<10; j++) {
					System.out.printf("%d x %d = %d\t", j, i, i*j);
				}
				System.out.println();
			}
		} else {
			for (int i=1; i<10; i++) {
				System.out.printf("%d x %d = %d\n", dan, i, dan*i);
			}
			System.out.println();
		}
		
	}
	
}

public class Class12 {
	public static void main(String[] args) {
		
		Gugudan g1 = new Gugudan(8);
		Gugudan g2 = new Gugudan();
		
		g1.print();
		System.out.println();
		g2.print();
			
	}
}

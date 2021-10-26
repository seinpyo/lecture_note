package days07;

public class ControlOpFor09 {
	public static void main(String[] args) {	
		
		// star1
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		System.out.println("");

		// star2
		for (int i = 0; i < 10; i++) {
			for (int j = 10; j > i; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}

		System.out.println("");
		
		// star3
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j >= i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println("");
		}

		System.out.println("");

		// star4
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j >= i)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println("");
		}

		System.out.println("");

		// star5
		for (int i = 0; i < 10; i++) {
			for (int j = 10; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k<=i*2-1; k++) {
				System.out.print("*");
			}
				
			System.out.println("");
		}

		System.out.println("");
		
		
		//star6
		for(int i=0; i<10; i++) {
			if(i<=5) {
				for(int j=0; j<=i; j++) System.out.print("*");
			} else {
				for(int j=0; j<10-i; j++) System.out.print("*");
			}
			System.out.println("");
		}
		
		System.out.println("");
		
		//star7
		for(int i=0; i<10; i++) {
			if(i<=5) {
				for (int j=5; j>i; j--) System.out.print(" ");
				for (int k=0; k<i*2-1; k++)  System.out.print("*");
			} else {
				for (int j=0; j<i-5; j++) System.out.print(" ");
				for (int k=0; k<(10-i)*2-1; k++)  System.out.print("*");
			}
			System.out.println("");
		}
		
		
	}

}

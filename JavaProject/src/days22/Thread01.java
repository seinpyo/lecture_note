package days22;

class ThreadA1 {
	public void run() {
		for(int i=1; i<=10; i++) 
			System.out.printf("ThreadA1 : i -> %d\n", i);	
	}
}

class ThreadA2 {
	public void run() {
		for(int i=1; i<=10; i++) 
			System.out.printf("ThreadA2 : i -> %d\n", i);
	}
}

public class Thread01 {
	public static void main(String[] args) {
		ThreadA1 t1 = new ThreadA1();
		ThreadA2 t2 = new ThreadA2();
		t1.run();
		t2.run();
		for(int i=1; i<=10; i++) 
			System.out.printf("main : i -> %d\n", i);
	}
}

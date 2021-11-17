package days22;

class ThreadB1 extends Thread{
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.printf("ThreadB1 : i -> %d\n", i);	
		try { Thread.sleep(300); } 
		catch (InterruptedException e) { e.printStackTrace(); } 
		}
	}
}

class ThreadB2 extends Thread{
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.printf("ThreadB2 : i -> %d\n", i); 
		try { Thread.sleep(300); } 
		catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}

public class Thread02 {
	public static void main(String[] args) {
		ThreadB1 b1 = new ThreadB1();
		ThreadB2 b2 = new ThreadB2();
		b1.start();	//Thread 클래스에서 상속받은 메소드
		b2.start();	//Thread를 생성하고 run()도 호출해준다
		for(int i=1; i<=10; i++)  {
			System.out.printf("main : i -> %d\n", i);
		try { Thread.sleep(300); } 
		catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}

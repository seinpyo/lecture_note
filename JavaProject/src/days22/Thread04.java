package days22;

class ThreadD1 implements Runnable {
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.printf("ThreadD1 : i -> %d\n", i);	
		try { Thread.sleep(1000); } 
		catch (InterruptedException e) { e.printStackTrace(); } 
		}
	}
}

class ThreadD2 implements Runnable {
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.printf("ThreadD2 : i -> %d\n", i);	
		try { Thread.sleep(1000); } 
		catch (InterruptedException e) { e.printStackTrace(); } 
		}
	}
}
public class Thread04 {
	public static void main(String[] args) {
		
		//1. 객체 생성
		ThreadD1 t1 = new ThreadD1();
		//2. 생성한 객체를 Thread에 전달인수로 전달
		Thread t = new Thread(t1); 
		//3. 2에서 생성된 Thread 객체를 사용하여 start 메소드 호출
		t.start();
		
		//위의 3줄을 한 줄로 정리하기
		new Thread(new ThreadD2()).start();
		
		for(int i=1; i<=10; i++) {
			System.out.printf("main : i -> %d\n", i);	
		try { Thread.sleep(1000); } 
		catch (InterruptedException e) { e.printStackTrace(); } 
		
		}
	}

}

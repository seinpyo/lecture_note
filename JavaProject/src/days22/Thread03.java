package days22;

import javax.swing.JOptionPane;

class ThreadC1 extends Thread{
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println(i);	
		try { Thread.sleep(1000); } 
		catch (InterruptedException e) { e.printStackTrace(); } 
		}
	}
}

class ThreadC2 extends Thread{
	public void run() {
		String input = JOptionPane.showInputDialog("정답을 입력하세요");
		System.out.println("입력한 답은 " + input + "입니다.");
	}
}

public class Thread03 {
	public static void main(String[] args) {
		ThreadC1 t1 = new ThreadC1();
		ThreadC2 t2 = new ThreadC2();
		t1.start();
		t2.start();
	}

}

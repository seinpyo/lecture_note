package days22;

import javax.swing.JOptionPane;

class ThreadE2 extends Thread {
	private boolean state = true; // 스레드 실행여부를 판단할 변수
	//state 변수값을 변경할 수 있는 멤버 메서드 생성
	public void setState(boolean s) {this.state = s;}
	public void run() {
		//수시로 state 변수를 확인하면서 스레드 실행을 계속할지 검사
		for(int i=10; i>0 && this.state == true; i--) {
			System.out.println(i);
			try { sleep(1000); }
			catch(Exception e) {}
		}
	}
}

//스레드를 계속할지 아니면 멈출지를 결정할 boolean 변수가 멤버변수로 추가
//스레드를 계속하려면 true, 멈추려면 false로 값을 대입하는 setState 메서드도 추가
//run메서드는 실행 중간  또는 반복실행 조건에 state변수가 true인지 검사 
//false이면 멈추고 true이면 계속한다.
public class Thread06 {
	public static void main(String[] args) {
		
		ThreadE2 t2 = new ThreadE2();
		t2.start();
		String input = JOptionPane.showInputDialog("정답을 입력하세요");
		//필요한 입력이 완료되면 스레드가 실행 중이더라도 state값을 false로 바꿔 멈추게
		t2.setState(false);
		//stop()메소드는 사용하지 않는다.
		System.out.printf("입력한 답은 %s입니다.", input);

	}

}

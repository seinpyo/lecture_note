package days19;

import javax.swing.JFrame;

class WindowTest extends JFrame {
	WindowTest() { //생성자
		setTitle("윈도우 테스트");
		setSize(500, 500); // 창 크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//끄는(시스템을 종료하는) 버튼 만들기
		setVisible(true); //생성된 윈도우의 화면 표시
	}	
}
public class SwingEx {
	public static void main(String[] args) {
	
		WindowTest win = new WindowTest();	//창 표시 

	}
}

package days20;

import java.awt.*;
import javax.swing.*;

//레이아웃

class JFlowLayout extends JFrame{
	JFlowLayout() {
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼3");
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout(FlowLayout.RIGHT,50,10));
		//50 : 콘크롤끼리 가로방향 간격 10 : 컨트롤끼리의 세로방향 간격
		//FlowLayout.RIGHT 정렬방향
		
		for(int i = 1; i<=15; i++) 
			con.add(new JButton("버튼" + i));
		//버튼 생성과 동시에 적재, 버튼을 위한 레퍼런스 변수가 없어서 이후 제어 불가
		//적재 모습을 보여주기 위한 예제 
		
		setTitle("배치관리자 실습");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class Swing06 {
	public static void main(String[] args) {

		new JFlowLayout();
		
	}
}

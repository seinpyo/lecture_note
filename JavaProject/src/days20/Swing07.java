package days20;

import java.awt.*;
import javax.swing.*;

class JBorderLayout extends JFrame {
	JBorderLayout() {
		Container con = getContentPane();
		con.setLayout(new BorderLayout(10, 10));
		// 각 지역(동서남북중앙)간의 간격을 가로10, 세로10으로 설ㅈ어
		
		JButton b1 = new JButton("동쪽 버튼");
		con.add(b1, BorderLayout.EAST);
		con.add(new JButton("서쪽 버튼"), BorderLayout.WEST);
		con.add(new JButton("남쪽 버튼"), BorderLayout.SOUTH);
		con.add(new JButton("북쪽 버튼"), BorderLayout.NORTH);
		con.add(new JButton("중앙 버튼"), BorderLayout.CENTER);

		setTitle("보더레이아웃 실습");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}

public class Swing07 {
	public static void main(String[] args) {
		new JBorderLayout();

	}

}

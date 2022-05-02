package days20;

import java.awt.*;
import javax.swing.*;

class JButtonEvent extends JFrame{
	JButtonEvent() {
		ImageIcon korea = new ImageIcon("images/korea1.gif");
		ImageIcon germany = new ImageIcon("images/germany.gif");
		ImageIcon usa = new ImageIcon("images/usa.gif");
		
		//이미지 3개 버튼 1개
		JButton eventButton = new JButton(korea);
		eventButton.setRolloverIcon(usa);
		eventButton.setPressedIcon(germany);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(eventButton);
		
		setTitle("버튼 자체 이벤트 처리 실습");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}

public class Swing05 {
	public static void main(String[] args) {
		new JButtonEvent();
	}
}

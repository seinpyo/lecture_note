package days20;

//GridLayout

import java.awt.*;
import javax.swing.*;

class JGridLayout extends JFrame {
	JGridLayout() {
		Container con = getContentPane();
		con.setLayout(new GridLayout(3, 5, 20, 20));
		// 3행 5열을 가로세로 20px 간격을 두고 배치

		for (int i = 1; i <= 15; i++) {
			con.add(new JButton("버튼" + i));
		}

		setTitle("그리드레이아웃 실습");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class Swing08 {
	public static void main(String[] args) {
		new JGridLayout();

	}

}

package days20;

import java.awt.*;
import javax.swing.*;

class JPanelText extends JFrame {
	JPanelText() {
		Container con = getContentPane();
		con.setLayout(new BorderLayout());

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();

		jp1.setLayout(new GridLayout(5, 1));
		jp2.setLayout(new GridLayout(4, 1));
		
		jp1.add(new JButton("JAVA"));
		jp1.add(new JButton("C++"));
		jp1.add(new JButton("ASP"));
		jp1.add(new JButton("JSP"));
		jp1.add(new JButton("PHP"));
		
		jp2.add(new JRadioButton("JAVA"));
		jp2.add(new JRadioButton("C++"));
		jp2.add(new JRadioButton("ASP"));
		jp2.add(new JRadioButton("JSP"));

		con.add(jp1, BorderLayout.WEST);
		con.add(jp2, BorderLayout.EAST);
		
		setTitle("패널 실습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class Swing12 {
	public static void main(String[] args) {

		new JPanelText();

	}

}

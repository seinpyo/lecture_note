package days20;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GridFruits extends JFrame implements ActionListener{
	
	JLabel result;
	
	GridFruits() {
		
		ImageIcon apple = new ImageIcon("images/apple.jpg");
		ImageIcon banana = new ImageIcon("images/banana.jpg");
		ImageIcon cherry = new ImageIcon("images/cherry.jpg");
		ImageIcon grape = new ImageIcon("images/grape.jpg");
		ImageIcon pear = new ImageIcon("images/pear.jpg");
		
		JButton a = new JButton("사과", apple);
		JButton b = new JButton("바나나", banana);
		JButton c = new JButton("체리", cherry);
		JButton g = new JButton("포도", grape);
		JButton p = new JButton("배", pear);
		result = new JLabel("");
		
		Container con = getContentPane();
		con.setLayout(new GridLayout(3, 2, 20, 20));
		con.add(a);
		con.add(b);
		con.add(c);
		con.add(g);
		con.add(p);
		con.add(result);
		
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		g.addActionListener(this);
		p.addActionListener(this);

		setTitle("그리드레이아웃 예제");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		result.setText(s + "를 선택하셨습니다.");
		
	}
}

public class Swing09 {
	public static void main(String[] args) {
		new GridFruits();
	}

}

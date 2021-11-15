package days20;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calculator extends JFrame implements ActionListener {

	JTextField jtf = new JTextField(20);

	Calculator() {

		// 폰트 사용
		Font f = new Font("굴림", Font.BOLD, 20);
		jtf.setFont(f);

		Container con = getContentPane();
		con.setLayout(new GridLayout(5, 1));

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();

		p2.setLayout(new GridLayout(1, 4));
		p3.setLayout(new GridLayout(1, 4));
		p4.setLayout(new GridLayout(1, 4));
		p5.setLayout(new GridLayout(1, 4));

		//p1
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		jtf.setText("0");
		jtf.setHorizontalAlignment(SwingConstants.RIGHT); // 텍스트 필드 오른쪽 정렬
		jtf.setEditable(false); // 텍스트필드를 통해 직접 수정할 수 없음
		p1.add(jtf);
	
		//p2
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton bp = new JButton("+");
		b7.setFont(f);
		b8.setFont(f);
		b9.setFont(f);
		bp.setFont(f);
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(bp);
		
		//p3
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton bm = new JButton("-");
		b4.setFont(f);
		b5.setFont(f);
		b6.setFont(f);
		bm.setFont(f);
		p3.add(b4);
		p3.add(b5);
		p3.add(b6);
		p3.add(bm);
		
		//p4
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton bt = new JButton("×");
		b1.setFont(f);
		b2.setFont(f);
		b3.setFont(f);
		bt.setFont(f);
		p4.add(b1);
		p4.add(b2);
		p4.add(b3);
		p4.add(bt);
		
		
		//p5
		JButton bc = new JButton("C");
		JButton b0 = new JButton("0");
		JButton be = new JButton("=");
		JButton bd = new JButton("÷");
		bc.setFont(f);
		b0.setFont(f);
		be.setFont(f);
		bd.setFont(f);
		p5.add(bc);
		p5.add(b0);
		p5.add(be);
		p5.add(bd);

		//컨테이너 적재
		con.add(p1);
		con.add(p2);
		con.add(p3);
		con.add(p4);
		con.add(p5);
		
		//ActionListener
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		
		//윈도우 생성
		setTitle("계산기 실습");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String s = jtf.getText();
		String s1 = e.getActionCommand();
		
		switch (s) {
		case "0": jtf.setText(s1); break;
		default: jtf.setText(s + s1);
		}
		

	}
}

public class Swing13 {
	public static void main(String[] args) {

		new Calculator();

	}

}

package days21;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//라디오 버튼
class JRadioButtonTest extends JFrame implements ActionListener {

	JRadioButton jrb1;
	JRadioButton jrb2;
	JRadioButton jrb3;
	JRadioButton jrb4;
	ButtonGroup bg;
	JTextField jtf;
	
	JRadioButtonTest() {
		jrb1 = new 	JRadioButton("승마");
		jrb2 = new 	JRadioButton("골프");
		jrb3 = new 	JRadioButton("글라이딩");
		jrb4 = new 	JRadioButton("스쿠버");
		jtf = new JTextField(30);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		
		Font f = new Font("굴림", Font.BOLD, 20);
		jrb1.setFont(f);
		jrb2.setFont(f);
		jrb3.setFont(f);
		jrb4.setFont(f);
		jtf.setFont(f);
		
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);
		
		con.add(jrb1);
		con.add(jrb2);
		con.add(jrb3);
		con.add(jrb4);
		con.add(jtf);
		
		jrb1.addActionListener(this);
		jrb2.addActionListener(this);
		jrb3.addActionListener(this);
		jrb4.addActionListener(this);
		
		setTitle("라디오박스 테스트");
		setSize(600, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(jrb1.isSelected()) jtf.setText(jrb1.getActionCommand() + " 이/가 선택되었습니다.");
		else if(jrb2.isSelected()) jtf.setText(jrb2.getActionCommand() + " 이(가) 선택되었습니다.");
		else if(jrb3.isSelected()) jtf.setText(jrb3.getActionCommand() + " 이(가) 선택되었습니다.");
		else jtf.setText(jrb4.getActionCommand() + " 이(가) 선택되었습니다.");
		
	}
	

}
public class Swing17 {

	public static void main(String[] args) {
		
		new JRadioButtonTest();

	}
}

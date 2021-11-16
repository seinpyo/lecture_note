package days21;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class JTextFieldTextArea extends JFrame implements ActionListener {

	JTextField jtf;
	JTextArea jta;
	JTextFieldTextArea() {
		jtf = new JTextField(10);
		jta = new JTextArea(7,20); // 
		
		Font f = new Font("굴림",Font.BOLD,20);
		
		JButton k = new JButton("확인");
		
		jtf.setFont(f);
		jta.setFont(f);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		
		k.addActionListener(this);
		
		con.add(jtf);
		con.add(jta);
		con.add(k);
		
		
		
		setTitle("텍스트 필드 텍스트 에어리어");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String s = jtf.getText();
		//텍스트 필드의 텍스트 에어리어 뒤쪽에 내용을 이어붙이기
		jta.append(s + "\n"); 
		jtf.setText("");
	
	}

}


public class Swing15 {
	public static void main(String[] args) {
		new JTextFieldTextArea();

	}

}
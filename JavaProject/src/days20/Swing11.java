package days20;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TextFieldEx extends JFrame implements ActionListener {

	JTextField t1;
	JTextField t2;
	JButton b1;
	JButton b2;

	TextFieldEx() {
		t1 = new JTextField(15);
		t2 = new JTextField(15);
		b1 = new JButton(">");
		b2 = new JButton("<");

		b1.addActionListener(this);
		b2.addActionListener(this);

		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(t1);
		con.add(b1);
		con.add(b2);
		con.add(t2);

		setTitle("텍스트 필드 예제");
		setSize(500, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String s = e.getActionCommand();

		if (s.equals(">")) {
			if (!(t1.getText().equals(""))) {
				t2.setText(t1.getText());
				t1.setText("");
			}
		} else {
			if (!(t2.getText().equals(""))) {
				t1.setText(t2.getText());
				t2.setText("");

			}
		}
	}
}

public class Swing11 {
	public static void main(String[] args) {
		new TextFieldEx();
	}

}

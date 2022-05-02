package days21;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class JCheckBoxTest extends JFrame implements ItemListener {
	
	JTextField jtf;
	JCheckBox jcb1;
	JCheckBox jcb2;
	JCheckBox jcb3;
	JCheckBox jcb4;
	
	JCheckBoxTest() {
		
		jcb1 = new JCheckBox("JSP");
		jcb2 = new JCheckBox("PHP");
		jcb3 = new JCheckBox("ASP");
		jcb4 = new JCheckBox("SEREVELT");
		jtf = new JTextField(30);
		
		Font f = new Font("굴림", Font.BOLD, 20);
		jcb1.setFont(f);
		jcb2.setFont(f);
		jcb3.setFont(f);
		jcb4.setFont(f);
		jtf.setFont(f);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(jcb1);
		con.add(jcb2);
		con.add(jcb3);
		con.add(jcb4);
		con.add(jtf);
		
		jcb1.addItemListener(this);
		jcb2.addItemListener(this);
		jcb3.addItemListener(this);
		jcb4.addItemListener(this);
		
		setTitle("체크박스테스트");
		setSize(600, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		//상태가 true/false 중 어떻게 변했는지 감지
		String s  = "";
		if(jcb1.isSelected()) s = s + "JSP ";
		if(jcb2.isSelected()) s = s + jcb2.getActionCommand() + " ";
		if(jcb3.isSelected()) s = s + "ASP ";
		if(jcb4.isSelected()) s = s + jcb4.getActionCommand() + " ";
		//선택될 내용을 직접 입력하거나 getActionCommand()를 사용할 수 있다.
		
		jtf.setText("현재 선택 항목 : " + s);
	}
	
}
public class Swing16 {

	public static void main(String[] args) {
		
		new JCheckBoxTest();
	}

}

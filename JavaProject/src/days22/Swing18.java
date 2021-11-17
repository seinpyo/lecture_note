package days22;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//선택 내용에 따라 이미지가 달라지는 콤보상자 

class JComboBoxTest extends JFrame implements ItemListener {
	
	JLabel jl;
	ImageIcon ii;
	
	JComboBoxTest(){
		JComboBox<String>jcb = new JComboBox<>();
		ii = new ImageIcon("Images/banana.jpg");
		jl = new JLabel(ii);
		
		
		jcb.addItem("banana");
		jcb.addItem("apple");
		jcb.addItem("pear");
		jcb.addItem("cherry");
		jcb.addItem("grape");
	
		Font f = new Font("굴림", Font.BOLD,20);
		jcb.setFont(f);
		
		jcb.addItemListener(this);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(jcb);
		con.add(jl);
		
		setTitle("콤보 박스 테스트");
		setSize(500, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		String jcb1 = (String)e.getItem(); //상태가 변환 컨트롤의 현재 선택값 추출 
		ImageIcon ni = new ImageIcon("images/" + jcb1 + ".jpg");
		jl.setIcon(ni); //이미지 교체
	}
}

public class Swing18 {
	public static void main(String[] args) {
		
		new JComboBoxTest();
	}
}

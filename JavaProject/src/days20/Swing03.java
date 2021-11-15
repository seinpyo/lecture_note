package days20;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ButtonEvent extends JFrame implements ActionListener{
	
	//버튼 클릭에 의해서 실행결과가 담길 라벨을 전역변수로 선언
	JLabel result = new JLabel(""); //어떤 메소드에서도 사용가능
	
	ButtonEvent() {
		JButton male = new JButton("남자");
		JButton female = new JButton("여자");
		JLabel label = new JLabel("당신의 성별은?");
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(label);
		con.add(male);
		con.add(female);
		con.add(result);
		
		//이벤트를 설정하고 감지할 리스너를 적용하고자하는 컨트롤에 붙인다
		//해당 컨트롤에 클릭등 이벤트가 발생하면 자동으로 actionPerformed 메소드가 
		//실행된다.
		
		male.addActionListener(this);
		female.addActionListener(this);
		
		setTitle("버튼 이벤트 테스트");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//클릭된 컨트롤에 표시된 값이 s에 저장 
		String s = e.getActionCommand();
		result.setText(s);
		
		
	}
	
}

public class Swing03  {
	public static void main(String[] args) {
		
		new ButtonEvent();
	}

}

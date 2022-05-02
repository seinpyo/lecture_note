package days20;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ButtonTest extends JFrame{
	
	//생성자
	ButtonTest(){
		//Jbutton 클래스의 객체 생성
		JButton male = new JButton("남자");
		JButton female = new JButton("여자");
		
		JLabel label = new JLabel("당신의 성별은?");
		
		Container con = getContentPane(); //JFrame 안에 있는 메서드 
		con.setLayout(new FlowLayout()); 
		
		con.add(label);
		con.add(male);
		con.add(female);
		
		setTitle("버튼 컴퍼넌트 테스트");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
public class Swing01 {
	public static void main(String[] args) {
		
		new ButtonTest();

		
	}
}

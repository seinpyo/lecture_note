package days20;

//버튼 만들기 연습 
import javax.swing.*;
import java.awt.*;


class ButtonTest2 extends JFrame {
	
	ButtonTest2() {
		
		JButton one = new JButton("1");
		JButton two = new JButton("2");
		JButton three = new JButton("3");
		JButton four = new JButton("4");
		JButton five = new JButton("5");
		JButton six = new JButton("6");
		JButton seven = new JButton("7");
		JButton eight = new JButton("8");
		JButton nine = new JButton("9");
		JButton zero = new JButton("0");
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		JButton times = new JButton("×");
		JButton divide = new JButton("÷");
		JButton equal = new JButton("=");
		JButton cancel = new JButton("C");
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout()); 
		
		con.add(seven);
		con.add(eight);
		con.add(nine);
		con.add(plus);
		con.add(four);
		con.add(five);
		con.add(six);
		con.add(minus);
		con.add(one);
		con.add(two);
		con.add(three);
		con.add(times);
		con.add(equal);
		con.add(zero);
		con.add(cancel);
		con.add(divide);
		
		setTitle("버튼 컴퍼넌트 테스트");
		setSize(220,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}



public class Swing02 {
	public static void main(String[] args) {
		
		new ButtonTest2();
		
	}

}

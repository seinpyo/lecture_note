package days21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calculator extends JFrame implements ActionListener {

	JTextField jtf = new JTextField(20);
	int firstNumber; 	//첫번째 숫자 저장
	int secondNumber;	//두번째 숫자 
	int result1;		//정수 결과
	double result2;		//실수 결과
	int operator = 0; 

	Calculator() {

		// 폰트 사용
		Font f = new Font("굴림", Font.BOLD, 20);
		jtf.setFont(f);

		Container con = getContentPane();
		con.setLayout(new GridLayout(6, 1));

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();

		p2.setLayout(new GridLayout(1, 4));
		p3.setLayout(new GridLayout(1, 4));
		p4.setLayout(new GridLayout(1, 4));
		p5.setLayout(new GridLayout(1, 4));
		p6.setLayout(new GridLayout(1, 4));

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
		
		//p6
		JButton back = new JButton("◀");
		JButton sqr = new JButton("sqr");
		JButton divide1 = new JButton("1/x");
		JButton bn = new JButton("%"); //나머지 연산자
		back.setFont(f);
		sqr.setFont(f);
		divide1.setFont(f);
		bn.setFont(f);
		p6.add(back);
		p6.add(sqr);
		p6.add(divide1);
		p6.add(bn);

		//컨테이너 적재
		
		con.add(p1);
		con.add(p6);
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
		bp.addActionListener(this);
		bm.addActionListener(this);
		bt.addActionListener(this);
		bd.addActionListener(this);
		bc.addActionListener(this);
		be.addActionListener(this);
		back.addActionListener(this);
		sqr.addActionListener(this);
		divide1.addActionListener(this);
		bn.addActionListener(this);
		
		//윈도우 생성
		setTitle("계산기 실습");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String oldText = jtf.getText();
		String s = e.getActionCommand();
		String newText;
		
		switch (s) {
		case "+": 
			operator = 1;
			firstNumber = Integer.parseInt(jtf.getText());
			jtf.setText("0");
			break;
		case "-": 
			operator = 2;
			firstNumber = Integer.parseInt(jtf.getText());
			jtf.setText("0");
			break;
		case "×": 
			operator = 3;
			firstNumber = Integer.parseInt(jtf.getText());
			jtf.setText("0");
			break;
		case "÷": 
			operator = 4;
			firstNumber = Integer.parseInt(jtf.getText());
			jtf.setText("0");
			break;
		case "C": 
			jtf.setText("0");
			break; 
		case "◀" :
			if (jtf.getText().length() == 1) {
				jtf.setText("0");
			} else {
				jtf.setText(oldText.substring(0,jtf.getText().length()-1));
			}
			break;
		case "sqr" :
			if (jtf.getText().length() == 0) break;
			else {
				firstNumber = Integer.parseInt(jtf.getText());
				result2 = Math.sqrt((double) firstNumber);
				jtf.setText(String.valueOf(result2));
			}
			break;
		case "1/x" :
			if (jtf.getText().length() == 0) break;
			else {
				firstNumber = Integer.parseInt(jtf.getText());
				result2 = 1.0/firstNumber;
				jtf.setText(String.valueOf(result2));
			}
			break;
		case "%" :
			operator = 5;
			firstNumber = Integer.parseInt(jtf.getText());
			jtf.setText("0");
			break;
			
		case "=": 
			switch(operator) {
				case 1: 
					secondNumber = Integer.parseInt(jtf.getText());
					result1 = firstNumber + secondNumber;
					jtf.setText(String.valueOf(result1));
					break;
				case 2:
					secondNumber = Integer.parseInt(jtf.getText());
					result1 = firstNumber - secondNumber;
					jtf.setText(String.valueOf(result1));
					break;
				case 3:
					secondNumber = Integer.parseInt(jtf.getText());
					result1 = firstNumber * secondNumber;
					jtf.setText(String.valueOf(result1));
					break;
				case 4:
					secondNumber = Integer.parseInt(jtf.getText());
					result2 = firstNumber / (double) secondNumber;
					jtf.setText(String.valueOf(result2));
					break;
				case 5:
					secondNumber = Integer.parseInt(jtf.getText());
					result1 = firstNumber % secondNumber;
					jtf.setText(String.valueOf(result1));
					break;
			}
			break;
			
		case "0": case "1": case "2": case "3": case "4": 
		case "5": case "6": case "7": case "8": 		
		case "9": 
			if(oldText.equals("0")) oldText = "";
			jtf.setText(oldText + s);
			break;	
		
		
		}
	}
}

public class Swing13 {
	public static void main(String[] args) {

		new Calculator();

	}

}

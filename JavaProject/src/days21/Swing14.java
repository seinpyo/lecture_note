package days21;

import java.awt.event.*;
import java.util.Calendar;
import java.awt.*;
import javax.swing.*;

class Calendars extends JFrame implements ActionListener {
	
	static int year = 0;
	static int month = 0;
	static JTextField[] jt = new JTextField[42];
	//1년 달력의 42개(42주)의 열을 제작 
	
	JTextField y;
	JTextField m;
	
	Calendars() {
	
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		JPanel jp1 = new JPanel();	//월~금 요일
		JPanel jp2 = new JPanel();	//6*7 날짜
		JPanel jp3 = new JPanel();	//이전달다음달버튼
		
		jp1.setLayout(new GridLayout(1,7));
		jp2.setLayout(new GridLayout(6,7));
		jp3.setLayout(new FlowLayout());
		
		jp1.add(new JButton("일")).setForeground(Color.RED); //색지정
		jp1.add(new JButton("월"));
		jp1.add(new JButton("화"));
		jp1.add(new JButton("수"));
		jp1.add(new JButton("목"));
		jp1.add(new JButton("금"));
		jp1.add(new JButton("토")).setForeground(Color.BLUE);
		
		Font f = new Font("굴림", Font.BOLD, 20);
		
		
		//for문을 통해 날짜가 될 textfield 제작
		for(int i=0; i<42; i++) {
			jt[i] = new JTextField(); //textfield 객체 생성
			jt[i].setFont(f);	//폰트설정
			jt[i].setHorizontalAlignment(SwingConstants.RIGHT);	//오른쪽정렬
			jt[i].setEditable(false);	//수정 불가 -> 설정 시 글자색이 연해짐
			jt[i].setBackground(Color.WHITE); 
			if(i%7==6) jt[i].setForeground(Color.BLUE); //토요일
			else if(i%7==0) jt[i].setForeground(Color.RED); //일요일
			else jt[i].setForeground(Color.BLACK);
			jp2.add(jt[i]);
		}
		
		y = new JTextField(6);
		y.setFont(f);
		y.setHorizontalAlignment(SwingConstants.CENTER);
		y.setBackground(Color.WHITE);
		
		m = new JTextField(4);
		m.setFont(f);
		m.setHorizontalAlignment(SwingConstants.CENTER);
		m.setBackground(Color.WHITE);
		
		Calendar Today = Calendar.getInstance();
		y.setText(String.valueOf(Today.get(Calendar.YEAR)));
		m.setText(String.valueOf(Today.get(Calendar.MONTH)+1));
		
		JButton b = new JButton("확인");
		JButton b1 = new JButton("이전달");
		JButton b2 = new JButton("다음달");
		
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		con.add(jp1, BorderLayout.NORTH);
		con.add(jp2, BorderLayout.CENTER);
		con.add(jp3, BorderLayout.SOUTH);
		
		jp3.add(b1);
		jp3.add(y);
		jp3.add(new JLabel("년"));
		jp3.add(m);
		jp3.add(new JLabel("월"));
		jp3.add(b);
		jp3.add(b2);
		
		//윈도우 생성
		setTitle("스윙 캘린더");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
//		
		year = Integer.parseInt(y.getText());
		month = Integer.parseInt(m.getText());
		drawCalendar();
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//이전달 다음달 버튼에 따라 year,month 변수를 계산 후
		//drawCalendar() 호출
	
		String s = e.getActionCommand();
		switch(s) {
			case "이전달": 
				if(month == 1) {
					year--; month = 12;
				} else month--;
				break;
			case "다음달":
				if(month == 12) {
					year++; month = 1;
				} else month++;
				break;
			case "확인":
				int tempY = Integer.parseInt(y.getText());
				int tempM = Integer.parseInt(m.getText());
				if(tempY>=1&&tempM<=3000) year = Integer.parseInt(y.getText());
				if(tempM>=1 && tempM<=12) month = Integer.parseInt(m.getText());
		}
		
		y.setText(String.valueOf(year));
		m.setText(String.valueOf(month));
	
		for(int i=0; i<jt.length; i++) jt[i].setText("");
		drawCalendar();
	}
	
	private void drawCalendar() {
		//해당 년월의 달력을 화면에 표시
		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();
		
		sDay.set(year,month-1,1); //오늘 날짜 월의 1일
		eDay.set(year,month,1);
		eDay.add(Calendar.DATE,-1); //오늘 날짜 월의 말일
		
		int START_WEEK = sDay.get(Calendar.DAY_OF_WEEK); //시작 요일
		
		int k;
	
		//TextField가 다 비워져 있는 상태에서
		//1일자의 요일(1,2,3,4...)번째 (k-1)의 TextField부터 날짜 표시
		//이전 칸들은 비워둔채로 시작
		//각 TextField에 sDay의 값들을 표시 -> 일자만 표시
		//한 번 반복마다 날짜는 1일씩 늘어난다. (eDay<=sDay까지)
		for(int i=START_WEEK-1; sDay.before(eDay)||sDay.equals(eDay); sDay.add(Calendar.DATE, 1)) {
			//1일부터 말일까지
			int day = sDay.get(Calendar.DATE);
			jt[i++].setText(String.valueOf(day));
			
		}
			
	}
	
}
public class Swing14 {
	public static void main(String[] args) {
		
		new Calendars();
	}
}

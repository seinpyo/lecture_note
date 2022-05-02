package days22;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class Resume extends JFrame implements ActionListener, ItemListener{
	
	JTextField jt_name;
	JRadioButton jr1;
	JRadioButton jr2; //남여
	JCheckBox jc1; //스포츠
	JCheckBox jc2;	//영화
	JCheckBox jc3;	//독서
	JCheckBox jc4;	//기타
	JComboBox<String> phone; //전화번호 
	JTextField jtf1; //전번2
	JTextField jtf2; //전번3
	JComboBox<String> adreesJcb; //지역
	JButton jb;
	
	Resume() {
		
		JPanel jp1 = new JPanel();	//6*1
		JPanel jp2 = new JPanel(); //6*1
		
		Font f = new Font("굴림", Font.BOLD, 20);
		
		Container con = getContentPane();
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));
		con.setLayout(new BorderLayout());
		
		
		JLabel name = new JLabel(" 성      명  :");
		JLabel gender = new JLabel(" 성      별 :");
		JLabel hobby = new JLabel(" 취      미 :");
		JLabel phoneNumber = new JLabel(" 전 화 번 호 :");
		JLabel adreess = new JLabel(" 거 주 지 역 :");
		
		name.setFont(f);
		gender.setFont(f);
		hobby.setFont(f);
		phoneNumber.setFont(f);
		adreess.setFont(f);
		
		jp1.add(name);
		jp1.add(gender);
		jp1.add(hobby);
		jp1.add(phoneNumber);
		jp1.add(adreess);
	
		
		JPanel jp2_1 = new JPanel(); //성명
		JPanel jp2_2 = new JPanel(); //성별
		JPanel jp2_3 = new JPanel(); //취미
		JPanel jp2_4 = new JPanel(); //전화번호
		JPanel jp2_5 = new JPanel(); //거주지역
		JPanel jp2_6 = new JPanel(); //확인버튼
		
		jp2_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2_3.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2_4.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2_5.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2_6.setLayout(new FlowLayout(FlowLayout.CENTER));
		

		
		jt_name = new JTextField(15);
		jt_name.setFont(f);
		jp2_1.add(jt_name);
		
		ButtonGroup bg = new ButtonGroup();
		jr1 = new JRadioButton("남성");
		jr2 = new JRadioButton("여성");
		jr1.setFont(f);
		jr2.setFont(f);
		bg.add(jr1);
		bg.add(jr2);
		jp2_2.add(jr1);
		jp2_2.add(jr2);
		
		jc1 = new JCheckBox("스포츠");
		jc2 = new JCheckBox("영화");
		jc3 = new JCheckBox("독서");
		jc4 = new JCheckBox("기타");
		jc1.setFont(f);
		jc2.setFont(f);
		jc3.setFont(f);
		jc4.setFont(f);
		jp2_3.add(jc1);
		jp2_3.add(jc2);
		jp2_3.add(jc3);
		jp2_3.add(jc4);
		
		phone = new JComboBox<>();
		phone.addItem("010");
		phone.addItem("011");
		phone.addItem("017");
		phone.addItem("019");
		JLabel dash = new JLabel("-");
		JLabel dash2 = new JLabel("-");
		jtf1 = new JTextField(5);
		jtf2 = new JTextField(5);
		phone.setFont(f);
		dash.setFont(f);
		dash2.setFont(f);
		jtf1.setFont(f);
		jtf2.setFont(f);
		jp2_4.add(phone);
		jp2_4.add(dash2);
		jp2_4.add(jtf1);
		jp2_4.add(dash);
		jp2_4.add(jtf2);
		
		adreesJcb = new JComboBox();
		adreesJcb.addItem("서울");
		adreesJcb.addItem("부산");
		adreesJcb.addItem("광주");
		adreesJcb.addItem("대구");
		adreesJcb.addItem("울산");
		adreesJcb.addItem("인천");
		adreesJcb.addItem("대전");
		adreesJcb.addItem("제주");
		adreesJcb.addItem("경기도");
		adreesJcb.addItem("강원도");
		adreesJcb.addItem("충청도");
		adreesJcb.addItem("전라도");
		adreesJcb.addItem("경상도");
		adreesJcb.setFont(f);
		jp2_5.add(adreesJcb);
				
		jb = new JButton("확인");
		jp2_6.add(jb);
		
		jp2.add(jp2_1);
		jp2.add(jp2_2);
		jp2.add(jp2_3);
		jp2.add(jp2_4);
		jp2.add(jp2_5);
		jp2.add(jp2_6);
		con.add(jp1,BorderLayout.WEST);
		con.add(jp2,BorderLayout.CENTER);
		
		jb.addActionListener(this);
	
		setTitle("콤보 박스 테스트");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = jt_name.getText();
		String gender;
		String hobby;
		String phone0;
		String phone1 = jtf1.getText();
		String phone2 = jtf2.getText();
		
		System.out.println("성명 : " + jt_name.getText());
		if(jr1.isSelected()) gender = "남성";
		else gender = "여성";
		System.out.println("성별 : " + gender);
		
		if(jc1.isSelected()) hobby = jc1.getText() + " "; 
		else if(jc2.isSelected()) hobby = jc2.getText() + " "; 
		else if(jc3.isSelected()) hobby = jc3.getText() + " "; 
		else hobby = jc4.getText() + " "; 
		System.out.println("취미 : " + hobby);
		phone0 = (String) phone.getSelectedItem();
		System.out.println("전화번호 : " + phone0 + " - " + phone1 + " - " + phone2);
		System.out.println("거주지역 : " + adreesJcb.getSelectedItem());
	
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
	}
}

public class Swing19 {
	public static void main(String[] args) {
		new Resume();
	
	}

}

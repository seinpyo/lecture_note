package student.main;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import student.dto.EMSInformationService;
import student.dto.Student;
import student.service.SelectAllService;
import student.service.SelectOneService;
import student.service.UpdateService;

public class MainClass {

	public static void main(String[] args) {
//		String[] sNums= {"H39adsklr2","H39illemamca8w8fgs","H39lkmn757fisj7","H39plo9472c8k92",
//				"H39mnbvviaeew89q1","H39omisdn58sd5","H39ymbsch384fh2","H39bmshhduwnqn283"};
//		
//		String[] sIds = {"hippo", "raccoon","elephant","lion","tiger","horse","bird","deer"};
//		String[] sPws = {"94823","19234","10583","23960","10298","05931","39499","12345"};
//		String[] sNames = {"barbara", "chris","doris","elva","fiona","holly","jasmin","lena","melissa"};
//		int[] sAges = {22,20,27,18,25,22,24,21};
//		String[] sGenders = {"W","W","M","M","W","M","W","W"};
//		String[] sMajors = {"Korean Literature","French Literature","Philosophy",
//				"History","Law","Statistics","Computer","Economics"};
//		
		GenericXmlApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:applicationContext.xml");
////		InsertService is = ctx.getBean("insertservice", InsertService.class);
////		
////		for(int i=0; i<sNums.length; i++) {
////			Student std = new Student(sNums[i], sIds[i], sPws[i], sNames[i],sAges[i], 
////					sGenders[i], sMajors[i]);
////			is.InsertStudent(std);
////		}
//		
//		SelectAllService sas = ctx.getBean("selectallservice", SelectAllService.class);
//		ArrayList<Student> list = sas.selectAllStudent();
//		for(int i=0; i<list.size(); i++) {
//			//System.out.print("| sNum : " + list.get(i).getsNum() + "\t");
//			System.out.print("| sId : " + list.get(i).getsId() + "\t");
//			System.out.print("| sName : " + list.get(i).getsName() + "\t");
//			//System.out.print("| sAge : " + list.get(i).getsAge() + "\t");
//			//System.out.print("| sGender : " + list.get(i).getsGender() + "\t");
//			System.out.print("| sMajor : " + list.get(i).getsMajor() + "\t");
//			System.out.println();
//		}
//		Scanner sc = new Scanner(System.in);
//		System.out.printf("조회할 학생의 아이디를 입력하세요 : ");
//		String id = sc.nextLine();
//		
//		SelectOneService sos = ctx.getBean("selectoneservice", SelectOneService.class);
//		Student std = sos.selectOneStudent(id);
//		System.out.println("| sNum : " + std.getsNum() + "\t");
//		System.out.println("| sId : " + std.getsId() + "\t");
//		System.out.println("| sPw : " + std.getsPw() + "\t");
//		System.out.println("| sName : " + std.getsName() + "\t");
//		System.out.println("| sAge : " + std.getsAge() + "\t");
//		System.out.println("| sGender : " + std.getsGender() + "\t");
//		System.out.println("| sMajor : " + std.getsMajor() + "\t");
//		
//		sc = new Scanner(System.in);
//		System.out.printf("수정할 학생의 아이디를 입력하세요 : ");
//		id = sc.nextLine();
//		std = sos.selectOneStudent(id);
//		if(std == null) {
//			System.out.println("조회한 id가 존재하지 않습니다.");
//		} 
//		
//		System.out.printf("수정할 비밀번호를 입력하세요. : ");
//		String pw = sc.nextLine();
//		if(!pw.equals("")) std.setsPw(pw);
//		
//		System.out.printf("기존 이름 : %s, 수정할 이름을 입력하세요. : ", std.getsName());
//		String name = sc.nextLine();
//		if(!name.equals("")) std.setsName(name);
//		
//		System.out.printf("기존 나이 : %s, 수정할 나이 입력하세요. : ", std.getsAge());
//		String age = sc.nextLine();
//		if(!age.equals("")) std.setsAge(Integer.parseInt(age));
//		
//		System.out.printf("기존 성별 : %s, 수정할 성별을 입력하세요. : ", std.getsGender());
//		String gender = sc.nextLine();
//		if(!gender.equals("")) std.setsGender(gender);
//		
//		System.out.printf("기존 전공 : %s, 수정할 전공을 입력하세요. : ", std.getsMajor());
//		String major = sc.nextLine();
//		if(!major.equals("")) std.setsMajor(major);
//		
//		UpdateService us = ctx.getBean("updateservice", UpdateService.class);
//		us.UpdateStudent(std);
//		
//		System.out.println("아래와 같이 수정되었습니다.");
//		Student ustd = sos.selectOneStudent(id);
//		System.out.println("| sNum : " + std.getsNum() + "\t");
//		System.out.println("| sId : " + std.getsId() + "\t");
//		System.out.println("| sPw : " + std.getsPw() + "\t");
//		System.out.println("| sName : " + std.getsName() + "\t");
//		System.out.println("| sAge : " + std.getsAge() + "\t");
//		System.out.println("| sGender : " + std.getsGender() + "\t");
//		System.out.println("| sMajor : " + std.getsMajor() + "\t");
		
		EMSInformationService eis = ctx.getBean("informationservice", EMSInformationService.class);
		eis.outputEMSInfomation();
	}
}

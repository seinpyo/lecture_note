package jdbc04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class MemberDriver {

	public static void main(String[] args) {
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("\n---메뉴선택---");
			System.out.printf("1.데이터열람 2.데이터추가 3.데이터수정 4.데이터삭제");
			System.out.print(" 5.프로그램 종료 >> 메뉴선택 : ");
			String choice = sc.nextLine();
			if(choice.equals("5")) break;
			MemberDao mdao = MemberDao.getInstance();
			switch(choice) {
				case"1": 
					select(sc);
					break;
				case"2": 
					insert(sc);
					break;
				case"3":
					update(sc);
					break;
				case"4": 
				//	delete(sc));
					break;
				default : System.out.println("메뉴 선택이 잘못되었습니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

	private static void update(Scanner sc) {
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = new MemberDto();
		
		int membernum;
		while(true) {
			System.out.print("수정할 회원 번호를 입력하세요(필수) : ");
			String input = sc.nextLine();
			if(input.equals("")) {
				System.out.print("회원 번호 입력은 필수 입니다.\n");
			} else { 
				membernum = Integer.parseInt(input);
				break;
			}
		}
		
		mdto = mdao.getMember(membernum); 
		if(mdto==null) {
			System.out.println("해당 회원이 존재하지 않습니다.");
			return;
		}
		
		//이름입력후 mdto에 저장
		System.out.println("검색된 회원의 정보를 수정합니다.");
		System.out.println("수정을 원하지 않는 항목은 엔터를 눌러주세요\n");
		
		System.out.println("수정할 이름을 입력하세요.");
		String name = sc.nextLine();
		if(!name.equals("")) mdto.setName(name); 
		
		System.out.println("수정할 전화번호를 입력하세요.");
		String phone = sc.nextLine();
		if(!phone.equals("")) mdto.setPhone(phone); 
		
		System.out.println("수정할 성별 입력하세요.");
		String gender = sc.nextLine();
		if(!gender.equals("")) mdto.setGender(gender); 
		
		System.out.println("수정할 포인트를 입력하세요.");
		String bpoint = sc.nextLine();
		if(!bpoint.equals("")) mdto.setBpoint(Integer.parseInt(bpoint)); 
		
		System.out.printf("수정할 생일을 입력하세요(YYYY-MM-DD) : ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		while(true) {
			try {
				d=sdf.parse(sc.nextLine());
				break;
			} catch (ParseException e) {
				System.out.println("입력 형식을 지켜 다시 입력해주세요.(입력예 : 1999-12-31)");
			}
		}
		
		/*
		 * java.sql.Date birth = new java.sql.Date(d.getTime()); mdto.setBirth(birth);
		 * 
		 * Calendar c = Calendar.getInstance(); Calendar today = Calendar.getInstance();
		 * c.setTime(d); int age = today.get(Calendar.YEAR) - c.get(Calendar.YEAR) + 1;
		 * mdto.setAge(age);
		 * 
		 * int result = mdao.update(mdto); if(result==1)System.out.println("레코드 수정 성공");
		 * else System.out.println("레코드 수정 실패");
		 */
		
	}

	private static void insert(Scanner sc) {
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = new MemberDto();
		
		//회원번호는 sequence 이용 
		
		System.out.printf("이름을 입력하세요 : ");
		mdto.setName(sc.nextLine());
		
		System.out.printf("전화번호를 입력하세요 : ");
		mdto.setPhone(sc.nextLine());
		
		System.out.printf("성별을 입력하세요(M/F) : ");
		mdto.setGender(sc.nextLine());
		
		//생일 입력 : java.util.Date() 형식의 입력 후 java.sql.Date()로 변환이 필요하다 
		//java.util.Date()의 입력을 위해서는 SimpleDateFormat의 parse 동작이 필요
		System.out.printf("생일을 입력하세요(YYYY-MM-DD) : ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		while(true) {
			try {
				d=sdf.parse(sc.nextLine());
				break;
			} catch (ParseException e) {
				System.out.println("입력 형식을 지켜 다시 입력해주세요.(입력예 : 1999-12-31)");
			}
		}
		//java.sql.Date로 변환
		java.sql.Date birth = new java.sql.Date(d.getTime());
		//dto에 입력
		mdto.setBirth(birth);
		
		Calendar c = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		c.setTime(d); // c.setTime(birth); Date 자료를 Calendar 자료로 변환
		int age = today.get(Calendar.YEAR) - c.get(Calendar.YEAR) + 1; //나이 계산
		mdto.setAge(age);
		
		int result = mdao.insert(mdto);
		if(result==1) System.out.println("레코드 추가 성공");
		else System.out.println("레코드 추가 실패");
		
	}

	private static void select(Scanner sc) {
		MemberDao mdao = MemberDao.getInstance();
		ArrayList<MemberDto> list = mdao.select();
		
		System.out.println("\n번호\t이름\t\t전화\t\t생일\t\t포인트\t나이\t성별\t가입일");
		System.out.println("--------------------------------------------------------------------------------------------");
		for(MemberDto dto : list) {
			System.out.printf("%d\t%s\t\t%s\t%s\t%d\t%d\t%s\t%s\n",
					dto.getMembernum(), dto.getName(), dto.getPhone(), dto.getBirth(), dto.getBpoint(), 
					dto.getAge(), dto.getGender(), dto.getJoindate());

		}
		
	}


}
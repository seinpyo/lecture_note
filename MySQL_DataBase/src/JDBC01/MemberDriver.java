package JDBC01;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

	public class MemberDriver {
		public static void main(String[] args) {
			while(true){
				Scanner sc = new Scanner(System.in);
				System.out.println("\n---메뉴선택---");
				System.out.printf("1.데이터열람 2.데이터추가 3.데이터수정 4.데이터삭제");
				System.out.printf("5.프로그램 종료 >> 메뉴선택 : ");
				String choice = sc.nextLine();
				if(choice.equals("5")) break;
				MemberDao mdao = MemberDao.getInstance();
				switch(choice) {
					case"1": 
						select();
						break;
					case"2": 
						insert();
						break;
					case"3":
						update();
						break;
					case"4": 
						delete();
						break;
					default : System.out.println("메뉴 선택이 잘못되었습니다.");
				}
			}
			System.out.println("프로그램을 종료합니다.");
			}

	
	private static void delete() {
		Scanner sc = new Scanner(System.in);
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = null;
		
		System.out.print("수정할 회원 번호를 입력하세요 : ");
		String input;
		while(true) {
			input = sc.nextLine();
			if(input.equals("")) System.out.print("회원 번호 입력은 필수 입니다."
					+ "\n삭제할 회원 번호를 입력하세요 : ");
			else break;	
		}
		
		mdto = mdao.selectOne(Integer.parseInt(input));
		if(mdto == null) {
			System.out.println("입력한 회원 번호가 존재하지 않습니다.");
			return;
		}
		
		int result = mdao.delete(Integer.parseInt(input));
		if(result == 1) System.out.println("\n레코드 삭제 성공");
		else System.out.println("\n레코드 삭제 실패");
		
	}


	private static void update() {
		Scanner sc = new Scanner(System.in);
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = null;
		
		//대여번호
		System.out.print("수정할 회원 번호를 입력하세요 : ");
		String input;
		while(true) {
			input = sc.nextLine();
			if(input.equals("")) System.out.println("회원 번호 입력은 필수 입니다."
					+ "삭제할 회원 번호를 입력하세요 : ");
			else break;
		}
		mdto = mdao.selectOne(Integer.parseInt(input));
		if(mdto == null) {
			System.out.println("입력한 회원 번호가 존재하지 않습니다.");
			return;
		}
		
		System.out.println("회원 정보를 수정합니다. "
				+ "수정을 원치 않는 항목은 엔터를 입력해주세요.");
		
		System.out.printf("이름을 입력하세요(기존 성명 : %s) : ", mdto.getName());
		String name = sc.nextLine();
		if(!name.equals("")) mdto.setName(name);
		
		System.out.printf("전화번호를 입력하세요(기존 전화번호 : %s) : ", mdto.getPhone());
		String phone = sc.nextLine();
		if(!phone.equals("")) mdto.setPhone(phone);
		
		System.out.printf("생년월일 입력하세요(YYYY-MM-DD)(기존 생년월일 : %s) : ", mdto.getBirth());
		String birth = sc.nextLine();
		if(!birth.equals("")) mdto.setBirth(birth);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - Integer.parseInt(birth.substring(0,4)) + 1;
		mdto.setAge(age);
		
		System.out.printf("성별을 입력하세요(기존 성별 : %s) : ", mdto.getGender());
		String gender = sc.nextLine();
		if(!gender.equals("")) mdto.setGender(gender);
		
		int result = mdao.update(mdto);
		if(result == 1) System.out.println("\n레코드 수정 성공");
		else System.out.println("\n레코드 수정 실패");
		
	}
	
	private static void insert() {
			MemberDao mdao = MemberDao.getInstance();
			Scanner sc = new Scanner(System.in);
			MemberDto mdto = new MemberDto();
			
			System.out.print("이름을 입력하세요 : ");
			mdto.setName(sc.nextLine());

			System.out.print("전화번호를 입력하세요 : ");
			mdto.setPhone(sc.nextLine());

			System.out.print("생일 입력하세요(YYYY-MM-DD) : ");
			String birth = sc.nextLine();
			mdto.setBirth(birth);
			
			String year = birth.substring(0,4);
			Calendar today = Calendar.getInstance();
			int age = today.get(Calendar.YEAR) - Integer.parseInt(year) + 1;
			mdto.setAge(age);
			
			System.out.print("성별을 입력하세요 : ");
			mdto.setGender(sc.nextLine());
			
			int result = mdao.insert(mdto);
			if(result==1) System.out.println("\n레코드 추가 성공");
			else System.out.println("\n레코드 추가 실패");
			
			
		}


	private static void select() {
		MemberDao mdao = MemberDao.getInstance();
		ArrayList<MemberDto> list = mdao.selectAll();
		System.out.println("번호\t이름\t\t전화번호\t성별\t나이\t생년월일\t포인트\t가입일");
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		for(MemberDto mdto : list) {
			System.out.printf("%d\t%s\t\t%s\t %s\t %d\t%s\t %d\t%s\n", 
					mdto.getNum(), mdto.getName(), mdto.getPhone(), mdto.getGender(),mdto.getAge(),
					mdto.getBirth(), mdto.getBpoint(), mdto.getJoindate()); 
		}
	}
	
}

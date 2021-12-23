package jdbc05;
import java.util.ArrayList;
import java.util.Scanner;
public class RentDriver {
	public static void main(String[] args) {
	while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("\n---메뉴선택---");
			System.out.print("1.데이터열람 2.데이터추가 3.데이터수정 4.데이터삭제");
			System.out.print("5.데이터검색 6.프로그램 종료.>> 메뉴선택 : ");
			String choice = sc.nextLine();
			if(choice.equals("6")) break;
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
				case"5" :
					selectAll();
					break;
					
				default : System.out.println("메뉴 선택이 잘못되었습니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

	private static void selectAll() {
		Scanner sc = new Scanner(System.in);
		RentDao rdao = RentDao.getInstance();
		ArrayList<RentDetailDto> list = rdao.selectAll();
		System.out.println("날짜\t\t번호\t회원번호\t성명\t\t대여금액\t도서번호\t도서제목");
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		for(RentDetailDto dto : list) {
			System.out.printf("%s\t%d\t%d\t\t%s\t\t%d\t\t%d\t\t%s\n", 
					dto.getRentdate(), dto.getRentnum(), dto.getMembernum(), dto.getMembername(), dto.getPrice(), dto.getBooknum(), dto.getSubject()); 
		}
	}

	private static void delete() {
		Scanner sc = new Scanner(System.in);
		RentDao rdao = RentDao.getInstance();
		RentDto rdto = null;
		
		System.out.print("삭제할 대여 번호를 입력하세요 : ");
		String input;
		while(true) {
			input = sc.nextLine();
			if(input.equals("")) System.out.println("대여 번호 입력은 필수 입니다.");
			else break;
		}
		
		int num = Integer.parseInt(input);
		rdto = rdao.getRent(num);
		if(rdto == null) {
			System.out.println("입력한 대여 번호가 존재하지 않습니다.");
			return;
		}
		
		int result = rdao.delete(num);
		if(result==1) System.out.println("\n레코드 삭제 성공");
		else System.out.println("\n레코드 삭제 실패");
	}

	private static void update() {
		Scanner sc = new Scanner(System.in);
		RentDao rdao = RentDao.getInstance();
		RentDto rdto = null;
		
		//대여번호
		System.out.print("수정할 대여 번호를 입력하세요 : ");
		String input;
		while(true) {
			input = sc.nextLine();
			if(input.equals("")) System.out.println("대여 번호 입력은 필수 입니다.");
			else break;
		}
		
		int num = Integer.parseInt(input);
		rdto = rdao.getRent(num);
		if(rdto == null) {
			System.out.println("입력한 대여 번호가 존재하지 않습니다.");
			return;
		}
		
		//대여일
		System.out.printf("수정할 날짜를 입력하세요(YYYY-MM-DD) (기존 대여일 : %s) : ", rdto.getRentdate());
		String rentdate = sc.nextLine();
		if(!rentdate.equals("")) rdto.setRentdate(rentdate);
		
		
		//도서번호
		System.out.printf("수정할 도서 번호를 입력하세요 (기존 도서 번호 : %d) : ", rdto.getBooknum());
		int booknum = 0;
		while(true) {
			input = sc.nextLine();
			if(input.equals("")) break; 
			else {
				booknum = Integer.parseInt(sc.nextLine());
				boolean state = rdao.checkBooknum(booknum);
				if (state) { rdto.setBooknum(booknum); break; }
				else System.out.print("회원이 존재하지 않습니다. 다시 입력해 주세요 : ");
				}
		}

		//회원번호
		int membernum = 0;
		System.out.printf("수정할 회원 번호를 입력하세요 (기존 회원 번호 : %d): ", rdto.getMembernum());
		while(true) {
			input = sc.nextLine();
			if(input.equals("")) break; 
			else {
				membernum = Integer.parseInt(sc.nextLine());
				boolean state = rdao.checkMembernum(membernum);
				if (state==true) { rdto.setMembernum(membernum); break; }
				else System.out.print("회원이 존재하지 않습니다. 다시 입력해 주세요 : ");
			}
		}
		
		//할인
		System.out.printf("수정할 할인금액을 입력하세요 (기존 할인 금액 : %d) : ", rdto.getDiscount());
		input = sc.nextLine();
		if(!input.equals("")) rdto.setDiscount(Integer.parseInt(input));
		
		int result = rdao.update(rdto);
		if(result==1) System.out.println("\n레코드 수정 성공");
		else System.out.println("\n레코드 수정 실패");
	}
		
	//삽입 메소드
	private static void insert() {
		Scanner sc = new Scanner(System.in);
		RentDao rdao = RentDao.getInstance();
		RentDto rdto = new RentDto();
		
		//rentdate는 오라클의 sysdate 또는 default 값을 이용 
		//테이블 생성시 제약조건으로 설정되어 있으면 굳이 하지 않아도 됨
		
		System.out.print("대여할 도서의 번호를 입력하세요 : ");
		int booknum = 0;
		while(true) {
			booknum = Integer.parseInt(sc.nextLine());
			boolean state = rdao.checkBooknum(booknum);
			if (state==true) break;
			else System.out.print("도서가 존재하지 않습니다. 다시 입력해 주세요 : ");;
		}
		rdto.setBooknum(booknum);
		
		System.out.print("회원 번호를 입력하세요 : ");
		int membernum = 0;
		while(true) {
			membernum = Integer.parseInt(sc.nextLine());
			boolean state = rdao.checkMembernum(membernum);
			if (state==true) break;
			else System.out.print("회원이 존재하지 않습니다. 다시 입력해 주세요 : ");;
		}
		rdto.setMembernum(membernum);
		
		System.out.print("할인 금액을 입력하세요 : ");
		String input = sc.nextLine();
		int discount = 0;
		if(!input.equals("")) discount = Integer.parseInt(input);
		rdto.setDiscount(discount);
		
		int result = rdao.insert(rdto);
		if(result==1) System.out.println("\n레코드 추가 성공");
		else System.out.println("\n레코드 추가 실패");
	}
	
	

	//조회 메소드
	private static void select() {
		Scanner sc = new Scanner(System.in);
		RentDao rdao = RentDao.getInstance();
		ArrayList<RentDto> list = rdao.select();
		System.out.println("날짜\t\t번호\t도서번호\t회원번호\t할인금액");
		System.out.println("---------------------------------------------------------------------------");
		for(RentDto dto : list) {
			System.out.printf("%s\t%d\t%d\t\t%d\t\t%d\n", 
					dto.getRentdate(), dto.getNum(), dto.getBooknum(), dto.getMembernum(), dto.getDiscount()); 
		}
		
	}
}

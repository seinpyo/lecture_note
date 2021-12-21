package jdbc03;

import java.util.ArrayList;
import java.util.Scanner;

public class Book_Driver {

	public static void main(String[] args) {
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("\n---메뉴선택---");
			System.out.printf("1.데이터열람 2.데이터추가 3.데이터수정 4.데이터삭제");
			System.out.println(" 5.프로그램 종료 >> 메뉴선택 : ");
			String choice = sc.nextLine();
			if(choice.equals("5")) break;
			Book_Dao bdao = new Book_Dao();
			switch(choice) {
				case"1": 
					select(sc, bdao);
					break;
				case"2": 
					insert(sc, bdao);
					break;
				case"3":
					update(sc, bdao);
					break;
				case"4": 
					delete(sc, bdao);
					break;
				default : System.out.println("메뉴 선택이 잘못되었습니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
	
	private static void delete(Scanner sc, Book_Dao bdao) {
		int num = 0;
		while(true) {
			System.out.print("삭제할 도서번호를 입력하세요(필수) : ");
			String input = sc.nextLine();
			if(input.equals("")) {
				System.out.print("도서 번호 입력은 필수 입니다.\n");
			} else {
				num = Integer.parseInt(input);
				break;
			}
		}
		int result = bdao.delete(num);
		if(result==1)System.out.println("레코드 삭제 성공");
		else System.out.println("레코드 삭제 실패");
	}

	private static void update(Scanner sc, Book_Dao bdao) {
		// 수정할 도서번호를 입력받는다 (미입력시 다시 입력 받을 수 있도록)
		int num = 0;
		while(true) {
			System.out.print("수정할 도서번호를 입력하세요(필수) : ");
			String input = sc.nextLine();
			if(input.equals("")) {
				System.out.print("도서 번호 입력은 필수 입니다.\n");
			} else {
				num = Integer.parseInt(input);
				break;
			}
		}
		// 도서번호로 도서 하나를 조회 해서 Book_Dto에 저장
		Book_Dto bdto = bdao.getBook(num);
		//getBook()메서드에 의해 null값이거나 검색된 도서 정보가 저장되어 있음 
		if(bdto==null) {
			System.out.println("검색 결과가 없습니다.");
			return;
		} 
		// null이 아닐 경우 수정할 사항을 차례로 모두 입력할 화면을 제공하고
		// 수정하지 않을 항목은 엔터만 입력 받아 지나간다
		// 수정할 사항은 저장해둔 BookDto에 업데이트
		System.out.println("검색한 도서 정보를 수정합니다.\n수정하지 않을 정보는 엔터를 입력하세요.\n");
		System.out.print("수정할 도서의 제목을 입력하세요 : ");
		String subject = sc.nextLine();
		if(!subject.equals("")) bdto.setSubject(subject); 
		//입력된 내용이 공백이 아닌 경우 수정
		
		System.out.print("수정할 도서의 출판년도를 입력하세요 : ");
		String makeyear = sc.nextLine();
		if(!makeyear.equals("")) bdto.setMakeyear(Integer.parseInt(makeyear)); 
		
		System.out.print("수정할 도서의 입고가격을 입력하세요 : ");
		String inprice = sc.nextLine();
		if(!inprice.equals("")) bdto.setInprice(Integer.parseInt(inprice)); 
		
		System.out.print("수정할 도서의 대여가격을 입력하세요 : ");
		String rentprice = sc.nextLine();
		if(!rentprice.equals("")) bdto.setRentprice(Integer.parseInt(rentprice)); 
		
		System.out.print("수정할 도서의 등급을 입력하세요 : ");
		String grade = sc.nextLine();
		if(!grade.equals("")) bdto.setGrade(grade); 
		
		//Dao에 BookDto를 보내서 해당 레코드를 수정, int타입 return 값
		int result = bdao.update(bdto);
		if(result==1)System.out.println("레코드 수정 성공");
		else System.out.println("레코드 수정 실패");
	}

	private static void select(Scanner sc, Book_Dao bdao) {
		
		System.out.println("도서번호\t출판년도\t입고가격\t출고가격\t등급\t제목");
		System.out.println("-----------------------------------------------------------------------------------");
		
		ArrayList<Book_Dto> list = bdao.select(); 
		for(Book_Dto bdto : list) { 
			System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%s\t%s\n", 
					bdto.getNum(), bdto.getMakeyear(), bdto.getInprice(),bdto.getRentprice(),bdto.getGrade(),bdto.getSubject());
		}
		System.out.println("-----------------------------------------------------------------------------------");
	}

	private static void insert(Scanner sc, Book_Dao bdao) {
		
		System.out.print("출판년도를 입력하세요.");
		int makeyear = Integer.parseInt(sc.nextLine());
		System.out.print("입고가격을 입력하세요.");
		int inprice = Integer.parseInt(sc.nextLine());
		System.out.print("출고가격을 입력하세요.");
		int rentprice = Integer.parseInt(sc.nextLine());
		System.out.print("제목을 입력하세요.");
		String subject = sc.nextLine();
		System.out.print("등급을 입력하세요.");
		String grade = sc.nextLine();
		Book_Dto bdto = new Book_Dto();
		bdto.setSubject(subject);
		bdto.setMakeyear(makeyear);
		bdto.setInprice(inprice);
		bdto.setRentprice(rentprice);
		bdto.setGrade(grade);
		int result = bdao.insert(bdto);
		if(result==1) System.out.println("insert 성공");
		else System.out.println("insert 실패");
	}
	
}



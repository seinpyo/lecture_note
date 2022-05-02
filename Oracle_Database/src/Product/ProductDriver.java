package Product;
import java.util.ArrayList;
import java.util.Scanner;

import jdbc05.RentDao;
import jdbc05.RentDto;

public class ProductDriver {

	public static void main(String[] args) {
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("\n---메뉴선택---");
			System.out.printf("1.데이터열람 2.데이터추가 3.데이터수정 4.데이터삭제");
			System.out.println("5.프로그램 종료 >> 메뉴선택 : ");
			String choice = sc.nextLine();
			if(choice.equals("5")) break;
			ProductDto bdao = new ProductDto();
			switch(choice) {
				case"1": 
					select();
					break;
				case"2": 
					insert();
					break;
				case"3":
					//update();
					break;
				case"4": 
					//delete();
					break;
				default : System.out.println("메뉴 선택이 잘못되었습니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

	private static void insert() {
		Scanner sc = new Scanner(System.in);
		ProductDao pdao = ProductDao.getInstance();
		ProductDto pdto = new ProductDto();
		
		System.out.printf("추가할 제품의 이름을 입력해 주세요 : ");
		pdto.setName(sc.nextLine());
		
		System.out.printf("추가할 제품의 생산년도를 입력해 주세요(YYYY-MM-DD) : ");
		pdto.setMakeyear(sc.nextLine());
		
		System.out.printf("추가할 제품의 매입가를 입력해주세요 : ");
		pdto.setIn_pri(Integer.parseInt(sc.nextLine()));
		
		System.out.printf("추가할 제품의 판매가를 입력해주세요 : ");
		pdto.setSell_pri(Integer.parseInt(sc.nextLine()));
		
		int result = pdao.insert(pdto);
		if(result==1) System.out.println("레코드 추가 성공");
		else System.out.println("레코드 추가 실패");
		
	}
		
	private static void select() {
		
		Scanner sc = new Scanner(System.in);
		ProductDao pdao = ProductDao.getInstance();
		ArrayList<ProductDto> list = pdao.select();
		System.out.println("제품번호\t제품명\t\t생산일자\t매입액\t판매가");
		System.out.println("---------------------------------------------------------------------------");
		for(ProductDto dto : list) {
			System.out.printf("%d\t\t%s\t\t%s\t%d\t%d\n", 
					dto.getPd_num(), dto.getName(), dto.getMakeyear(), dto.getIn_pri(), dto.getSell_pri()); 
		}
		
		
	}
}

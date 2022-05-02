package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Select {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pw = "tiger";
		Connection con = null;  
		PreparedStatement pstmt = null; // con 에 SQL 실행해주는 객체 
		ResultSet rs = null; // SQL 실행결과를 저장하는 객체
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			// System.out.println("데이터베이스에 연결 성공했습니다");
			String sql = "select * from customer";
			//데이터 베이스 연결 후에는 SQL 명령을 사용하기 위해 String 변수에
			//SQL명령을 준비한다. 데이터베이스에 제공되어질 명령이므로 String타입
			
			//SQL문을 장착한 con을 pstmt에 전달
			pstmt = con.prepareStatement(sql);
			//pstmt = con.prepareStatement("select*from customer");
			
			//pstmt에 담긴 sql 명령 실행하고 그 결과를 rs에 저장
			rs = pstmt.executeQuery();
			
			System.out.println("번호 \t 이름 \t\t 이메일 \t\t 전화번호");
			System.out.println("----------------------------------------------------------");
			
			//rs.next() : 최초실행은 객체의 시작부분(데이터 없는 곳)에서 첫번째 레코드로
			//이동하는 메서드. 그 다음 부터는 다음 레코드로 이동
			//rs. next() : 메서드가 실행될 때 다음 레코드가 있으면 true 없으면 false를 리턴
			
			while(rs.next()) {
				// 결과의 처음부터 끝까지 반복 실행 : 레코드 단위로 반복 실행
				// rs.getInt() : number형 필드값을 추출하는 메서드. 괄호 안에 필드 이름을
				// 정확히 쓸 것. 문자형 자료는 getString을 사용
				// 필드명에 오타가 있거나 안맞으면 '부적합한 열 이름'이라는 에러발생
				int num = rs.getInt("num");
				// rs.getStirng() : varchar2 형 필드값을 추출하는 메서드
				// 모든 자료형에 대해 get~() 메서드가 모두 존재함
				String name = rs.getString("name");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				System.out.printf("%d\t%s\t\t%s\t\t%s\n",num, name, email, tel);
			}

			// pstmt 에 sql 을 장착하고 실행해서, 그결과를 rs  에 저장합니다
			// 저장결과를 하나씩 레코드별로 필드별로 하나씩 꺼내서
			// 콘솔창에 출력합니다.
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace();		
		}
		try { 
			if(con != null) con.close();	
			if(pstmt != null) pstmt.close();
			if( rs != null) rs.close();
		}catch (SQLException e) { e.printStackTrace();	
		}	
	}

}

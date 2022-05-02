package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connect {

	public static void main(String[] args) {
		// url : jdbc:oracle:thin:@localhost:1521:xe
		// driver : oracle.jdbc.OracleDriver
		// id : scott
		// password : tiger
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		String id = "scott";
		String pw = "tiger";
		// JDBC 를 통해 데이터 베이스와 연결하게 해주는 클래스 : Connection
		Connection con = null;
		try {
			// 데이터베이스 연결을 위해 드라이버 클래스를 설정합니다
			Class.forName( driver );
			// 연결 url 을 목적지로  id 와 pw 를 이용하여 연결을 실제 실행합니다
			// 연결된 연결객체는  변수 con 에 저장합니다
			con = DriverManager.getConnection(url, id, pw );
			System.out.println("연결이 성공하였습니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ojdbc6.jar 파일을 확인하세요");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결정보를 확인하세요.");
		}

		try {
			if( con != null) con.close();
			System.out.println("데이터베이스 종료");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결이 종료되지 않았습니다.");
		}
	}
}

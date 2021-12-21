package jdbc04;

import java.sql.*;
import java.util.ArrayList;

public class MemberDao {
	//여러 사람들이 수많은 객체를 생성하여 사용하지 않고 
	//하나의 객체를 공유하여 사용하게 하기 위한 싱글턴 패턴
	private MemberDao() {}
	//dao를 외부에서 생성하지 못하도록 private 선언
	private static MemberDao itc = new MemberDao();
	//계속 사용할 유일한 MemberDao의 객체 itc
	public static MemberDao getInstance() { return itc; }
	//외부에서 객체를 사용하기 위한 메소드 getInstace() 
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection con = null;  
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace();
		}
		return conn; 
	}

	private void close() {
		try{
			if(con != null) con.close();	
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch (SQLException e) { e.printStackTrace();}	
	}
	
	
	public ArrayList<MemberDto> select(){
		ArrayList<MemberDto> list = new ArrayList<>();
		String sql = "SELECT * FROM MEMBERLIST ORDER BY MEMBERNUM DESC";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto mdto = new MemberDto();
				mdto.setMembernum(rs.getInt("membernum"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirth(rs.getDate("birth"));
				mdto.setBpoint(rs.getInt("bpoint"));
				mdto.setAge(rs.getInt("age"));
				mdto.setGender(rs.getString("gender"));
				mdto.setJoindate(rs.getDate("joindate"));
				list.add(mdto);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { close();
		}
		return list;
	}
	public int insert(MemberDto mdto){
		int result = 0;
		String sql = "INSERT INTO MEMBERLIST(MEMBERNUM,NAME,PHONE,GENDER,BIRTH,AGE) VALUES(MEMBER_SEQ.NEXTVAL,?,?,?,?,?)";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setString(3, mdto.getGender());
			pstmt.setDate(4, mdto.getBirth());
			pstmt.setInt(5, mdto.getAge());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { close();
		}
		return result;
	}
	public int update(MemberDto mdto){
		int result = 0;
		String sql = "UPDATE MEMBERLIST SET NAME=?, PHONE=?, GENDER=?, BPOINT=?, BIRTH=?, AGE=? WHERE MEMBERNUM = ?";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setString(3, mdto.getGender());
			pstmt.setInt(4, mdto.getBpoint());
			pstmt.setDate(5, mdto.getBirth());
			pstmt.setInt(6, mdto.getAge());
			pstmt.setInt(7, mdto.getMembernum());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {e.printStackTrace();
		} finally { close();
		}
		return result;
	}
	public MemberDto getMember(int num){
		MemberDto mdto = null;
		String sql = "SELECT * FROM MEMBERLIST WHERE MEMBERNUM = ?";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mdto = new MemberDto();
				mdto.setMembernum(rs.getInt("membernum"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirth(rs.getDate("birth"));
				mdto.setBpoint(rs.getInt("bpoint"));
				mdto.setAge(rs.getInt("age"));
				mdto.setGender(rs.getString("gender"));
				mdto.setJoindate(rs.getDate("joindate"));
			}
			
		} catch (SQLException e) {e.printStackTrace();
		} finally { close();
		}
		return mdto;
	}
	public int delete(int num){
		int result = 0;
		String sql = "";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			
		} catch (SQLException e) {e.printStackTrace();
		} finally { close();
		}
		return result;
	}
}

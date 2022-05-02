package student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import student.dto.DataBaseConnectionInfo;
import student.dto.Student;

public class StudentDao {

	String driver = null;
	String url = null;
	String id = null;
	String pw = null;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public StudentDao(DataBaseConnectionInfo dbconinfo) {
		this.driver = dbconinfo.getDriver();
		this.url = dbconinfo.getUrl();
		this.id = dbconinfo.getId();
		this.pw = dbconinfo.getPw();
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) { e.printStackTrace();
		} catch (ClassNotFoundException e) { e.printStackTrace();
		}
		return con;
	}
	
	public void close() {
		try {
			if(con!=null) con.close();
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}catch (SQLException e) { e.printStackTrace(); }
	}

	public void insertStudent(Student std) {
		String sql = "insert into student values(?,?,?,?,?,?,?)";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, std.getsNum());
			pstmt.setString(2, std.getsId());
			pstmt.setString(3, std.getsPw());
			pstmt.setString(4, std.getsName());
			pstmt.setInt(5, std.getsAge());
			pstmt.setString(6, std.getsGender());
			pstmt.setString(7, std.getsMajor());
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { close(); }
		
	}

	public ArrayList<Student> selectAllStudnet() {
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "select * from student";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Student std = new Student(
					rs.getString("snum"),
					rs.getString("sid"),
					rs.getString("spw"),
					rs.getString("sname"),
					rs.getInt("sage"),
					rs.getString("sgender"),
					rs.getString("smajor")
				); //dto 대신 생성자를 이용해 list에 정보 담기
				list.add(std);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { close(); }
		
		return list;
	}

	public Student selectOneStudent(String sId) {
		Student std = null;
		String sql = "select * from student where sid = ?";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				std = new Student(
					rs.getString("sNum"),
					rs.getString("sId"),
					rs.getString("sPw"),
					rs.getString("sName"),
					rs.getInt("sAge"),
					rs.getString("sGender"),
					rs.getString("sMajor")
				);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { close(); }
		
		
		return std;
	}

	public void updateStudent(Student std) {
		String sql = "update student set sPw=?, sName=?, sAge=?, sGender=?"
				+ ", sMajor=? where sId=?";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, std.getsPw());
			pstmt.setString(2, std.getsName());
			pstmt.setInt(3, std.getsAge());
			pstmt.setString(4, std.getsGender());
			pstmt.setString(5, std.getsMajor());
			pstmt.setString(6, std.getsId());
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { close(); }
	}

}

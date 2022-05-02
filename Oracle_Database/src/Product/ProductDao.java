package Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc05.DBManager;


public class ProductDao {

	private ProductDao() {}
	private static ProductDao itc = new ProductDao();
	public static ProductDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<ProductDto> select(){
		ArrayList<ProductDto> list = new ArrayList<>();
		con = PD_DBManager.getConnection();
		String sql = "SELECT PD_NUM, NAME, TO_CHAR(MAKEYEAR,'YYYY-MM-DD') AS MAKEYEAR, IN_PRI, SELL_PRI FROM PRODUCT_LIST";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDto pdto = new ProductDto();
				pdto.setPd_num(rs.getInt("pd_num"));
				pdto.setName(rs.getString("name"));
				pdto.setMakeyear(rs.getString("makeyear"));
				pdto.setIn_pri(rs.getInt("in_pri"));
				pdto.setSell_pri(rs.getInt("sell_pri"));
				list.add(pdto);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { PD_DBManager.close(con, pstmt, rs);		
		}
		
		return list; 
	}
	
	public int insert(ProductDto pdto){
		int result = 0;
		con = PD_DBManager.getConnection();
		String sql = "INSERT INTO PRODUCT_LIST VALUES(PD_SEQ.NEXTVAL,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pdto.getName());
			pstmt.setString(2, pdto.getMakeyear());
			pstmt.setInt(3, pdto.getIn_pri());
			pstmt.setInt(4, pdto.getSell_pri());
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally {	DBManager.close( con, pstmt, rs ); }
		return result;
	}
	
	public int update(ProductDao pdto){
		int result = 0;
		con = PD_DBManager.getConnection();
		String sql = "";
		
		return result;
	}
	
	public int delete(int num){
		int result = 0;
		con = PD_DBManager.getConnection();
		String sql = "";
		
		return result;
	}

	public ProductDto getProduct(int num){
		ProductDto pdto = null;
		con = PD_DBManager.getConnection();
		String sql = "";
		
		return pdto;		
	}
	
	
}

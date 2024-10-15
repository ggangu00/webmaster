package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs;
	Notice nt = new Notice();
	String sql = "";
	
	// 1. 연결설정 메소드 (void)
	public void getOpen() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.8:1521:xe",
					"java",
					"1234"
					);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getClose() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//공지리스트
	List<Notice> noticeList(){
		sql = "select * from notice order by reg_date desc";
		
		List<Notice> result = new ArrayList<>();
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); //조회
			while(rs.next()) {
				nt.setCode(rs.getString("code"));
				nt.setTitle(rs.getString("title"));
				nt.setReg_date(rs.getString("reg_date"));
				
				result.add(nt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//공지등록
	public int noticeInsert(Notice notice){
		getOpen();
		//데이터 추가
		try {
			String sql = ""
					   + "insert into notice (code, title, reg_date) "
					   + "values(?, ?, sysdate)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getCode());
			pstmt.setString(2, notice.getTitle());
			
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//상품변경
	public int noticeUpdate(Product product){
		getOpen();
		//데이터 추가
		try {
			String sql = ""
					   + "update notice "
					   + "title=?"
					   + "where code=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nt.getTitle());
			pstmt.setString(2, nt.getCode());
			
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	//상품삭제
	public int noticeDelete(String code){
		getOpen();
		//데이터 추가
		try {
			String sql = ""
					   + "delete from notice "
					   + "where code=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
		
}

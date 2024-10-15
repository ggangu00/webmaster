package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateMain {

	public static void main(String[] args) {
		// 연결하기
		Connection conn = null;
		
		//jdbc 등록
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:Oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			System.out.println("연결성공");
			
			//데이터 수정
			String sql = "" +
					   "update boards " +
					   "set btitle = ?, bcontent = ? "+
					   "where bno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno", "btitle", "bcontent"});
			pstmt.setString(1, "고질라");
			pstmt.setString(2, "못생겼다");
			pstmt.setInt(3, 4);
			
			//sql문장 실행
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 갯수 : "+ rows);
			
			if(rows >= 1) {				
				ResultSet rs = pstmt.getGeneratedKeys(); //ResultSet = DB에서 실행된 결과를 담아오는 애
				if(rs.next()) {
					String title = rs.getString(2);
					String content = rs.getString(3);
					System.out.println("변경된 내역 : "+ title + ", " + content);
				}
				System.out.println("수정 성공");
				rs.close();
			}else {
				System.out.println("수정 실패");
			}
			
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결끊기");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
	}

}

package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertMain {

	public static void main(String[] args) {
		//데이터 추가
		Connection conn = null;
		
		//jdbc 드라이버 등록
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:Oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			
			System.out.println("연결성공");
			
			//데이터 추가
			String sql = ""
					   + "insert into boards (bno, btitle, bcontent, bwriter, bdate) "
					   + "values(seq_bno.nextVal, ?, ?, ?, sysdate)";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno", "btitle"});
			pstmt.setString(1, "눈오는 밤");
			pstmt.setString(2, "비오는 밤");
			pstmt.setString(3, "똥꾸멍");
			
			//sql문장 실행
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys(); //ResultSet = DB에서 실행된 결과를 담아오는 애
				if(rs.next()) {
					int bno = rs.getInt(1);
					String title = rs.getString(2);
					System.out.println("저장된 번호 : "+ bno + title);
				}
				System.out.println("추가 성공");
				rs.close();
			}else {
				System.out.println("추가 실패");
			}
			
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) { //연결값이 null이 아닐 때 = 연결되어있을 때
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

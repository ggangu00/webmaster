package 도서관리;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//목록(조회조건), 등록, 수정, 삭제, 단건
public class MemberDao extends DAO{
	//Connection, getCon, getClose
	
	//싱글턴 방식
	private static MemberDao instance = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {
		return instance;
	}
	
	//아이디와 비밀번호 확인해서 true/false 반환 -> 회원 이름 반환 -> 권한 추가
	/*
	String CheckMember(String id, String pw) {
		String sql = "select member_name, responsibility from tbl_member"
				   + " where member_id=? and password=?";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return rs.getString("member_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}*/
	
	Member CheckMember(String id, String pw) { //리턴 값을 여러개 담기 위해 String -> Member
		String sql = "select member_name, responsibility from tbl_member"
				   + " where member_id=? and password=?";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Member member = new Member();
				member.setMemberName(rs.getString("member_name"));
				member.setResponsibility(rs.getString("responsibility"));
				return member;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	//목록조회
	List<Member> memberList(){
		String sql = "select member_id"
				   + "     ,member_name"
				   + "     ,password"
				   + "     ,phone"
				   + "     ,responsibility"
				   + "     ,creation_date "
				   + "from tbl_member";
		List<Member> result = new ArrayList<>();
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); //조회
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setPassword(rs.getString("password"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				member.setCreationDate(rs.getDate("creation_date"));
				
				result.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	} //end of memberList()
	
	public int insert(Member member){
		getOpen();
		//데이터 추가
		try {
			String sql = ""
					   + "insert into book (member_id, password, member_name, phone, responsibility, creation_date) "
					   + "values(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getResponsibility());
			//pstmt.setString(6, Date());
			
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void select(String title){
		getOpen();
		//데이터 추가
		try {
			String sql = ""
					   + "select * from book "
					   + "where title=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " : " + rs.getString(2) + " : " + rs.getInt(3) + " : " + rs.getString(4));
			}	
			
			getClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	List<Book> bookList(Search search){
		String sql = "select * from book" + " where price<>0";
		if(search.getTitle() != null) {
			sql += " and title like '%'||?||'%'";
		}
		if(search.getWriter() != null) {
			sql += " and writer like '%'||?||'%'";
		}
		if(search.getPrice() > 0) {
			sql += " and price > ?";
		}
		int param =0;
		List<Book> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			if(search.getTitle() != null || !search.getTitle().equals("")) {
				psmt.setString(param++, search.getTitle());
			}
			if(search.getTitle() != null || !search.getWriter().equals("")) {
				psmt.setString(param++, search.getWriter());
			}
			if(search.getPrice() > 0) {
				psmt.setInt(param++, search.getPrice());
			}
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				Book book = new Book(rs.getString("title"), rs.getString("writer"), rs.getInt("price"), rs.getString("bnum"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void list(){
		getOpen();
		//데이터 추가
		try {
			String sql = "select * from book ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " : " + rs.getString(2) + " : " + rs.getInt(3) + " : " + rs.getString(4));
			}	
			getClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int update(String bnum, String title, int price){
		getOpen();
		//데이터 추가
		try {
			String sql = ""
					   + "update book set price=?, bnum=? "
					   + "where bnum=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bnum);
			pstmt.setInt(2, price);			
			pstmt.setString(3, bnum);
			
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int delete(String title){
		getOpen();
		//데이터 추가
		try {
			String sql = "delete from book "
					   + "where title=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}

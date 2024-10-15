package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs;
	Product product = new Product();
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
	
	
	//상품목록
	List<Product> productList(){
		sql = "select * from product";
		
		List<Product> result = new ArrayList<>();
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); //조회
			while(rs.next()) {
				product.setCode(rs.getString("code"));
				product.setCate(rs.getString("cate"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setCnt(rs.getString("cnt"));
				product.setAvg(productRating(rs.getString("code")));
				
				result.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int productRating(String code) {
		sql = "select code, round(avg(point)) avg "
		    + "from review "
		    + "where code=? "
		    + "group by code";
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				return rs.getInt("avg");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
	}
	
	
	//상품 상세보기
	public void productDetail(String code) {
		sql = "select * from product "
			+ "where code=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			System.out.println("상품명 : " + rs.getString("name"));
			System.out.println("상품코드 : " + rs.getString("code"));
			System.out.println("상품가격 : " + rs.getString("price"));
			
			productReview(code);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void productSearch(String code) {
		sql = "select * from product "
				+ "where code=?";
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				
				System.out.printf("[%s] %s (%s)", rs.getString("cate"), rs.getString("name"), rs.getString("cnt"));
				System.out.println();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//상품리뷰
	public void productReview(String code) {
		sql = "select *"
			+ "from review "
			+ "where code=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("번호\t|\t\t리뷰내용\t\t|\t별점\t|");
			System.out.println("---------------------------------------------------------------------------------------------");
						
			int i=0;
			while(rs.next()) {
				i++;
				System.out.print(i+"\t"+rs.getString("memo")+"\t");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//상품등록
	public int productInsert(Product product){
		getOpen();
		//데이터 추가
		try {
			String sql = ""
					   + "insert into product (code, cate, name, price, cnt) "
					   + "values(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getCode());
			pstmt.setString(2, product.getCate());
			pstmt.setString(3, product.getName());
			pstmt.setInt(4, product.getPrice());
			pstmt.setString(5, product.getCnt());
			
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//상품변경
	public int productUpdate(Product product){
		getOpen();
		//데이터 추가
		try {
			String sql = ""
					   + "update product "
					   + "cate=?, name=?, price=?, cnt=? "
					   + "where code=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getCate());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getCnt());
			pstmt.setString(5, product.getCode());
			
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	//상품삭제
	public int productDelete(String code){
		getOpen();
		//데이터 추가
		try {
			String sql = ""
					   + "delete from product "
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
	
	//상품매출현황	
	public void productStats(String order){
		sql = "select cate, sum(cnt) tCnt, "
		    + "(select sum(cnt) from cart where cate=a.cate and buy_date>=TO_CHAR(TRUNC(SYSDATE,'MM'),'YYYYMMDD')) mCnt, "
			+ "(select sum(cnt) from cart where cate=a.cate and buy_date>=TO_CHAR(TRUNC(SYSDATE,'IW'),'YYYYMMDD')) wCnt "
			+ "from cart a "
			+ "group by cate ";
		
		if(order.equals("1")) {
			sql += "order by tCnt desc";
		}else if(order.equals("2")) {
			sql += "order by mCnt desc";
		}else if(order.equals("3")) {
			sql += "order by wCnt desc";
		}
		
		
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); //조회
			int i=0;
			while(rs.next()) {
				i++;
				System.out.println(i+"\t|"+rs.getString("cate")+"\t|"+rs.getString("tCnt")+"\t\t|"+rs.getString("mCnt")+"\t\t|"+rs.getString("wCnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
}

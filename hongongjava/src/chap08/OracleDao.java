package chap08;

public class OracleDao implements DataAccessObject{
	@Override
	public void select() {
		System.out.println("Oracle에서 DB검색");
	}
	
	@Override
	public void insert() {
		System.out.println("Oracle에서 DB삽입");
	}
	
	@Override
	public void update() {
		System.out.println("Oracle에서 DB수정");
	}
	
	@Override
	public void delete() {
		System.out.println("Oracle에서 DB삭제");
	}
}

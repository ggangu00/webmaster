package chap08;

public class MysqlDao implements DataAccessObject{
	@Override
	public void select() {
		System.out.println("Mysql에서 DB검색");
	}
	
	@Override
	public void insert() {
		System.out.println("Mysql에서 DB삽입");
	}
	
	@Override
	public void update() {
		System.out.println("Mysql에서 DB수정");
	}
	
	@Override
	public void delete() {
		System.out.println("Mysql에서 DB삭제");
	}
}

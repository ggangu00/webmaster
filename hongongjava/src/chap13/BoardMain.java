package chap13;

import java.util.List;
import java.util.Vector;

public class BoardMain {

	public static void main(String[] args) {
		//Vector : 멀티 스레드 환경에 안전
		List<Board> list = new Vector<Board>();
		
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		list.remove(2);//2번 인덱스 객체(제목3) 삭제
		list.remove(3);//3번 인덱스 객체(제목5) 삭제
		
		for(Board bd : list) {
			System.out.println(bd.subject + "\t" + bd.content + "\t" + bd.writer);
		}
		
		//해시코드
		Board bd = new Board("제목", "내용", "글쓴이");
		System.out.println(bd);
		System.out.println(bd.hashCode());
		System.out.println(bd.toString()); //객체의 주소값과 동일
		
	}

}

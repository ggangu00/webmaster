package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MemberMain {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("홍길동",30));
		set.add(new Member("홍길동",30));
		set.add(new Member("최길동",25));
		set.add(new Member("최길동",30));
		System.out.println("총 객체 수 : "+set.size());
		
		
		Iterator<Member> iterator = set.iterator();
		while(iterator.hasNext()) {
			Member element = iterator.next();
			System.out.println("이름 : "+element.name+", 나이 : "+element.age);
		}
		
		iterator = set.iterator();
		for(Member element : set) {
			System.out.println("이름 : "+element.name+", 나이 : "+element.age);
		}
		
	}
}

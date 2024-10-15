package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam {

	public static void main(String[] args) {
		Set<Student2> set = new HashSet<Student2>();
		
		set.add(new Student2(1, "홍길동"));
		set.add(new Student2(2, "신용권"));
		set.add(new Student2(1, "조민우"));
		
		Iterator<Student2> iterator = set.iterator();
		while(iterator.hasNext()) {
			Student2 student = iterator.next();
			System.out.println(student.studentNum + ":" + student.name);
		}
		

	}

}

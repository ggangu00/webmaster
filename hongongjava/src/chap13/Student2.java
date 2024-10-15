package chap13;

public class Student2 {
	public int studentNum;
	public String name;
	
	public Student2 (int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return studentNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student2) {
			Student2 student = (Student2)obj;
			return student.name.equals(name) && (student.studentNum == studentNum);
		}else {
			return false;
		}
	}
}

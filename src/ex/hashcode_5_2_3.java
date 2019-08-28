package ex;

import programme.Student;

public class hashcode_5_2_3 {
	public static void main(String[] args) {
		Student a=new Student("Sam", "cs");
		Student b=new Student("Jack", "jk");
		Student c=new Student("Sam", "cs");
		
		System.out.println(a.hashCode()==b.hashCode());
		System.out.println(a.equals(b));
		System.out.println(a.hashCode()==c.hashCode());
		System.out.println(a.equals(c));
	}
}

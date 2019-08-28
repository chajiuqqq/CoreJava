package programme;

import java.util.Objects;

public class Student extends Person{
	private String major="";
	public Student(String aname,String amajor) {
		// TODO Auto-generated constructor stub
		super(aname);
		this.major=amajor;
	}
	@Override
	public void printDescribe() {
		// TODO Auto-generated method stub
		System.out.println(super.getName()+" is major in "+this.major);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(this.getClass()!=obj.getClass())
			return false;
		
		Student other=(Student)obj;
		return this.getName().equals(other.getName())
				&&this.major.equals(other.major);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(this.getName(),major);
	}
	@Override
	protected Object clone() {
		// TODO Auto-generated method stub
		return null;
	}
}

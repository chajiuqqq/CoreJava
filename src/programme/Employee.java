package programme;

import java.time.LocalDate;
import java.util.Objects;

import javax.print.attribute.standard.MediaSize.Other;
/**
 * 
 * @author Administrator
 * @version 2019/7/8
 *
 */
public class Employee extends Person implements Comparable<Employee>,Cloneable{
	private double salary=0.0;
	private LocalDate hireDate;
	public Employee() {
		super("");
	}
	public Employee(String name) {
		super(name);
	}
	
	public Employee(String aname,double asalary) {
		super(aname);
		this.salary=asalary;
	}
	
	public Employee(String aname,double asalary,int year,int month,int day) {
		super(aname);
		salary=asalary;
		hireDate=LocalDate.of(year, month, day);
	}
	public double getSalary() {
		return salary;
	}
	public String getHiredate() {
		return hireDate.toString();
	}
	public void raiseSalary(double percent) {
		double raiseAmount=salary*percent/100;
		salary+=raiseAmount;
	}
	public Employee newEmployee() {
		return new Employee();
	}
	@Override
	public void printDescribe() {
		// TODO Auto-generated method stub
		System.out.println(super.getName()+"'s salary is "+this.getSalary());
	}
	/**
	 * 重写object的equals方法的模板
	 */
	@Override
	public boolean equals(Object obj) {
		//判断对象地址是否一样
		if(this==obj)
			return true;
		//判断obj是否指向null
		if(obj==null)
			return false;
		//判断是不是同一个类的，不是就直接返回false
		if(getClass()!=this.getClass())
			return false;
		
		//现在我们知道了obj是Employee类的对象，向下转型后进一步比较细节
		Employee other=(Employee)obj;
		//不能这么写，对对象的比较都不能用equals，要用Object.equals()
		//return this.getName().equals(other.getName())
		//&&salary==other.salary&&this.hireDate.equals(other.hireDate);
		
		
		//基本类型直接用==判断，引用类型交给Objects的静态方法equals()判断，是null安全
		//Objects类	jdk1.7后出现.提供静态方法操作对象.
		return Objects.equals(getName(), other.getName())
				&&salary==other.salary
				&&Objects.equals(hireDate, other.hireDate);
	}
	
	@Override
	public int hashCode() {
		// 引用类型获得hashcode使用Objects的静态方法hashCode
		// 基本类型使用对应包装器类的hashCode方法获得hashcode
		return 10*Objects.hashCode(getName())+
				11*Double.hashCode(salary)+
				12*Objects.hashCode(hireDate);
	}
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return Double.compare(this.salary,o.salary);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName()+" "+this.salary;
	}

	//为什么这里public也可以？因为原来的是protected，只要范围比原来的大就行了
	//Employee 这里是协变返回类型，是object的子类，所以可以写成Employee 
	
	public Employee clone() throws CloneNotSupportedException{
		// TODO Auto-generated method stub
		return (Employee)super.clone();
	}
	

	

}

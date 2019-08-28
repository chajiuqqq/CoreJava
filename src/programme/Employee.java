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
	 * ��дobject��equals������ģ��
	 */
	@Override
	public boolean equals(Object obj) {
		//�ж϶����ַ�Ƿ�һ��
		if(this==obj)
			return true;
		//�ж�obj�Ƿ�ָ��null
		if(obj==null)
			return false;
		//�ж��ǲ���ͬһ����ģ����Ǿ�ֱ�ӷ���false
		if(getClass()!=this.getClass())
			return false;
		
		//��������֪����obj��Employee��Ķ�������ת�ͺ��һ���Ƚ�ϸ��
		Employee other=(Employee)obj;
		//������ôд���Զ���ıȽ϶�������equals��Ҫ��Object.equals()
		//return this.getName().equals(other.getName())
		//&&salary==other.salary&&this.hireDate.equals(other.hireDate);
		
		
		//��������ֱ����==�жϣ��������ͽ���Objects�ľ�̬����equals()�жϣ���null��ȫ
		//Objects��	jdk1.7�����.�ṩ��̬������������.
		return Objects.equals(getName(), other.getName())
				&&salary==other.salary
				&&Objects.equals(hireDate, other.hireDate);
	}
	
	@Override
	public int hashCode() {
		// �������ͻ��hashcodeʹ��Objects�ľ�̬����hashCode
		// ��������ʹ�ö�Ӧ��װ�����hashCode�������hashcode
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

	//Ϊʲô����publicҲ���ԣ���Ϊԭ������protected��ֻҪ��Χ��ԭ���Ĵ������
	//Employee ������Э�䷵�����ͣ���object�����࣬���Կ���д��Employee 
	
	public Employee clone() throws CloneNotSupportedException{
		// TODO Auto-generated method stub
		return (Employee)super.clone();
	}
	

	

}

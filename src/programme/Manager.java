package programme;
/**
 * 
 * @author Administrator
 * @version 2019/7/8
 */
public class Manager extends Employee{
	/**
	 * manager's bonus
	 */
	private double bonus;
	public Manager() {
		
	}
	public Manager(String name) {
		super(name);
	}
	
	/**
	 * Constructor:ֱ�������˳���Ĺ�����
	 * @param aname		the employee's name
	 * @param asalary 	his salary
	 * @param year		the year of hireDate
	 * @param month		the month of hireDate
	 * @param day		the day of hireDate
	 */
	public Manager(String aname,double asalary,int year,int month,int day) {
		super(aname, asalary, year, month, day);
	}
	
	@Override
	public double getSalary() {
		return super.getSalary()+bonus;
	}
	
	public void setBonus(double b) {
		bonus=b;
	}
	//������Ҫ����ֵ����������������һ������ͬ������ֻ�з�����һ��
	//���า�ǵķ�������ֵ������ԭ����ֵ��������
	@Override
	public Manager newEmployee() {
		return new Manager();
	}
}


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
	 * Constructor:直接重用了超类的构造器
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
	//覆盖需要返回值，方法名，参数都一样，不同于重载只有方法名一致
	//子类覆盖的方法返回值可以是原返回值的子类型
	@Override
	public Manager newEmployee() {
		return new Manager();
	}
}


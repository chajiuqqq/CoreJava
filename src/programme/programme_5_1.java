package programme;

import ex.math_3_5_1;

/**
 * @version 1.0 2019/7/8
 * @author Administrator
 * @see Employee
 * @see Manager
 */
public class programme_5_1 {
	public static void main(String[] args) {
		Manager aManager=new Manager("Sam", 5000, 1998, 10, 1);
		aManager.setBonus(3000);
		
		Employee[] listEmployees=new Employee[3];
		
		listEmployees[0]=aManager;
		listEmployees[1]=new Manager("Tang", 3000, 1999, 1, 1);
		listEmployees[2]=new Manager("Tom", 3500, 2000, 5, 2);
		
		listEmployees[1].raiseSalary(15.5);
		
		for(Employee x:listEmployees) {
			System.out.println("Name: "+x.getName()+" Salary: "+x.getSalary()+" HireDate: "+x.getHiredate());
		}
		
		//发生错误
		//Manager[] aManagers=new Manager[5];
		//Employee[] aEmployees= aManagers;
		//aEmployees[0]=new Employee();
		//	aManagers[0] 指向的是employee对象，没有setBonus()方法 
		//aManagers[0].setBonus(10);
		
		//instanceof 用来检查前一个是否是后一个类的实例
		Employee aEmployee=new Employee();
		String aString="";
		if(aEmployee instanceof Manager) {
			Manager bManager=(Manager)aEmployee;
		}
		System.out.println("ok");
	}
}

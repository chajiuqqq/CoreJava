package ex;

import programme.Employee;
import programme.Manager;
/**
 * 向上转型和向下转型测试
 * @author Alice
 *
 */
public class Super_this_test {

	public static void main(String[] args) {
		try {
			//子类变量不能指向超类对象
			//超类对象不能强制转换成子类对象，但是超类的变量可以转为子类的变量
			Manager aManager=(Manager)new Employee();//error
			Employee a=new Manager();
			Manager b=(Manager)a;//ok
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			System.out.println("no problem");
		}
	}
}

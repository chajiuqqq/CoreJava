package ex;

import programme.Employee;
import programme.Manager;
/**
 * ����ת�ͺ�����ת�Ͳ���
 * @author Alice
 *
 */
public class Super_this_test {

	public static void main(String[] args) {
		try {
			//�����������ָ�������
			//���������ǿ��ת����������󣬵��ǳ���ı�������תΪ����ı���
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

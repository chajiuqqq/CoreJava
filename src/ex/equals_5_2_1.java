package ex;

import java.util.Objects;

import programme.Employee;

public class equals_5_2_1 {
	public static void main(String[] args) {
		Employee a=new Employee("Sam",5000,2000,10,1);
		Employee b=a;
		Employee c=new Employee("Sam",5000,2000,10,1);
		System.out.println(a.equals(b));
		//���õĶ���ͬ�����Ƕ����״̬��ͬ����Object.equals()����,Employee��equals��������д
		System.out.println("a==c? "+a.equals(c));
		
		//hashcode
		System.out.println("hashcode a==b? ");
		System.out.println(a.hashCode()==b.hashCode());
		System.out.println("hashcode a==c? ");
		System.out.println(a.hashCode()==c.hashCode());
		
	}
}

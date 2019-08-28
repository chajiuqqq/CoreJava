package ex;

import programme.Employee;
import programme.Manager;
/**
 * ͨ������ԣ��ڰ�ĳ���Ͷ�������������������ʱ������ͨ��ͨ�������Ϊ���������ĸ��࣬��������Ҫ��Ĳ������Ͷ����Ե�������������൱�ڸ����βΣ�
 * ��main���붨�巺�������Ͳ����ĸ���ʱ��Ҳ����ʹ��ͨ��� Pair<? extends Employee> a ���������Ϳ���ָ������Employee��������Ķ���
 * @author Alice
 * @version 2019��7��22��
 */
public class wildcard_8_8 {
	//static class Pair<T extends Employee>{  Ҳ������ôд
	static class Pair<T>{
		T first=null;
		T second=null;
		
		public Pair(T first,T second) {
			// TODO Auto-generated constructor stub
			this.first=first;
			this.second=second;
		}
		
		public void setFirst(T f) {
			this.first=f;
		}
		
		public T getFirst() {
			return first;
		}
		public T getSecond() {
			return second;
		}
	}
	/**
	 * ʹ����ͨ�����Pair<? extends Employee>
	 * @param op
	 */
	public static void printPair(Pair<? extends Employee> op) {
		Employee a=op.getFirst();
		Employee b=op.getSecond();
		System.out.println("First: "+a);
		System.out.println("Second: "+b);
	}
	
	public static void main(String[] args) {
		Pair<Manager> managers=new Pair<Manager>(new Manager("ceo"), new Manager("cfo"));
		//���extends Employee�൱������Ϊ��ͨ�����Լ����˵���ķ��ͱ�������ָ��Employee��������
		Pair<? extends Employee> Buddies=managers;
		//error: Buddies.setFirst(new Manager());
		//ok: managers.setFirst(new Manager());
		printPair(managers);
	}
}

package ex;

import programme.Employee;
import programme.Manager;
/**
 * 通配符测试：在把某泛型对象当做参数传进方法里时，可以通过通配符设置为这个泛型类的父类，这样符合要求的参数类型都可以调用这个方法（相当于父类形参）
 * 在main里想定义泛型类类型参数的父类时，也可以使用通配符 Pair<? extends Employee> a 这样声明就可以指向所有Employee及其子类的对象
 * @author Alice
 * @version 2019年7月22日
 */
public class wildcard_8_8 {
	//static class Pair<T extends Employee>{  也可以这么写
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
	 * 使用了通配符：Pair<? extends Employee>
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
		//这个extends Employee相当于是人为对通配符的约束，说明改泛型变量可以指向Employee及其子类
		Pair<? extends Employee> Buddies=managers;
		//error: Buddies.setFirst(new Manager());
		//ok: managers.setFirst(new Manager());
		printPair(managers);
	}
}

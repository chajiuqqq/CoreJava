package ex;

import programme.Manager;
import programme.Pair;
/**
 * 8.7 泛型类型的继承规则
 * @author Alice
 * @version 2019年7月23日
 */
public class ParamteriezdType_8_7{
	public static void main(String[] args) {
		
		Pair<Manager> a=new Pair<>(new Manager("ceo"),new Manager("cfo"));
		//所有参数化类型都可以转为一个原始类型
		Pair b=a;
		//返回对象时需要手动添加强制转换，将object转为你的参数类型
		Manager c=(Manager)b.getFirst();
		//如果两边都是参数化类型，返回对象时编译器会自动添加强制转换
		Manager d=a.getFirst();
		
	}
}
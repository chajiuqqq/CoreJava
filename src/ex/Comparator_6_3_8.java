package ex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

import programme.Employee;
/**
 * Comparator的comparing方法可以直接返回一个比较器，用于Arrays.sort()
 * 重载的comparing可以接受一个键返回方法，或者再添加一个对键的比较器
 * 方法的引用：：关键字，用于访问类中的各种方法，但是需要一个functional interface接口来接受该方法，不然报错
 * 
 * Comparing方法的头部为：
 * public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor)
            
   &&
   
   public static <T, U> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor,
            Comparator<? super U> keyComparator)
 * @author Alice
 * @version 2019年7月24日
 */
public class Comparator_6_3_8 {
	public static void main(String[] args) {
		Employee[] employees={new Employee("Jack",10000),new Employee("Alice",15000)};
		/**
		 * 按照Employee的名字字典顺序排
		 */
		Arrays.sort(employees, Comparator.comparing(Employee::getName));
		System.out.println(Arrays.toString(employees));
		/**
		 * 按照Employee的名字长度排（从低到高）
		 */
		Arrays.sort(employees, Comparator.comparing(Employee::getName,(s,t)->s.length()-t.length()));
		System.out.println(Arrays.toString(employees));
		/**
		 * 按照Employee的薪水排（从低到高）
		 */
		Arrays.sort(employees, Comparator.comparing(Employee::getSalary));
		System.out.println(Arrays.toString(employees));
	}
}

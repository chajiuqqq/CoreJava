package ex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

import programme.Employee;
/**
 * Comparator��comparing��������ֱ�ӷ���һ���Ƚ���������Arrays.sort()
 * ���ص�comparing���Խ���һ�������ط��������������һ���Լ��ıȽ���
 * ���������ã����ؼ��֣����ڷ������еĸ��ַ�����������Ҫһ��functional interface�ӿ������ܸ÷�������Ȼ����
 * 
 * Comparing������ͷ��Ϊ��
 * public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor)
            
   &&
   
   public static <T, U> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor,
            Comparator<? super U> keyComparator)
 * @author Alice
 * @version 2019��7��24��
 */
public class Comparator_6_3_8 {
	public static void main(String[] args) {
		Employee[] employees={new Employee("Jack",10000),new Employee("Alice",15000)};
		/**
		 * ����Employee�������ֵ�˳����
		 */
		Arrays.sort(employees, Comparator.comparing(Employee::getName));
		System.out.println(Arrays.toString(employees));
		/**
		 * ����Employee�����ֳ����ţ��ӵ͵��ߣ�
		 */
		Arrays.sort(employees, Comparator.comparing(Employee::getName,(s,t)->s.length()-t.length()));
		System.out.println(Arrays.toString(employees));
		/**
		 * ����Employee��нˮ�ţ��ӵ͵��ߣ�
		 */
		Arrays.sort(employees, Comparator.comparing(Employee::getSalary));
		System.out.println(Arrays.toString(employees));
	}
}

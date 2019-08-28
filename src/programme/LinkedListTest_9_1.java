package programme;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
/**
 * 练习ListIterator对LinkedList的插入删除方法
 * 
 * @author Alice
 * @version 2019年7月23日
 */
public class LinkedListTest_9_1 {
	public static void main(String[] args) {
		List<String> a=new LinkedList<>();
		a.add("one");
		a.add("two");
		a.add("three");
		
		List<String> b=new LinkedList<>();
		b.add("One");
		b.add("Two");
		b.add("Three");
		
		ListIterator<String> aIter=a.listIterator();
		Iterator<String> bIter=b.iterator();
		
		
		/**
		 * 归并两个LinkedList
		 * 将a和b合并到a里，一个插一个
		 */
		while(bIter.hasNext()){
			if(aIter.hasNext()){
				aIter.next();
			}
			aIter.add(bIter.next());
		}
		System.out.println(a);
		
		
		/**
		 * 对a每隔一个删除一个元素
		 */
		//重定位
		aIter=a.listIterator();
		
		while(aIter.hasNext()){
			aIter.next();
			if(aIter.hasNext()){
				aIter.next();
				aIter.remove();
			}
		}
		System.out.println(a);
		
		
		
	}
}

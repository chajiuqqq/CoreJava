package programme;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
/**
 * ��ϰListIterator��LinkedList�Ĳ���ɾ������
 * 
 * @author Alice
 * @version 2019��7��23��
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
		 * �鲢����LinkedList
		 * ��a��b�ϲ���a�һ����һ��
		 */
		while(bIter.hasNext()){
			if(aIter.hasNext()){
				aIter.next();
			}
			aIter.add(bIter.next());
		}
		System.out.println(a);
		
		
		/**
		 * ��aÿ��һ��ɾ��һ��Ԫ��
		 */
		//�ض�λ
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

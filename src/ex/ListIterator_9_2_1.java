package ex;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIterator_9_2_1 {

	public static void main(String[] args) {
		
		LinkedList<String> names=new LinkedList<>();
		names.add("Tom");
		names.add("Jack");
		names.add("Alice");
		
		ListIterator<String> iterator=names.listIterator();
		iterator.next();
		iterator.next();
		iterator.add("Opppppppp");//add��iterator�͵�opppppp����ȥ��
		System.out.println("add Opppppppp: "+names.toString());
		
		iterator.previous();
		iterator.remove();//������ǰһ����ɾ��ɾ����opppppp
		System.out.println("remove previous: "+names.toString());
		
		iterator.previous();
		iterator.remove();//����ǰһ��ɾ��Jack
		System.out.println("remove previous: "+names.toString());
		
	}
}

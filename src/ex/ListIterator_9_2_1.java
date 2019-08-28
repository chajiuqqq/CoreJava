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
		iterator.add("Opppppppp");//add后，iterator就到opppppp后面去了
		System.out.println("add Opppppppp: "+names.toString());
		
		iterator.previous();
		iterator.remove();//所以向前一个再删除删的是opppppp
		System.out.println("remove previous: "+names.toString());
		
		iterator.previous();
		iterator.remove();//再向前一个删除Jack
		System.out.println("remove previous: "+names.toString());
		
	}
}

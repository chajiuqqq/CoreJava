package programme;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
/**
 * TreeSet������ļ��ϣ��Ǿ���Ҫ��Ʒ���Ԫ�صıȽϷ����������Ҫʵ��Comparable�ӿ�
 * 
 * ��������equals���ͱ���Ҫ�����hashcode����Ϊ��ȵĶ���hashcodeҲ��ͬ
 * @author Alice
 * @version 2019��7��24��
 */
public class TreeSetTest {
	public static void main(String[] args) {
		/**
		 * Ĭ���Ȱ���id����
		 */
		SortedSet<Item> parts=new TreeSet<>();
		parts.add(new Item("Apple", 15));
		parts.add(new Item("Gun", 11));
		parts.add(new Item("Desktop", 32));
		System.out.println(parts);
		/**
		 * ���ð���description����
		 */
		NavigableSet<Item> sortByDescription=new TreeSet<>(Comparator.comparing(Item::getDescription));
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
	}
}

class Item implements Comparable<Item>{
	private String description;
	private int id;
	/**
	 * Construct an item
	 * @param description
	 * @param id
	 */
	public Item(String description,int id) {
		this.description=description;
		this.id=id;
	}
	/**
	 * Gets the description of this item
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return "["+id+" "+description+"]";
	}
	/**
	 * �ȱȽ�id��idһ���ٱȽ�description
	 */
	@Override
	public int compareTo(Item o) {
		int com=Integer.compare(id, o.id);
		return com!=0?com:Objects.compare(description, o.description, String::compareTo);
	}

	/**
	 * �ж�item�����Ҫid��description����ͬ
	 */
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(obj.getClass()!=this.getClass())
			return false;
		Item it=(Item)obj;
		return Objects.equals(description, it.description)&&id==it.id;
	}
	/**
	 * hashcode��id��description���
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(description,id);
	}
	
	
}

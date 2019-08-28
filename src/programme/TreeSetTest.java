package programme;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
/**
 * TreeSet是有序的集合，那就需要设计放入元素的比较方法，因此需要实现Comparable接口
 * 
 * 如果设计了equals，就必须要再设计hashcode，因为相等的东西hashcode也相同
 * @author Alice
 * @version 2019年7月24日
 */
public class TreeSetTest {
	public static void main(String[] args) {
		/**
		 * 默认先按照id排序
		 */
		SortedSet<Item> parts=new TreeSet<>();
		parts.add(new Item("Apple", 15));
		parts.add(new Item("Gun", 11));
		parts.add(new Item("Desktop", 32));
		System.out.println(parts);
		/**
		 * 设置按照description排序
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
	 * 先比较id，id一样再比较description
	 */
	@Override
	public int compareTo(Item o) {
		int com=Integer.compare(id, o.id);
		return com!=0?com:Objects.compare(description, o.description, String::compareTo);
	}

	/**
	 * 判断item相等需要id和description都相同
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
	 * hashcode和id及description相关
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(description,id);
	}
	
	
}

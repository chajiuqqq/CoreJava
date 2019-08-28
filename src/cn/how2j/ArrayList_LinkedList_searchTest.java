package cn.how2j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayList_LinkedList_searchTest {
	public static void main(String[] args) {
		int num=1000*100;
		ArrayList<Integer> arrayList=new ArrayList<>();
		create(arrayList, num);
		update(arrayList, num/2);
		LinkedList<Integer> linkedList=new LinkedList<>();
		create(linkedList, num);
		update(linkedList, num/2);
	}
	
	public static void create(List<Integer> list,int num) {
		final int value=1;
		for(int i=0;i<num;i++){
			list.add(value);
		}
	}
	public static void update(List<Integer> list,int loc) {
		long time=System.currentTimeMillis();
		int get=list.get(loc)+1;
		list.set(loc,get);
		time=System.currentTimeMillis()-time;
		System.out.printf("%s: 一次查找耗时%d毫秒\n",list.getClass().getName(),time/2);
	}
}

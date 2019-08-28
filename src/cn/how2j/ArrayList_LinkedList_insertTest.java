package cn.how2j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayList_LinkedList_insertTest {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList=new ArrayList<>();
		insert(arrayList);
		
		LinkedList<Integer> linkedList=new LinkedList<>();
		insert(linkedList);
		/**
		 * out:
		 * java.util.ArrayList: ��100000�β����ʱ1566����
			java.util.LinkedList: ��100000�β����ʱ14����
		 */
	}
	public static void insert(List<Integer> list) {
		final long total=1000*100;
		final int num=5;
		long time=System.currentTimeMillis();
		for(int i=0;i<total;i++){
			list.add(0, num);
		}
		time=System.currentTimeMillis()-time;
		System.out.printf("%s: ��%d�β����ʱ%d����\n",list.getClass().getName(),total,time);
		
	}
}

package programme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShuffleTest_9_7 {
	public static void main(String[] args) {
		List<Integer> arrays=new ArrayList<Integer>();
		for(int i=1;i<=50;i++){
			arrays.add(i);
		}
		Collections.shuffle(arrays);
		
		List<Integer> afterarray=arrays.subList(0, 6);
		Collections.sort(afterarray);
		System.out.println(afterarray);
		/**
		 * Comparator.reverseOrder()逆置Comparable接口排的顺序
		 */
		afterarray.sort(Comparator.reverseOrder());
		System.out.println(afterarray);
		/**
		 * 直接使用 Collections.reverse()逆置List
		 */
		Collections.reverse(afterarray);
		System.out.println(afterarray);
	}
}

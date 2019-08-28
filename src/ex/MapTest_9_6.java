package ex;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import cn.how2j.APHero;
import cn.how2j.Hero;

public class MapTest_9_6 {
	public static void main(String[] args) {
		Map<Integer,Hero> maps=new HashMap<>();
		maps.put(1985, new Hero("Jack",1985));
		
		/**
		 * get
		 */
		System.out.println(maps.get(1985));
		//put会返回上个这个位置存储的值，然后再用新值覆盖掉
		System.out.println(maps.put(1985, new Hero("Jack",1984)));
		System.out.println(maps.get(1985));
		
		
		/**
		 * put
		 */
		maps.put(1, new Hero("a",1));
		maps.put(2, new Hero("b",2));
		//map可以存储值的类的子类
		maps.put(3, new APHero("c",3));
		
		
		/**
		 * remove
		 */
		maps.remove(1985);
		
		
		/**
		 * forEach
		 * forEach接受一个处理key和value的lambda表达式，map里所有的键值对会调用这个表达式。
		 */
		maps.forEach((k,v)->System.out.println("key: "+k+"\tvalue: "+v));
		
		
		/**
		 * 映射视图 
		 * maps.keySet()
		 * maps.keySet()会返回key的set，再用iterator遍历这个set，同时用get获得相应val
		 */
		System.out.println("another way:-----------------------");
		Iterator<Integer> iter=maps.keySet().iterator();
		while(iter.hasNext()){
			int key=iter.next();
			Hero val=maps.get(key);
			System.out.println("key: "+key+"\tvalue: "+val);
		}
		
		/**
		 * maps.vlaues(),返回values组成的集合
		 */
		Collection<Hero> valCollection=maps.values();
		
		/**
		 * 枚举条目
		 * maps.entrySet()会返回一个Set<Map.Entry<k,v>>
		 * maps.entrySet()返回的每个元素都是实现了Map.Entry<k,v>接口的对象，所以遍历的时候用Map.Entry<k,v>来接收
		 */
		System.out.println("使用枚举条目遍历map--------------------");
		for(Map.Entry<Integer, Hero> x:maps.entrySet()){
			int k=x.getKey();
			String v=x.getValue().toString();
			System.out.println("key: "+k+"\tval: "+v);
		}
		
		System.out.println("删除view中的元素对原来的map有效，但是不能添加--------------");
		Iterator<Integer> iters=maps.keySet().iterator();
		if(iters.hasNext()){
			iters.next();
			iters.remove();
			iters.next();
			iters.remove();
		}
		maps.forEach((k,v)->System.out.println("k: "+k+" v: "+v));
	}
}

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
		//put�᷵���ϸ����λ�ô洢��ֵ��Ȼ��������ֵ���ǵ�
		System.out.println(maps.put(1985, new Hero("Jack",1984)));
		System.out.println(maps.get(1985));
		
		
		/**
		 * put
		 */
		maps.put(1, new Hero("a",1));
		maps.put(2, new Hero("b",2));
		//map���Դ洢ֵ���������
		maps.put(3, new APHero("c",3));
		
		
		/**
		 * remove
		 */
		maps.remove(1985);
		
		
		/**
		 * forEach
		 * forEach����һ������key��value��lambda���ʽ��map�����еļ�ֵ�Ի����������ʽ��
		 */
		maps.forEach((k,v)->System.out.println("key: "+k+"\tvalue: "+v));
		
		
		/**
		 * ӳ����ͼ 
		 * maps.keySet()
		 * maps.keySet()�᷵��key��set������iterator�������set��ͬʱ��get�����Ӧval
		 */
		System.out.println("another way:-----------------------");
		Iterator<Integer> iter=maps.keySet().iterator();
		while(iter.hasNext()){
			int key=iter.next();
			Hero val=maps.get(key);
			System.out.println("key: "+key+"\tvalue: "+val);
		}
		
		/**
		 * maps.vlaues(),����values��ɵļ���
		 */
		Collection<Hero> valCollection=maps.values();
		
		/**
		 * ö����Ŀ
		 * maps.entrySet()�᷵��һ��Set<Map.Entry<k,v>>
		 * maps.entrySet()���ص�ÿ��Ԫ�ض���ʵ����Map.Entry<k,v>�ӿڵĶ������Ա�����ʱ����Map.Entry<k,v>������
		 */
		System.out.println("ʹ��ö����Ŀ����map--------------------");
		for(Map.Entry<Integer, Hero> x:maps.entrySet()){
			int k=x.getKey();
			String v=x.getValue().toString();
			System.out.println("key: "+k+"\tval: "+v);
		}
		
		System.out.println("ɾ��view�е�Ԫ�ض�ԭ����map��Ч�����ǲ������--------------");
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

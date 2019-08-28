package cn.how2j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/**
 * �ƽ�����
 * 1. ����һ��������3������ַ�����������ַ������� ����

2. ����һ���ƽ��̣߳�ʹ����ٷ���ƥ��������� 

3. ����һ����־�̣߳���ӡ���ù���Щ�ַ���ȥƥ�䣬�����־�߳����Ϊ�ػ��߳�

��ʾ�� �ƽ��̰߳���ٷ����ɵĿ����������һ�������У���־�̲߳��ϵĴ�����������ó��������룬����ӡ������ ������������ǿյģ�����Ϣ1�룬������ֲ��ǿյģ��Ͳ�ͣ��ȡ��������ӡ��

 * @author Alice
 * @version 2019��8��2��
 */
public class passwordTest {
	List<Character> tank;
	public passwordTest() {
		// TODO Auto-generated constructor stub
		tank=new ArrayList<>();
		for(int i=(int)'a';i<=(int)'z';i++){
			tank.add((char)i);
		}
		for(int i=(int)'A';i<=(int)'Z';i++){
			tank.add((char)i);
		}
		for(int i=(int)'0';i<=(int)'9';i++){
			tank.add((char)i);
		}
	}
	public static void main(String[] args) {
		passwordTest t=new passwordTest();
		Set<String> possiblePassword=new HashSet<>();
		String password=t.getRandomStr();
		Runnable attack=()->{
			String str="";
			for(int i=0;i<t.tank.size();i++){
				for(int j=0;j<t.tank.size();j++){
					for(int k=0;k<t.tank.size();k++){
						str=""+t.tank.get(i)+t.tank.get(j)+t.tank.get(k);
						possiblePassword.add(str);
						if(password.equals(str))
							return;
					}
				}
			}
			
		};
		
		Runnable daily=()->{
			
			while(true){
				try {
					if(possiblePassword.isEmpty())
						Thread.sleep(1000);
					else{
						Iterator<String> iter=possiblePassword.iterator();
						while(iter.hasNext()){
							String next=iter.next();
							if(password.equals(next)){
								System.out.println("right! the answer is "+next);
								return;
							}else{
								System.out.println(next+" is not right!");
								iter.remove();
							}
								
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		};
		System.out.println("answer is "+password);
		Thread guess=new Thread(attack);
		Thread print=new Thread(daily);
		print.setDaemon(true);
		guess.start();
		print.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public String getRandomStr() {
		String str="";
		for(int i=0;i<3;i++){
			int loc=(int)(Math.random()*tank.size());
			str+=tank.get(loc);
		}
		return str;
		
	}
}

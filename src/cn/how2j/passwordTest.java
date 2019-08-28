package cn.how2j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/**
 * 破解密码
 * 1. 生成一个长度是3的随机字符串，把这个字符串当作 密码

2. 创建一个破解线程，使用穷举法，匹配这个密码 

3. 创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程

提示： 破解线程把穷举法生成的可能密码放在一个容器中，日志线程不断的从这个容器中拿出可能密码，并打印出来。 如果发现容器是空的，就休息1秒，如果发现不是空的，就不停的取出，并打印。

 * @author Alice
 * @version 2019年8月2日
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

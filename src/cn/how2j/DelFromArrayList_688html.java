package cn.how2j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DelFromArrayList_688html {
	public static void main(String[] args) {
		List<Hero> heros=new ArrayList<Hero>();
		for(int i=0;i<100;i++){
			heros.add(new Hero("Hero",i));
		}
		for(int i=0;i<heros.size();i++){
			if(heros.get(i).getId()%8==0)
				heros.remove(i);
		}
		System.out.println(heros);
	}

static class Hero{
	private String name;
	private int id;
	public Hero() {
		// TODO Auto-generated constructor stub
	}
	public Hero(String name,int id) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.id=id;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+name+" "+id+"]";
	}
	
}

}

package ex;

import java.util.ArrayList;
import java.util.Arrays;

class T<type>{
	//ArrayListÈÝÆ÷
	private ArrayList<type> list;
	
	public T(){
		list=new ArrayList<>();
	}
	public void add(type e) {
		list.add(e);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(list.toArray());
	}
}

public class DoubleBraceInitialization {
	public static void get(T<String> myT) {
		System.out.println("Get T!");
		System.out.println(myT);
	}
    public static void main(String[] args) {
    	
    	//Ë«À¨ºÅ³õÊ¼»¯
    	get(new T<String>(){{add("first");add("second");}});
    }


}

package ex;

import java.util.Arrays;
import java.util.Random;

public class string_3_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ssString="hellp";
		ssString=ssString.substring(0,ssString.length()-1)+"o";
		System.out.println(ssString);
		
		//不能用==比较两个字符串，用equals()
		String yyString="hello";
		System.out.println("ssString==yyString? "+yyString.equals(ssString));
		
		//空串和指向null
		String mmString=null;
		String ggString="";
		if(mmString!=null&&mmString.length()!=0) //判断不是null也不是空串的方法，判断null放前面
			System.out.println("not null or empty");
		else 
			System.out.println("is null or empty");
		
		//码点
		int[] codepoints=yyString.codePoints().toArray();
		System.out.println(Arrays.toString(codepoints));
		
		//大小写转换
		System.out.println(yyString.toUpperCase());
		
		//StringBuilder
		StringBuilder ssStringBuilder=new StringBuilder();
		for (int i = 0; i < 5; i++) {
			ssStringBuilder.append(i+" "+ new Random().nextInt(100)+"\n");
		}
		String ssStringBuilder2=ssStringBuilder.toString();
		System.out.println("ssStringBuilder2 :\n"+ssStringBuilder2);
		
	}

}

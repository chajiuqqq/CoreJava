package ex;

import java.util.Arrays;
import java.util.Random;

public class string_3_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ssString="hellp";
		ssString=ssString.substring(0,ssString.length()-1)+"o";
		System.out.println(ssString);
		
		//������==�Ƚ������ַ�������equals()
		String yyString="hello";
		System.out.println("ssString==yyString? "+yyString.equals(ssString));
		
		//�մ���ָ��null
		String mmString=null;
		String ggString="";
		if(mmString!=null&&mmString.length()!=0) //�жϲ���nullҲ���ǿմ��ķ������ж�null��ǰ��
			System.out.println("not null or empty");
		else 
			System.out.println("is null or empty");
		
		//���
		int[] codepoints=yyString.codePoints().toArray();
		System.out.println(Arrays.toString(codepoints));
		
		//��Сдת��
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

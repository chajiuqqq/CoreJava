package cn.how2j;

import java.io.File;
/**
 * ����C:/WINDOWS���ҳ��ļ��������ĺ���С���ļ����ļ���
 * @author Alice
 *
 */
public class How2j_FileTest1 {
	public static void main(String[] args) {
		File f=new File("C:/WINDOWS");
		File[] name=f.listFiles();
		long min=Integer.MAX_VALUE;
		long max=0;
		File minFile=null;
		File maxFile=null;
		for(int i=0;i<name.length;i++){
			if(name[i].isDirectory())
				continue;
			if(name[i].length()>max){
				max=name[i].length();
				maxFile=name[i];
			}
				
			if(name[i].length()!=0&&name[i].length()<min){
				min=name[i].length();
				minFile=name[i];
			}
				
		}
		
		System.out.println("�����ļ��ǣ� "+maxFile+" ��С�ǣ� "+max);
		System.out.println("��С���ļ��ǣ� "+minFile+" ��С�ǣ� "+min);

	}
}

package cn.how2j;

import java.io.File;
/**
 * ����"C:\\Users\\Alice\\Documents\\Tencent Files"�����ļ��У��ҳ��ļ��������ĺ���С�ġ�
 * @author Alice
 *
 */
public class How2j_FileTest2 {
	
	File minFile=null;
	File maxFile=null;
	long min=Integer.MAX_VALUE;
	long max=0;
	
	public void visit(File file)  {
		
		if(file.isFile()){
			if(file.length()>max){
				max=file.length();
				maxFile=file;
			}
			if(file.length()!=0&&file.length()<min){
				min=file.length();
				minFile=file;
			}
			
		}
		
		if(file.isDirectory()){
			File[] f=file.listFiles();
			if(null!=f)
				for(File x:f)
					visit(x);
		}
	}
	
	public static void main(String[] args) {
		How2j_FileTest2 h=new How2j_FileTest2();
		File myFile=new File("C:\\Users\\Alice\\Documents\\Tencent Files");
		h.visit(myFile);
		System.out.println("�����ļ��ǣ� "+h.maxFile+" ��С�ǣ� "+h.max);
		System.out.println("��С���ļ��ǣ� "+h.minFile+" ��С�ǣ� "+h.min);

	}
}

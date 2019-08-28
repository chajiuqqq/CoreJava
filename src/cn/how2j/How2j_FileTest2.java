package cn.how2j;

import java.io.File;
/**
 * 遍历"C:\\Users\\Alice\\Documents\\Tencent Files"下子文件夹，找出文件长度最大的和最小的。
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
		System.out.println("最大的文件是： "+h.maxFile+" 大小是： "+h.max);
		System.out.println("最小的文件是： "+h.minFile+" 大小是： "+h.min);

	}
}

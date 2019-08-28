package cn.how2j;

import java.io.File;
/**
 * 遍历C:/WINDOWS，找出文件长度最大的和最小的文件或文件夹
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
		
		System.out.println("最大的文件是： "+maxFile+" 大小是： "+max);
		System.out.println("最小的文件是： "+minFile+" 大小是： "+min);

	}
}

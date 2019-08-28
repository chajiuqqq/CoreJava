package ex;

import java.io.File;
import java.io.IOException;

/**
 * 批量创建文件，并查看，然后删除
 * @author Alice
 *
 */
public class TestFile2 {
	public static void main(String[] args) throws IOException {
		File root=new File("myroot");
		root.mkdir();
		String filename;
		//创建20个doc文件
		for(int i=0;i<20;i++){
			int ch=i+'A';
			filename=(char)ch+" File.doc";
			File myFile=new File(root,filename);
			myFile.createNewFile();
		}
		
		
		//随机删除10个
		for(int i=0;i<10;i++){
			int delnum=(int)(Math.random()*10)+'A';
			File delfile=new File(root,(char)delnum+" File.doc");
			delfile.delete();
		}
		
		//打印剩下的文件
		String[] allfilename=root.list();
		for(String x:allfilename){
			System.out.println(x);
		}
		
	}
}

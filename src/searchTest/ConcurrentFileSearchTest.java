package searchTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * 多线程寻找内容包含str的后缀为java的文件
 * @author Alice
 * @version 2019年8月2日
 */
public class ConcurrentFileSearchTest {
	public void search(File filePath,String str)  {
		if(filePath==null)
			return;
		File[] files=filePath.listFiles();
		if(files==null){
			System.out.println("空文件夹或者不是文件夹路径");
			return;
		}
		for(File x:files){
			if(x.isDirectory()){
				search(x, str);
			}else if(x.getAbsolutePath().endsWith("java")){
				Runnable r=()->{
					try(FileReader fReader=new FileReader(x)){
						char[] chGet=new char[(int)x.length()];
						fReader.read(chGet);
						String strGet=String.valueOf(chGet);
						if(strGet.contains(str))
							System.out.printf("找到包含%s的文件：%s\n",str,x.getAbsolutePath());
					}catch(IOException e){
						e.printStackTrace();
					}
				};
				Thread t=new Thread(r);
				t.start();
			}
		}
	}
	public static void main(String[] args) {
		FileSearchTest aFileSearchTest=new FileSearchTest();
		File srcPath=new File("E:\\project\\CoreJava\\src\\ex");
		String findString="main";
		long time=System.currentTimeMillis();
		aFileSearchTest.search(srcPath, findString);
		time=System.currentTimeMillis()-time;
		System.out.println("多线程耗时："+time+"毫秒");
	}
}

package searchTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SearchByThreadPool {
	ThreadPoolExecutor myPool=new ThreadPoolExecutor(10,15,60,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
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
				myPool.execute(r);
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

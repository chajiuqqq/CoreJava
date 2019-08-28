package ex;

import java.io.File;
import java.io.IOException;
import java.util.Date;
/**
 * 了解file类的构造方法和方法
 * 
 * @author Alice
 * @version 2019年7月19日
 */
public class TestFile {
	public static void main(String[] args) throws IOException {
		/**
		 * 通过调用file不同的构造方法了解如何建立file对象，并了解如何获得其绝对路径
		 */
		File f1=new File("d:/LOLFolder");
		System.out.println(f1.getAbsolutePath());
		
		File f2=new File("LOL.exe");
		System.out.println(f2.getAbsolutePath());
		
		File f3=new File(f1,"LOL.exe");
		System.out.println(f3.getAbsolutePath());
		
		/**
		 * file的常用方法
		 */
		f2.createNewFile();
		
		System.out.println(f2);
		System.out.println(f2.exists());
		System.out.println(f2.isFile());
		System.out.println(f2.isDirectory());
		System.out.println(f2.length());
		
		long time=f2.lastModified();
		Date date=new Date(time);
		System.out.println(date);
		
		f2.setLastModified(0);
		
		File nFile=new File("E:/project/CoreJava/DOTA.exe");
		f2.renameTo(nFile);
		//lol确实改成了dota，但是f2指向的仍旧是lol.exe没改，所以打印仍旧是LOL.exe
		System.out.println(f2);
	}
}

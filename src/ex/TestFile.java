package ex;

import java.io.File;
import java.io.IOException;
import java.util.Date;
/**
 * �˽�file��Ĺ��췽���ͷ���
 * 
 * @author Alice
 * @version 2019��7��19��
 */
public class TestFile {
	public static void main(String[] args) throws IOException {
		/**
		 * ͨ������file��ͬ�Ĺ��췽���˽���ν���file���󣬲��˽���λ�������·��
		 */
		File f1=new File("d:/LOLFolder");
		System.out.println(f1.getAbsolutePath());
		
		File f2=new File("LOL.exe");
		System.out.println(f2.getAbsolutePath());
		
		File f3=new File(f1,"LOL.exe");
		System.out.println(f3.getAbsolutePath());
		
		/**
		 * file�ĳ��÷���
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
		//lolȷʵ�ĳ���dota������f2ָ����Ծ���lol.exeû�ģ����Դ�ӡ�Ծ���LOL.exe
		System.out.println(f2);
	}
}

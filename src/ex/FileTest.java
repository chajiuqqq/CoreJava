package ex;

import java.io.File;
/**
 * ��ȡE:\cfvedioĿ¼��������ļ��ʹ�ӡ���Ǹ��ļ��������Ŀ¼�ʹ�ӡ���Ǹ�Ŀ¼
 * @author Alice
 * @version 2019/7/19
 */
public class FileTest {
	
	public static void main(String[] args) {
		String path="E:\\cfvedio";
		File f=new File(path);
		if(f.isDirectory()){
			String[] content=f.list();
			for(int i=0;i<content.length;i++){
				File ef=new File(path,content[i]);
				if(ef.isDirectory()){
					System.out.println(content[i] + " is a directory.");
				}else{
					System.out.println(content[i] + " is a file.");
				}
			}
		}else{
			System.out.println("it's not a directory.");
		}
		
	}
}
